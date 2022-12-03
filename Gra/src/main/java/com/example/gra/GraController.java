package com.example.gra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class GraController {
    private Gracz gracz;
    private ObservableList<Przeciwnik> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Przeciwnik, String> nazwa_p;
    @FXML
    private TableColumn<Przeciwnik, Integer> hp_p;
    @FXML
    private TableColumn<Przeciwnik, Integer> obr_p;
    @FXML
    private TableView<Przeciwnik> tabela;
    @FXML
    protected void atakuj(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atak.fxml"));
        Stage nextStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        scene.getStylesheets().add(getClass().getResource("aplikacja.css").toExternalForm());

        nextStage.setTitle("Gra");
        nextStage.setScene(scene);
        nextStage.show();
    }
    public void init(String klasa) {
        gracz = new Gracz(klasa);

        Random r = new Random();
        int obrlos = 100 + r.nextInt(200);
        int hplos = 400 + r.nextInt(1500);

        data.add(new Przeciwnik("ork", hplos, obrlos));
        data.add(new Przeciwnik("ork", 500, 200));
        data.add(new Przeciwnik("troll", 1200, 90));
        System.out.println(tabela);
        tabela.itemsProperty().setValue(data);
        nazwa_p.setCellValueFactory(
                new PropertyValueFactory<Przeciwnik, String>("nazwa_p")
        );
        hp_p.setCellValueFactory(
                new PropertyValueFactory<Przeciwnik, Integer>("hp_p")
        );
        obr_p.setCellValueFactory(
                new PropertyValueFactory<Przeciwnik, Integer>("obr_p")
        );


    }
    @FXML
    private void wylosuj(){
        data.clear();
        Random rand = new Random();

    }



}
