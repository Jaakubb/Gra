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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public void init(String klasa,String nazwa) {
        this.gracz = new Gracz(klasa, nazwa);
System.out.println("debug:"+nazwa);
        System.out.println("debug:"+this.gracz.nazwa);
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
    public void init(String klasa, String nazwa, int obr, int hp, int mana, int lvl, int exp){
        this.gracz = new Gracz(klasa,nazwa,obr,hp,mana,lvl,exp);


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
    private void zapisz() throws IOException {

        //String path = "/gracz.json";


        JSONObject json = new JSONObject();
        try {
            json.put("hp", this.gracz.hp);
            json.put("mana", this.gracz.mana);
            json.put("lvl", this.gracz.lvl);
            json.put("obr", this.gracz.obr);
            json.put("exp", this.gracz.exp);
            json.put("klasa", this.gracz.klasa);
            json.put("nazwa", this.gracz.nazwa);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        try (PrintWriter out = new PrintWriter("gracz.json")) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("debug:" + this.gracz.nazwa);

        String dane_do_wyslania = json.toString();
        byte[] postData = dane_do_wyslania.getBytes(StandardCharsets.UTF_8);
        String url = "http://localhost:8080/hello";
        HttpURLConnection con = null;
        try {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "test");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

                wr.write(postData);
            }
            StringBuilder content;

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8"))) {
                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    System.out.println(br);
                    content.append(line);
                    System.out.println(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());

        } finally {//con.disconnect();
        }


    }
}