package com.example.gra;

public class Gracz {
    public String klasa;
    public int hp;
    public int obr;
    public int mana;
    public int exp;
    public int lvl;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getObr() {
        return obr;
    }
    public void setObr(int obr) {
        this.obr = obr;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    Gracz(String klasa){
        this.klasa=klasa;
        switch(klasa){
            case "Mag":
                this.hp = 1000;
                this.obr= 100;
                this.mana = 50;
                this.exp = 0;
                this.lvl = 0;

                break;


            case "Wojownik":
                this.hp = 750;
                this.obr= 225;
                this.mana=30;
                this.exp = 0;
                this.lvl= 0;

                break;
            default:
                this.hp = 750;
                this.obr= 225;
                this.mana=30;
                this.exp = 0;
                this.lvl= 0;
                break;
        }
    }
    Gracz(String klasa, int obr, int hp, int mana, int lvl, int exp){
        this.klasa=klasa;
        this.obr=obr;
        this.hp=hp;
        this.mana=mana;
        this.lvl=lvl;
        this.exp=exp;


    }
}
