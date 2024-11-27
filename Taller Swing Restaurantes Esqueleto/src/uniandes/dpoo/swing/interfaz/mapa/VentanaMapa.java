package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    /**
     * El comando para reconocer al radio que muestra sólo los restaurantes visitados
     */
    private static final String VISITADOS = "VISITADOS";

    /**
     * El comando para reconocer al radio que muestra todos los restaurantes
     */
    private static final String TODOS = "TODOS";

    /**
     * El panel con el mapa
     */
    private PanelMapaVisualizar panelMapa;

    /**
     * El radio button para hacer que se muestren todos los restaurantes. Si este está activo, radioVisitados debe estar inactivo.
     */
    private JRadioButton radioTodos;

    /**
     * El radio button para hacer que se muestren sólo los restaurantes visitados. Si este está activo, radioTodos debe estar inactivo.
     */
    private JRadioButton radioVisitados;

    /**
     * La referencia a la ventana principal
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa( VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Mapa de Restaurantes");
        setLayout(new BorderLayout());

        // Inicializa el panel del mapa y lo añade
        panelMapa = new PanelMapaVisualizar();
        panelMapa.actualizarMapa(restaurantes); // Inicializa con todos los restaurantes
        add(panelMapa, BorderLayout.CENTER);

        // Configura los RadioButtons
        JPanel panelOpciones = new JPanel(new FlowLayout());

        radioTodos = new JRadioButton("Mostrar Todos", true);
        radioTodos.setActionCommand(TODOS);
        radioTodos.addActionListener(this);

        radioVisitados = new JRadioButton("Solo Visitados");
        radioVisitados.setActionCommand(VISITADOS);
        radioVisitados.addActionListener(this);

        // Grupo para que solo un botón esté seleccionado
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(radioTodos);
        grupoBotones.add(radioVisitados);

        // Añade los RadioButtons al panel
        panelOpciones.add(radioTodos);
        panelOpciones.add(radioVisitados);

        add(panelOpciones, BorderLayout.SOUTH);

        // Configuración de la ventana
        pack();
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( TODOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( true ) );
        }
        else if( VISITADOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( false ) );
        }
    }

	public JRadioButton getRadioTodos() {
		return radioTodos;
	}

	public void setRadioTodos(JRadioButton radioTodos) {
		this.radioTodos = radioTodos;
	}

	public JRadioButton getRadioVisitados() {
		return radioVisitados;
	}

	public void setRadioVisitados(JRadioButton radioVisitados) {
		this.radioVisitados = radioVisitados;
	}

}
