package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AtakConntroller {

    private Gracz gracz;
    private Przeciwnik przeciwnik;

    public void init(Gracz gracz, Przeciwnik przeciwnik) {
        this.gracz = gracz;
this.przeciwnik=przeciwnik;
        pos_hp2.setText(String.valueOf(this.gracz.hp));
        pos_mana2.setText(String.valueOf(this.gracz.mana));

        prz_hp.setText(String.valueOf(this.przeciwnik.hp_p));
    }

    @FXML
    private Label pos_hp2;
    @FXML
    private Label pos_mana2;
    @FXML
    private Label prz_hp;

    @FXML
    protected void powrot(ActionEvent event) throws IOException {
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
        graController.init(gracz);

    }
    @FXML
    private void lecz(){
        gracz.hp+=100;
        pos_hp2.setText(String.valueOf(gracz.hp));

    }
    @FXML
    private void walcz() {
        this.przeciwnik.hp_p-=this.gracz.obr;
        this.gracz.hp-=this.przeciwnik.obr_p;
        pos_hp2.setText(String.valueOf(this.gracz.hp));
        prz_hp.setText(String.valueOf(this.przeciwnik.hp_p));

    }

}
