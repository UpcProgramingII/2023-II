package com.mycompany.main.controlador;

import com.mycompany.main.Logic.ListUser;
import com.mycompany.main.dto.UserDto;
import com.mycompany.main.model.User;
import com.mycompany.main.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
public class UsuariosController implements Initializable {

    @FXML
    private TextField txtNombre, txtApellido, txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox cmbPrivilegio;
    @FXML
    private Button btnCancelar, btnCrear, btnModificar, btnEliminar;
    @FXML
    private TableColumn tableColumnUser, tableColumnPassword, tableColumnNombre, tableColumnApellido, tableColumnPrivilegio;
    @FXML
    private TableView tableUsers;

    private ObservableList<UserDto> users;
    private ListUser model = new ListUser();

    @FXML
    public void clickTableUser() {

        int index = this.tableUsers.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            this.setEnableButtons(false);
        } else {
            this.setEnableButtons(true);
        }

    }

    @FXML
    public void actionBtnCancelar(ActionEvent e) {
        this.resetValuesVentana();
        this.txtNombre.requestFocus();
    }

    @FXML
    public void actionBtnCrear(ActionEvent e) {
        this.newUser();
    }

    @FXML
    public void actionBtnModificar(ActionEvent e) {
    }

    @FXML
    public void actionBtnEliminar(ActionEvent e) {
    }

    @FXML
    public void keyTypedtxtPassword(KeyEvent e) {
    }

    @FXML
    public void keyTypedtxtUserName(KeyEvent e) {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Utility.validateCharacterEmptyPasswordField(this.txtPassword);
        Utility.validateCharacterEmptyTextField(this.txtNombre);

        this.cmbPrivilegio.getItems().add("Admin");
        this.cmbPrivilegio.getItems().add("User");

        this.tableColumnUser.setCellValueFactory(new PropertyValueFactory("nameUser"));
        this.tableColumnPassword.setCellValueFactory(new PropertyValueFactory("password"));
        this.tableColumnNombre.setCellValueFactory(new PropertyValueFactory("name"));
        this.tableColumnApellido.setCellValueFactory(new PropertyValueFactory("lstName"));
        this.tableColumnPrivilegio.setCellValueFactory(new PropertyValueFactory("isAdmin"));

        this.users = FXCollections.observableArrayList();
        this.castListUser();
        this.tableUsers.setItems(this.users);

        this.setEnableButtons(true);

    }

    public void castListUser() {
        for (User u : this.model.getListUsers()) {

            UserDto dto = new UserDto(u);
            System.out.println(dto.getNameUser());
            this.users.add(dto);
        }
    }

    private User getUserFromScene() {
        String userName = this.txtUserName.getText();
        String password = this.txtPassword.getText();
        String name = this.txtNombre.getText();
        String lastName = this.txtApellido.getText();
        String rol;
        boolean isAdmin = false;
        User user = null;
        if (this.cmbPrivilegio.getSelectionModel().getSelectedIndex() >= 0) {
            rol = this.cmbPrivilegio.getSelectionModel().getSelectedItem().toString();
            isAdmin = rol.equals("Admin") ? true : false;
            user = new User(userName, password, name, lastName, isAdmin);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No ha seleccionado el tipo de privilegio del usuario",
                    "Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    private void newUser() {

        User user = this.getUserFromScene();
        if (user != null) {
            try {
                this.model.insertUser(user);
                UserDto dto = new UserDto(user);
                this.users.add(dto);
                JOptionPane.showMessageDialog(null,
                        "El usuario ha sido registrado exitosamente",
                        "Menssaje de exito",
                        JOptionPane.INFORMATION_MESSAGE);

                this.resetValuesVentana();
                this.txtNombre.requestFocus();

            } catch (IllegalStateException | IllegalArgumentException ie) {
                JOptionPane.showMessageDialog(null,
                        ie.getMessage(),
                        "Mensaje de error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetValuesVentana() {
        this.txtNombre.setText(null);
        this.txtApellido.setText(null);
        this.txtUserName.setText(null);
        this.txtPassword.setText(null);
        this.cmbPrivilegio.getSelectionModel().select(-1);
    }

    private void setEnableButtons(boolean enable) {
        this.btnEliminar.setDisable(enable);
        this.btnModificar.setDisable(enable);
    }

}
