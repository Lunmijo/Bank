package db_entity.db_objects_impl;

import db_entity.db_objects_i.OnlineTransaction;

public class OnlineTransactionImpl implements OnlineTransaction {
    private int ID, fromAccountID, toAccountID;
    private String currency;

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

    String currencyRateDay;
    double sum;
}
