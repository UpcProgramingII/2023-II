package com.mycompany.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        scene = new Scene(loadFXML("Login"));
        //scene = new Scene(loadFXML("principal"));
        //scene = new Scene(loadFXML("Registro"));

        stage.setScene(scene);
        stage.setTitle("Registro de productos");
        stage.show();

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("vista/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void newStage(String fxml, boolean modo) throws IOException {
        //Node node = (Node) (component);
        //Scene scene = node.getScene();
        Window window = scene.getWindow();
        Stage stage = (Stage) window;
        
        if(!modo)
        stage.hide();

        Parent newNode = App.loadFXML(fxml);

        /**
         * Para mostrar la ventana prinipal como nueva escene
         */
        scene =new Scene(newNode);
        //stage.setScene(scene);
        //stage.show();
        
        /**
         * Para mostrar la ventana prinipal como nueva stage
         */
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle(stage.getTitle());
        newStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
