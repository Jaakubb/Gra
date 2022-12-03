package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloController {
    @FXML
    ComboBox tabela_class;
    @FXML
    protected void graj(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gra.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("aplikacja.css").toExternalForm());

        nextStage.setTitle("Gra");
        nextStage.setScene(scene);
        nextStage.show();
        GraController graController= fxmlLoader.getController();
        graController.init((String) tabela_class.getValue());

    }
    @FXML private javafx.scene.control.Button zamknij;


    @FXML
    private void wyjscie(){
        Node closeButton = null;
        Stage stage = (Stage) zamknij.getScene().getWindow();
        stage.close();
    }
}