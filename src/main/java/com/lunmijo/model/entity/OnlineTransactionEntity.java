package com.lunmijo.model.entity;

public class OnlineTransactionEntity {
    private int ID;
    private int fromAccountID;
    private int toAccountID;
    private double sum;
    private String currency;
    private String currencyRateDay;

    public OnlineTransactionEntity() { }

    public OnlineTransactionEntity(int ID, int fromAccountID, int toAccountID, double sum, String currencyRateDay, String currency) {
        this.ID = ID;
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.currency = currency;
        this.currencyRateDay = currencyRateDay;
        this.sum = sum;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFromAccountID() {
        return fromAccountID;
    }

    public void setFromAccountID(int fromAccountID) {
        this.fromAccountID = fromAccountID;
    }

    public int getToAccountID() {
        return toAccountID;
    }

    public void setToAccountID(int toAccountID) {
        this.toAccountID = toAccountID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyRateDay() {
        return currencyRateDay;
    }

    public void setCurrencyRateDay(String currencyRateDay) {
        this.currencyRateDay = currencyRateDay;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
