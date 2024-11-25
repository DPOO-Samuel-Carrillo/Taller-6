package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "nuevo";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "ver";

    private JButton butNuevo;
    private JButton butCerrar;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar( VentanaAgregarRestaurante ventanaPrincipal )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout(new FlowLayout());

        // Agrega el botón para crear el restaurante
        JButton btnCrearRestaurante = new JButton("Crear Restaurante");
        btnCrearRestaurante.addActionListener(e -> {
            ventanaPrincipal.agregarRestaurante(); // Método en la ventana principal para manejar la creación
        });
        add(btnCrearRestaurante);

        // Agrega el botón para cerrar la ventana
        JButton btnCerrarVentana = new JButton("Cerrar");
        btnCerrarVentana.addActionListener(e -> {
            ventanaPrincipal.dispose(); // Cierra la ventana principal
        });
        add(btnCerrarVentana);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CREAR ) )
        {
            ventanaPrincipal.agregarRestaurante( );
        }
        else if( comando.equals( CERRAR ) )
        {
            ventanaPrincipal.cerrarVentana( );
        }
    }

	public JButton getButCerrar() {
		return butCerrar;
	}

	public void setButCerrar(JButton butCerrar) {
		this.butCerrar = butCerrar;
	}

	public JButton getButNuevo() {
		return butNuevo;
	}

	public void setButNuevo(JButton butNuevo) {
		this.butNuevo = butNuevo;
	}
}
