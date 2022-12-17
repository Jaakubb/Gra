package com.example.gra;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        AtakConntroller atakController= fxmlLoader.getController();
        atakController.init(gracz,tabela.getSelectionModel().getSelectedItem());
    }
    public void init(String klasa) {
        this.gracz = new Gracz(klasa);


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

        pos_id.setText(klasa);
        pos_hp.setText(String.valueOf(gracz.hp));
        pos_exp.setText(String.valueOf(gracz.exp));
        pos_obr.setText(String.valueOf(gracz.obr));
        pos_mana.setText(String.valueOf(gracz.mana));
        pos_lvl.setText(String.valueOf(gracz.lvl));

        if (gracz.hp<0){
            nie_zyjesz.setText("Nie żyjesz");

        }


    }
    public void init(Gracz gracz) {
        this.gracz= gracz;

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
        pos_id.setText(this.gracz.klasa);
        pos_hp.setText(String.valueOf(this.gracz.hp));
        pos_exp.setText(String.valueOf(this.gracz.exp));
        pos_obr.setText(String.valueOf(this.gracz.obr));
        pos_mana.setText(String.valueOf(this.gracz.mana));
        pos_lvl.setText(String.valueOf(this.gracz.lvl));

        if (gracz.hp<0) {
            nie_zyjesz.setText("Nie żyjesz");
        }
    }
    public void init(String klasa, int obr, int hp, int mana, int lvl, int exp){
        this.gracz = new Gracz(klasa,obr,hp,mana,lvl,exp);


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

        pos_id.setText(klasa);
        pos_hp.setText(String.valueOf(gracz.hp));
        pos_exp.setText(String.valueOf(gracz.exp));
        pos_obr.setText(String.valueOf(gracz.obr));
        pos_mana.setText(String.valueOf(gracz.mana));
        pos_lvl.setText(String.valueOf(gracz.lvl));

        if (gracz.hp<0){
            nie_zyjesz.setText("Nie żyjesz");

        }
    }


    @FXML
    private Label pos_id;
    @FXML
    private Label pos_hp;
    @FXML
    private Label pos_exp;
    @FXML
    private Label pos_obr;
    @FXML
    private Label pos_mana;
    @FXML
    private Label pos_lvl;
    @FXML
    private Label nie_zyjesz;



    @FXML
    private void wylosuj(){
        data.clear();
        data.add(new Przeciwnik());
        data.add(new Przeciwnik());
        data.add(new Przeciwnik());
        data.add(new Przeciwnik());
        data.add(new Przeciwnik());


    }

    @FXML
    private void zapisz(){

        //String path = "/gracz.json";
        JSONObject json = new JSONObject();
        try {
            json.put("hp", gracz.hp);
            json.put("mana", gracz.mana);
            json.put("lvl",gracz.lvl);
            json.put("obr", gracz.obr);
            json.put("exp",gracz.exp);
            json.put("klasa",gracz.klasa);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        try (PrintWriter out = new PrintWriter("gracz.json")) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}