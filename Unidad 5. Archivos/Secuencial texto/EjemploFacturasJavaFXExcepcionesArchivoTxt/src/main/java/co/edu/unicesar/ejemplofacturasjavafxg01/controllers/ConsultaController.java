/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.dtos.FacturaDto;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Factura;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.FacturaContado;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.LogicaFactura;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class ConsultaController implements Initializable {

    @FXML
    private TableView<FacturaDto> tablaFacturas;
    @FXML
    private ComboBox cmbFiltro;
    @FXML
    private TableColumn columnNoFactura;
    @FXML
    private TableColumn columnValorFactura;
    @FXML
    private TableColumn columnFechaFactura;
    @FXML
    private TableColumn columnMedioPago;
    @FXML
    private TableColumn columnFechaPago;
    @FXML
    private TableColumn columnPlazo;
    @FXML
    private TableColumn columnValor;

    private ObservableList<FacturaDto> data;
    private LogicaFactura logica=new LogicaFactura();

    @FXML
    private void clickFiltro(){
        
        this.leerTablaFacturas();
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.columnNoFactura.setCellValueFactory(new PropertyValueFactory("noFactura"));
        this.columnValorFactura.setCellValueFactory(new PropertyValueFactory("valorFactura"));
        this.columnFechaFactura.setCellValueFactory(new PropertyValueFactory("fechaFactura"));
        this.columnMedioPago.setCellValueFactory(new PropertyValueFactory("medioPago"));
        this.columnFechaPago.setCellValueFactory(new PropertyValueFactory("fechaPago"));
        this.columnPlazo.setCellValueFactory(new PropertyValueFactory("plazoMaximo"));
        this.columnValor.setCellValueFactory(new PropertyValueFactory("valorPagar"));
        
        ObservableList filtro = FXCollections.observableArrayList("Todas","Contado","Credito");
        this.cmbFiltro.setItems(filtro);
        this.cmbFiltro.getSelectionModel().select(0);
        
        this.data=FXCollections.observableArrayList();
        
        this.leerTablaFacturas();
        
    }
    
    public void leerTablaFacturas(){
        
        List<Factura> listaFacturas;
        switch (this.cmbFiltro.getSelectionModel().getSelectedIndex()) {
            case 0:
                listaFacturas = this.logica.consultarFacturas();
                break;
            case 1:
                listaFacturas = this.logica.consultarFacturasContado();
                break;
            default:
                listaFacturas = this.logica.consultarFacturasCredito();
                break;
        }
        
        this.data.clear();
        for(Factura f: listaFacturas){
            FacturaDto dto = new FacturaDto(f);
            this.data.add(dto);
        }
        this.tablaFacturas.setItems(this.data);
    
    }

}
