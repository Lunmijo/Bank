package com.lunmijo.model.entity;

public class CurrentRateEntity {
    private String date;
    private double UAHtoUSD;
    private double UAHtoEUR;
    private double USDtoUAH;
    private double EURtoUAH;
    private double EURtoUSD;
    private double USDtoEUR;

    public CurrentRateEntity() { }

    public CurrentRateEntity(String date, double UAHtoUSD, double UAHtoEUR, double USDtoUAH, double EURtoUAH, double EURtoUSD, double USDtoEUR) {
        this.date = date;
        this.UAHtoUSD = UAHtoUSD;
        this.UAHtoEUR = UAHtoEUR;
        this.USDtoUAH = USDtoUAH;
        this.EURtoUAH = EURtoUAH;
        this.EURtoUSD = EURtoUSD;
        this.USDtoEUR = USDtoEUR;
    }

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
