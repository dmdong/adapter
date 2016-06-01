package com.saphiro.adapter;

/**
 * Created by Saphiro on 5/9/2016.
 */
public class Country {


    String en;
    String vi;
    int flagID;

    public Country(String en, String vi) {
        this.en = en;
        this.vi = vi;
    }

    public Country(String en, String vi, int flagID) {
        this.en = en;
        this.vi = vi;
        this.flagID = flagID;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVi() {
        return vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }

    public int getFlagID() {
        return flagID;
    }

    public void setFlagID(int flagID) {
        this.flagID = flagID;
    }


}
