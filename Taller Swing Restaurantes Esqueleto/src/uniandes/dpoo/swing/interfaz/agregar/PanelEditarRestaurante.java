package uniandes.dpoo.swing.interfaz.agregar;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JCheckBox cbbVisitado;

    public PanelEditarRestaurante( )
    {
    	setLayout(new GridLayout(3, 2, 10, 10)); 

        
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20); 
        add(lblNombre);
        add(txtNombre);

        
        JLabel lblCalificacion = new JLabel("Calificación:");
        JComboBox<Integer> cbbCalificacion = new JComboBox<>(); 
        for (int i = 1; i <= 5; i++) {
            cbbCalificacion.addItem(i); 
        }
        add(lblCalificacion);
        add(cbbCalificacion);

       
        JLabel lblVisitado = new JLabel("Visitado:");
        cbbVisitado = new JCheckBox();
        add(lblVisitado);
        add(cbbVisitado);
    
            
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
        return cbbVisitado.isSelected();
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
    	return txtNombre.getText().trim();
    }

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

}