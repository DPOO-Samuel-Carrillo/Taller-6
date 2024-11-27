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

        butNuevo = new JButton("Crear Restaurante");
        butNuevo.setActionCommand(CREAR);
        butNuevo.addActionListener(this);
        add(butNuevo);

        // Agrega el botón para cerrar la ventana
        butCerrar = new JButton("Cerrar");
        butCerrar.addActionListener(e -> {
            ventanaPrincipal.dispose(); // Cierra la ventana principal
        });
        add(butCerrar);
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
