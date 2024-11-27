package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
        this.ventanaPrincipal=principal;
        setLayout( new BorderLayout( ) );

        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);
        panelMapa = new PanelMapaAgregar();
        
        add(panelMapa, BorderLayout.CENTER);
        
        JPanel South = new JPanel();
        South.setLayout(new BorderLayout());
        South.add(panelDetalles, BorderLayout.CENTER);
        South.add(panelBotones, BorderLayout.SOUTH);
        add(South, BorderLayout.SOUTH);
        
        pack( );
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
    	int[] coordenadas = panelMapa.getCoordenadas();
    	int coordenadasx = coordenadas[0];
    	int coordenadasy= coordenadas[1];
    	
    	String labNombre = panelDetalles.getNombre();
        int labCalificacion = panelDetalles.getCalificacion();
        boolean chkVisitado = panelDetalles.getVisitado();
        
        ventanaPrincipal.agregarRestaurante(labNombre, labCalificacion, coordenadasx, coordenadasy, chkVisitado);
        cerrarVentana();
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
