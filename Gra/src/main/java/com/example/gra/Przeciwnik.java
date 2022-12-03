package com.example.gra;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    public Przeciwnik(String nazwa_p, int hp_p, int obr_p){
        this.hp_p =   hp_p;
        this.obr_p = obr_p;
        this.nazwa_p = new String(nazwa_p);

    }

}
