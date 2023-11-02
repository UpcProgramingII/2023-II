/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.*;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.LogicaFactura;
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
        int noFactura = Integer.valueOf(this.txtNoFactura.getText());
        double valorFactura = Double.valueOf(this.txtValorFactura.getText());
        LocalDate fechaFactura = this.dpFechaFactura.getValue();
        if (this.rContado.isSelected()) {
            char medioPago = this.cmbMedioPago.getSelectionModel().getSelectedIndex() == 0 ? 'T' : 'C';
            LocalDate fechaPago = this.dpFechaPago.getValue();
            nuevaFactura = new FacturaContado(medioPago, fechaPago, fechaFactura, valorFactura);
        } else {
            int plazoMaximo = Integer.valueOf(this.txtPlazoMaximo.getText());
            nuevaFactura = new FacturaCredito(plazoMaximo, fechaFactura, valorFactura);
        }
        nuevaFactura.setConsecutivo(noFactura);
        this.logica.registrarFactura(nuevaFactura);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro exitoso");
        alert.setHeaderText(null);
        alert.setContentText("La factura ha sido registrada con exito");
        alert.initOwner(null);
        alert.showAndWait();
        this.limpiarComponentes();
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
    }

}
