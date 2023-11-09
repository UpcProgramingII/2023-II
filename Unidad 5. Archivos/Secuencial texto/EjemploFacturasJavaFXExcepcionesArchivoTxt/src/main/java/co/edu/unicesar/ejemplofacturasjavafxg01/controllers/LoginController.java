/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.App;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Usuario;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.Login;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin, btnCancelar;

    @FXML
    public void clickLogin(ActionEvent e) throws IOException {

        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();

        try {
            Login.validarLogin(username, password);
//            if (Login.getUsuarioLogeado() != null) {
            App.newStage("principal", true, 1600, 1000);
//            } else {
//                
//                Utility.notificarError("Login no valido", "Sus credenciales de ingreso no son validas, intenete nuevamente");
//                
//            }
        } catch (IllegalStateException ie) {

            Utility.notificarMensaje("Validacion campos vacios", ie.getMessage(), Alert.AlertType.ERROR);

        } catch (Exception ie) {
            Utility.notificarMensaje("Validacion de login", ie.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void clickCancelar(ActionEvent e) {
        this.txtUsername.setText(null);
        this.txtPassword.setText(null);
        this.txtUsername.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
