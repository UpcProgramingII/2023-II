package com.mycompany.main.controlador;

import com.mycompany.main.App;
import com.mycompany.main.Logic.SingletonSesionUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class PrincipalController implements Initializable {
    @FXML
    private StackPane panel;
    
    @FXML  private Button btnRegistro, btnConsulta, btnUsuario;
   
    private VBox panelConsulta, panelRegistro, panelUsuario;
       
    @FXML
    public void eventActionBtnRegistro(ActionEvent e){
        this.panelConsulta.setVisible(false);
        this.panelUsuario.setVisible(false);
        this.panelRegistro.setVisible(true);
    }
    
    @FXML
    public void eventActionBtnConsulta(ActionEvent e) throws IOException{
        
         this.panel.getChildren().remove(this.panelConsulta);
         this.panelConsulta=new VBox(App.loadFXML("Consulta"));
         this.panel.getChildren().add(this.panelConsulta);
         this.panelRegistro.setVisible(false);
         this.panelUsuario.setVisible(false);
    }
    
    
    @FXML
    public void eventActionBtnUsuario(ActionEvent e){
        this.panelConsulta.setVisible(false);
        this.panelUsuario.setVisible(true);
        this.panelRegistro.setVisible(false);
    }
    
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.panelConsulta = new VBox(App.loadFXML("Consulta"));
            this.panelRegistro=new VBox(App.loadFXML("Registro"));
            this.panelUsuario=new VBox(App.loadFXML("Usuarios"));
            
            this.panel.getChildren().add(this.panelUsuario);
            this.panel.getChildren().add(this.panelRegistro);
            this.panel.getChildren().add(this.panelConsulta);
            
            if(SingletonSesionUsuario.getUsuarioActivo().isIsAdmin()){
                this.btnUsuario.setVisible(true);
            }
            else{
                 this.btnUsuario.setVisible(false);
            }
            
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }    
    
}
