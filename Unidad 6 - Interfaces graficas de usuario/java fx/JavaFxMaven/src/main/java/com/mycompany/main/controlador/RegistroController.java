package com.mycompany.main.controlador;

import com.mycompany.main.Logic.ListProduct;
import com.mycompany.main.Logic.SingletonListProduct;
import com.mycompany.main.model.Product;
import com.mycompany.main.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class RegistroController implements Initializable {

    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtStock;

    @FXML
    private Button btnGuardar, btnCancelar;

    private ListProduct productModel = SingletonListProduct.getInstance();

    @FXML
    public void validateKeyTypedStock(KeyEvent e) {

    }

    @FXML
    public void actionBtnGuardar() {
        String description = this.txtDescripcion.getText();
        double price = 0;
        if (!this.txtPrecio.getText().isEmpty()) {
            //price = (double) this.txtPrecio.getTextFormatter().getValue();
            //System.out.println("precio:"+price);
           //price = Double.valueOf(this.txtPrecio.getText());
            price=(double)this.txtPrecio.getTextFormatter().getValue();
        }
        int stock = 0;
        if (!this.txtStock.getText().isEmpty()) {
            stock = (int)(this.txtStock.getTextFormatter().getValue());
        }

        Product product = new Product(description, price, stock);
        try {
            this.productModel.insertProduct(product);
            JOptionPane.showMessageDialog(null,
                    "El producto ha sido registrado exitosamente",
                    "Menssaje de exito",
                    JOptionPane.INFORMATION_MESSAGE);
                    this.resetValuesTextField();

        } catch (IllegalArgumentException ie) {
            JOptionPane.showMessageDialog(null,
                    ie.getMessage(),
                    "Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void actionBtnCancelar() {
           this.resetValuesTextField();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Utility.setMaskFormattedIntegerTextField(this.txtStock);
        Utility.setMaskFormattedCurrencyTextField(this.txtPrecio);
        
    }
    
    private void resetValuesTextField(){
        this.txtDescripcion.setText(null);
       
        TextFormatter format = this.txtPrecio.getTextFormatter();
        format.setValue(0.0);
        
        format=this.txtStock.getTextFormatter();
        format.setValue(0);
        
        this.txtDescripcion.requestFocus();
    }
}