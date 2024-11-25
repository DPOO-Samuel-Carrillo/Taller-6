package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.PanelDetallesRestaurante;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.setVentanaPrincipal(principal);
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        PanelMapaAgregar panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        JPanel panelSur = new JPanel(new BorderLayout());
        PanelDetallesRestaurante panelDetalles = new PanelDetallesRestaurante();
        PanelBotonesAgregar panelBotones = new PanelBotonesAgregar(this);

        panelSur.add(panelDetalles, BorderLayout.CENTER); // Panel con detalles del restaurante
        panelSur.add(panelBotones, BorderLayout.SOUTH);   // Panel con los botones de acción

        add(panelSur, BorderLayout.SOUTH);
        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
    	String labNombre = panelDetalles.getNombre();
        int labCalificacion = panelDetalles.getCalificacion();
        boolean chkVisitado = panelDetalles.getVisitado();
        
        ventanaPrincipal.agregarRestaurante(labNombre, labCalificacion, chkVisitado);
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

	public PanelEditarRestaurante getPanelDetalles() {
		return panelDetalles;
	}

	public void setPanelDetalles(PanelEditarRestaurante panelDetalles) {
		this.panelDetalles = panelDetalles;
	}

	public PanelBotonesAgregar getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotonesAgregar panelBotones) {
		this.panelBotones = panelBotones;
	}

	public PanelMapaAgregar getPanelMapa() {
		return panelMapa;
	}

	public void setPanelMapa(PanelMapaAgregar panelMapa) {
		this.panelMapa = panelMapa;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

}
