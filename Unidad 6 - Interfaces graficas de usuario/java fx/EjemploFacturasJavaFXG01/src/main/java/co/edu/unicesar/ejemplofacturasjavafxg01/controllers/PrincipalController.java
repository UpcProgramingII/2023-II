/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.App;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class PrincipalController implements Initializable {

    @FXML
    private Label btnRegistro, btnConsulta, lbUsuario;
    @FXML
    private StackPane panelOpciones;
    
    

    
    @FXML
    private void clcikRegistro() throws IOException {
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("registro"));
        this.panelOpciones.getChildren().add(pane);
    }

    @FXML
    private void clickConsulta() throws IOException {
        this.panelOpciones.getChildren().clear();
        StackPane pane = new StackPane(App.loadFXML("consulta"));
        this.panelOpciones.getChildren().add(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.lbUsuario.setText(Login.getUsuarioLogeado().getNombre() + " " + Login.getUsuarioLogeado().getApellido());
    }

}
