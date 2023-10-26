package vista;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Jairo F
 */
public class JDConsulta extends JDialog {
    private Container contenedor;
    
    private JPanel panelBusqueda, panelPpal;
    private JScrollPane panelResultado;
    
    private RowSorter ordenadorTabla;
    
    private JLabel lbBusqueda;
    private JComboBox cmbBusqueda;
    private JTable tabla;
    private JButton boton;
    
    private DefaultTableModel modeloTabla;
    private String titulos[] = {"No Factura", "Fecha factura", "Valor factura", "Forma pago","Fecha Pago", "Plazo Maximo", "Valor a pagar"};
    private String contenido[][]={null,null};
    
   
    public JDConsulta(JFrame owner, boolean modal) {
        super(owner, modal);
        this.iniciarComponentes();
        
        this.setTitle("SRF Listado de facturas registradas - Version 1");
        this.setSize(1200, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        
        this.panelPpal = new JPanel(new BorderLayout());
        this.panelPpal.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
      
        this.setLayout(new BorderLayout());
        this.iniciarPanelBusqueda();
        this.iniciarPanelResultado();
        
        this.contenedor.add(this.panelPpal);
        
    }
  
    
    public void iniciarPanelBusqueda(){
        this.panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.panelBusqueda.setBorder(BorderFactory.createTitledBorder("Filtro de busqueda"));
        
        this.lbBusqueda=new JLabel("Tipo de factura: ");
        this.cmbBusqueda = new JComboBox();
       
        this.panelBusqueda.add(this.lbBusqueda);
        this.panelBusqueda.add(this.cmbBusqueda);
      
        this.panelPpal.add(this.panelBusqueda, BorderLayout.NORTH);
    
    }
    
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        this.panelResultado.setBorder(BorderFactory.createTitledBorder("Resultados de consulta"));
        this.tabla = new JTable();
        this.modeloTabla= new DefaultTableModel(this.contenido, this.titulos);
        this.tabla.setModel(this.modeloTabla);
        
        //permite que la tabla ordene sus valores segun la columna a la que se da click
        this.ordenadorTabla = new TableRowSorter(this.modeloTabla);
        this.tabla.setRowSorter(ordenadorTabla);
        this.panelResultado.setViewportView(this.tabla);
        this.panelPpal.add(this.panelResultado);
        
    }
    
    
    
    
    
}
