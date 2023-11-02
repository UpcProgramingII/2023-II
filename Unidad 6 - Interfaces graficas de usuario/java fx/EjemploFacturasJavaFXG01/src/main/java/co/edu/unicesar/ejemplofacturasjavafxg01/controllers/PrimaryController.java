package co.edu.unicesar.ejemplofacturasjavafxg01.controllers;

import co.edu.unicesar.ejemplofacturasjavafxg01.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        //App.newStage("secondary", false);
    }
}
