/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.*;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.LogicaFactura;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.Utility;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class RegistroController implements Initializable {

    @FXML
    private RadioButton rContado, rCredito;
    @FXML
    private TextField txtNoFactura, txtValorFactura, txtPlazoMaximo;
    @FXML
    private DatePicker dpFechaFactura, dpFechaPago;
    @FXML
    private ComboBox<String> cmbMedioPago;
    @FXML
    private Button btnGuardar, btnCancelar;

    private LogicaFactura logica = new LogicaFactura();
    private ObservableList<String> listMedioPago = FXCollections.observableArrayList();

    @FXML
    private void clickGuardar() {

        Factura nuevaFactura;
        String nofactura = this.txtNoFactura.getText();
        String valorFactura = this.txtValorFactura.getText();
        LocalDate fechaFactura = this.dpFechaFactura.getValue();
        String tipo = this.rContado.isSelected() ? "contado" : "credito";
        char medioPago = this.cmbMedioPago.getSelectionModel().getSelectedIndex() == 0 ? 'T' : 'C';
        LocalDate fechaPago = this.dpFechaPago.getValue();
        String plazoMaximo = this.txtPlazoMaximo.getText();

        try {
            nuevaFactura = this.logica.crearFactura(nofactura, fechaFactura, valorFactura, tipo, medioPago, fechaPago, plazoMaximo);
            this.logica.registrarFactura(nuevaFactura);
            Utility.notificarMensaje("Registro exitoso", "La factura ha sido registrada con exito", Alert.AlertType.INFORMATION);
            this.limpiarComponentes();
        } catch(NumberFormatException nfe){
            Utility.notificarMensaje("Validacion de datos", "Se requiere un valor numerico", Alert.AlertType.ERROR);
        }
        catch (IllegalArgumentException ae) {
            Utility.notificarMensaje("Validacion campos vacios", ae.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void clickCancelar() {
        this.limpiarComponentes();
    }

    @FXML
    private void clickContado() {
        this.activarComponentes();
    }

    @FXML
    private void clickCredito() {
        this.activarComponentes();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.listMedioPago.add("Tarjeta");
        this.listMedioPago.add("Contado");
        this.cmbMedioPago.setItems(listMedioPago);

        this.activarComponentes();

    }

    public void limpiarComponentes() {
        this.txtNoFactura.setText(null);
        this.txtPlazoMaximo.setText(null);
        this.txtValorFactura.setText(null);
        this.rContado.setSelected(true);
        this.cmbMedioPago.setItems(listMedioPago);
        this.dpFechaFactura.setValue(null);
        this.dpFechaPago.setValue(null);
        this.txtNoFactura.requestFocus();
    }

    public void activarComponentes() {
        this.txtPlazoMaximo.setDisable(this.rContado.isSelected());
        this.cmbMedioPago.setDisable(this.rCredito.isSelected());
        this.dpFechaPago.setDisable(this.rCredito.isSelected());
        this.cmbMedioPago.getSelectionModel().select(0);
    }

    
}
