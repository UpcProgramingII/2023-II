/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.App;
import co.edu.unicesar.ejemplofacturasjavafxg01.entidades.Usuario;
import co.edu.unicesar.ejemplofacturasjavafxg01.logica.Login;
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
    
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin, btnCancelar;
    
    @FXML
    public void clickLogin(ActionEvent e) throws IOException{
        
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        Login.validarLogin(username, password);
        if(Login.getUsuarioLogeado()!=null){
            App.newStage("principal", true,1600, 900);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login no valido");
            alert.setHeaderText(null);
            alert.setContentText("Sus credenciales de ingreso no son validas, intenete nuevamente");
            alert.initOwner(null);
            alert.showAndWait();
        }
        
    }
    
    @FXML
    public void clickCancelar(ActionEvent e){
         this.txtUsername.setText(null);
         this.txtPassword.setText(null);
         this.txtUsername.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
