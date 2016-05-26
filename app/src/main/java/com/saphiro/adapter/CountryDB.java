package com.saphiro.adapter;

/**
 * Created by Saphiro on 5/25/2016.
 */
public class CountryDB {


    int id;
    String enName, viName, flag;
    long population;

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getViName() {
        return viName;
    }

    public void setViName(String viName) {
        this.viName = viName;
    }

    public CountryDB() {
    }

    public CountryDB(String flag, String enName, String viName) {
        this.flag = flag;
        this.viName = viName;
        this.enName = enName;
    }


}
