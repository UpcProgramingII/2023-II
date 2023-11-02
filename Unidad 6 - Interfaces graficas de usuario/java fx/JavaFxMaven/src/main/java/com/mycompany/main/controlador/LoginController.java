package com.mycompany.main.controlador;

import com.mycompany.main.App;
import com.mycompany.main.Logic.ListUser;
import com.mycompany.main.Logic.SingletonSesionUsuario;
import com.mycompany.main.model.User;
import com.mycompany.main.utility.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;


import javax.swing.JOptionPane;

public class LoginController implements Initializable {

   
    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnCancelar;

    private ListUser userModel = new ListUser();
    private HBox ventanaPrincipal;

    @FXML
    public void eventKeyTxtUserName(KeyEvent ke) {
        //ke.consume();
    }

    ;
    
    
    @FXML
    public void eventKeytxtPassword(KeyEvent e) {
//        if(e.getCharacter().equals(" ")){
//            e.consume();
//        }
    }

    @FXML
    public void eventActionBtnIngresar(ActionEvent e) throws IOException {

       this.newLoginUser();

    }

    @FXML
    public void eventActionBtnCancelar(ActionEvent e) {
        this.txtUserName.setText("");
        this.txtPassword.setText("");
        this.txtUserName.requestFocus();
    }

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Utility.validateCharacterEmptyTextField(this.txtUserName);
        Utility.validateCharacterEmptyPasswordField(txtPassword);
    }

    

    public void newLoginUser() throws IOException {

        String userName = this.txtUserName.getText();
        String password = this.txtPassword.getText();
        try {
            User userLogin = this.userModel.getUser(userName);
            if(userLogin.getPassword().equals(password)){
               
                SingletonSesionUsuario.setUsuarioActivo(userLogin);
                App.newStage("Principal", true);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Password incorrecto", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                this.txtPassword.requestFocus();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException ioe){
            throw ioe;
        }
    }

}
