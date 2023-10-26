/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import entidades.Factura;
import entidades.FacturaContado;
import entidades.FacturaCredito;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import logica.LogicaFactura;

/**
 *
 * @author Jairo F
 */
public class JDRegistro extends JDialog{
    
    private JLabel lbNoFactura, lbFechaFactura, lbValorFactura, lbTipoFactura, lbFechaPago;
    private JLabel lbMedioPago,  lbPlazoMaximo;
    
    private JButton btnNuevo, btnGuardar, btnBuscar, btnCancelar, btnEliminar;
    
    private JTextField txtNoFactura;
    
    private JFormattedTextField txtfValorFactura, txtFechaFactura, txtFechaPago, txtfPlazoMaximo;
    
    private JComboBox cmbMedioPago;
    
    private JRadioButton rCredito, rContado;
    
    private JPanel panelDatos, panelBotones;
    
    private Container contenedor;
    
    private LogicaFactura modelo;

   

    public JDRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.modelo = new LogicaFactura();
        
        this.initComponents();
        this.setTitle("SRF - Gestion de facturas ");
        //this.pack();
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    private void initComponents(){
        
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        
        this.initPanelDatos();
        this.initPanelBotones();
        
        this.activarComponentes(false);
        
    }
    
    
    private void initPanelDatos(){
        
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(7,2, 5,5));
        
        this.lbFechaFactura = new JLabel("Fecha factura (dd/mm/aaaa): ");
        this.lbFechaPago= new JLabel("Fecha pago (dd/mm/aaaa): ");
        this.lbMedioPago= new JLabel("Medio pago: ");
        this.lbNoFactura= new JLabel("No factura: ");
        this.lbPlazoMaximo= new JLabel("Plazo maximo: ");
        this.lbTipoFactura= new JLabel("Tipo factura: ");
        this.lbValorFactura= new JLabel("Valor factura: ");
        
       
        this.txtNoFactura= new JTextField(null);
        
        this.txtFechaFactura = new JFormattedTextField(new Date());
        this.txtFechaPago  = new JFormattedTextField(new Date());
        this.txtfPlazoMaximo = new JFormattedTextField(0);
        this.txtfValorFactura = new JFormattedTextField(0.00);
        
        this.cmbMedioPago = new JComboBox();
        this.cmbMedioPago.addItem("Tarjeta");
        this.cmbMedioPago.addItem("Efectivo");
        
        this.rContado = new JRadioButton("Contado");
        this.rContado.setSelected(true);
        this.rCredito = new JRadioButton("Credito");
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTipo.add(this.rContado);
        panelTipo.add(this.rCredito);
        
        ButtonGroup bgTipo = new ButtonGroup();
        bgTipo.add(this.rContado);
        bgTipo.add(this.rCredito);
        
        this.panelDatos.add(this.lbNoFactura);
        this.panelDatos.add(this.txtNoFactura);
        
        this.panelDatos.add(this.lbFechaFactura);
        this.panelDatos.add(this.txtFechaFactura);
        
        this.panelDatos.add(this.lbValorFactura);
        this.panelDatos.add(this.txtfValorFactura);
        
        this.panelDatos.add(this.lbTipoFactura);
        this.panelDatos.add(panelTipo);
        
        this.panelDatos.add(this.lbMedioPago);
        this.panelDatos.add(this.cmbMedioPago);
        
        this.panelDatos.add(this.lbFechaPago);
        this.panelDatos.add(this.txtFechaPago);
        
        this.panelDatos.add(this.lbPlazoMaximo);
        this.panelDatos.add(this.txtfPlazoMaximo);
        
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
               
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
    
    }
    
    private void initPanelBotones(){
        
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(7,1,5,5));
        
        this.btnNuevo = new JButton("Nuevo");
        this.btnNuevo.addActionListener(new ClickBtnNuevo());
        this.btnGuardar= new JButton("Guardar");
        this.btnGuardar.addActionListener(new ClickBtnGuardar());
        this.btnEliminar= new JButton("Eliminar");
        this.btnCancelar= new JButton("Cancelar");
        this.btnBuscar= new JButton("Buscar");
        
        this.panelBotones.add(this.btnNuevo);
        this.panelBotones.add(this.btnGuardar);
        this.panelBotones.add(this.btnCancelar);
        this.panelBotones.add(this.btnBuscar);
        this.panelBotones.add(this.btnEliminar);
        
        JPanel panelGrid = new JPanel();
        panelGrid.setSize(400, 400);
        panelGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelGrid.add(this.panelBotones);
        
        this.contenedor.add(panelGrid, BorderLayout.EAST);
    
    }
    
    private void activarComponentes(boolean value){
        
        this.txtNoFactura.setEnabled(value);
        this.txtfValorFactura.setEnabled(value);
        this.txtFechaPago.setEnabled(value);
        this.txtFechaFactura.setEnabled(value);
        this.txtfPlazoMaximo.setEnabled(value);
        
        this.btnGuardar.setEnabled(value);
        this.btnNuevo.setEnabled(!value);
        
    }
    
    private Factura crearFacturaDesdeComponentes(){
        
        int noFactura = Integer.valueOf(this.txtNoFactura.getText());
        double valor = (double)this.txtfValorFactura.getValue();
        Date fecha = (Date)this.txtFechaFactura.getValue();
        LocalDate fechaFactura = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(this.rContado.isSelected()){
            char medioPago = this.cmbMedioPago.getSelectedIndex()==0?'T':'E';
            fecha = (Date)this.txtFechaPago.getValue();
            LocalDate fechaPago = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return new FacturaContado(medioPago, fechaPago, fechaFactura, valor);
        }else{
           
            int plazo = (int)this.txtfPlazoMaximo.getValue();
            return new FacturaCredito(plazo, fechaFactura, valor);
        }
        
       
    }
    
    class ClickBtnNuevo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           activarComponentes(true);
           txtNoFactura.grabFocus();
        }
    
    }

    class ClickBtnGuardar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           Factura nueva = crearFacturaDesdeComponentes();
           modelo.registrarFactura(nueva);
           activarComponentes(false);
           
            System.out.println(modelo.consultarFacturas().size());
        }
    
    }
  
    
    
    
    
}
