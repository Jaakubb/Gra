package com.example.gra;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Przeciwnik {
    public int hp_p;
    public int obr_p;
    public String nazwa_p;

    public int getHp_p() {
        return hp_p;
    }
    public void setHp_p(int hp_p) {
        this.hp_p = hp_p;
    }
    public int getObr_p() {
        return obr_p;
    }
    public void setObr_p(int obr_p) {
        this.obr_p = obr_p;
    }
    public String getNazwa_p() {
        return nazwa_p;
    }
    public void setNazwa_p(String nazwa_p) {
        this.nazwa_p = nazwa_p;
    }
    public Przeciwnik(){
        Random r = new Random();
        hp_p = 400 + r.nextInt(1500);
        obr_p = 100 + r.nextInt(200);

        ArrayList<String> list = new ArrayList<>();
        list.add("ork");
        list.add("troll");
        list.add("diabeł");
        list.add("goblin");
        list.add("wróżka");
        list.add("wampir");
        list.add("wilkołak");
        list.add("golem");
        list.add("centaur");
        list.add("ogr");
        nazwa_p =list.get(r.nextInt(10));

    }

    public Przeciwnik(String nazwa_p, int hp_p, int obr_p){
        this.hp_p =   hp_p;
        this.obr_p = obr_p;
        this.nazwa_p = new String(nazwa_p);

    }

}
