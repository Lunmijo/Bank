package db_entity.db_objects_impl;

import db_entity.db_objects_i.CurrentRate;

public class CurrentRateImpl implements CurrentRate {
    private String date;
    private double UAHtoUSD, UAHtoEUR, USDtoUAH, EURtoUAH, EURtoUSD, USDtoEUR;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public double getUAHtoUSD() {
        return UAHtoUSD;
    }

    public void setUAHtoUSD(double UAHtoUSD) {
        this.UAHtoUSD = UAHtoUSD;
    }

    public double getUAHtoEUR() {
        return UAHtoEUR;
    }

    public void setUAHtoEUR(double UAHtoEUR) {
        this.UAHtoEUR = UAHtoEUR;
    }

    public double getUSDtoUAH() {
        return USDtoUAH;
    }

    public void setUSDtoUAH(double USDtoUAH) {
        this.USDtoUAH = USDtoUAH;
    }

    public double getEURtoUAH() {
        return EURtoUAH;
    }

    public void setEURtoUAH(double EURtoUAH) {
        this.EURtoUAH = EURtoUAH;
    }

    public double getEURtoUSD() {
        return EURtoUSD;
    }

    public void setEURtoUSD(double EURtoUSD) {
        this.EURtoUSD = EURtoUSD;
    }

    public double getUSDtoEUR() {
        return USDtoEUR;
    }

    public void setUSDtoEUR(double USDtoEUR) {
        this.USDtoEUR = USDtoEUR;
    }
}
