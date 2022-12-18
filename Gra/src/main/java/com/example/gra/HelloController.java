package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HelloController {
    @FXML
    ComboBox tabela_class;
    @FXML
    TextField nazwa;

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
        graController.init((String) tabela_class.getValue(), nazwa.getText());

    }
    @FXML private javafx.scene.control.Button zamknij;


    @FXML
    private void wyjscie(){
        Node closeButton = null;
        Stage stage = (Stage) zamknij.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void wczytaj(ActionEvent event) throws IOException {
        String content = Files.readString(Path.of("gracz.json"));
        JSONObject a = new JSONObject(content);

            String klasa = (String) a.get("klasa");
            String nazwa = (String) a.get("nazwa");
            int obr= (int) a.get("obr");
            int hp= (int) a.get("hp");
            int mana= (int) a.get("mana");
            int lvl = (int) a.get("lvl");
            int exp = (int) a.get("exp");

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

        graController.init(klasa,nazwa,obr,hp,mana,lvl,exp);
    }
}