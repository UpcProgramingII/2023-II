package com.mycompany.main.controlador;

import com.mycompany.main.Logic.ListProduct;
import com.mycompany.main.Logic.SingletonListProduct;
import com.mycompany.main.dto.ProductDto;
import com.mycompany.main.model.Product;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class ConsultaController implements Initializable {

    @FXML
    private TableView<ProductDto> tablaProducto;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn columnDescription;

    @FXML
    private TableColumn columnValor;

    @FXML
    private TableColumn columnStock;

    @FXML
    private TableColumn columnId;

    private ListProduct productModel = SingletonListProduct.getInstance();
    private ObservableList<ProductDto> data;

    @FXML
    public void keyTypedTxtNombre(KeyEvent e) {
        String str = this.txtNombre.getText();
        this.data.clear();
        this.castListProducts(this.productModel.findProductByDescription(str));

    }

    @FXML
    public void actionBtnEliminar() {
        ProductDto dtoSeleccionado = this.tablaProducto.getSelectionModel().getSelectedItem();
        int index = this.tablaProducto.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            try {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "¿Esta seguro de elimnar el producto?",
                        "Eliminar",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {

                    Product productoSeleccionado = this.productModel.findProductById(dtoSeleccionado.getId());
                    this.productModel.deleteProduct(productoSeleccionado);
                    this.data.remove(index);
                    // this.tablaProducto.setItems(this.data);

                }

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Menssaje de error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Ingreso");
        this.columnDescription.setCellValueFactory(new PropertyValueFactory("description"));
        this.columnValor.setCellValueFactory(new PropertyValueFactory("price"));
        this.columnStock.setCellValueFactory(new PropertyValueFactory("stock"));
        this.columnId.setCellValueFactory(new PropertyValueFactory("id"));

        this.data = FXCollections.observableArrayList();
        this.castListProducts(this.productModel.getListProduct());
        this.tablaProducto.setItems(this.data);
        
        for(Product p: this.productModel.getListProduct()){
            System.out.println(p);
        }
    }

    public void castListProducts(List<Product>list) {
        for (Product p : list) {
            ProductDto dto = new ProductDto(p);
            this.data.add(dto);
        }
    }

}
