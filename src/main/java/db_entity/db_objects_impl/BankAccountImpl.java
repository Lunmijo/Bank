package db_entity.db_objects_impl;

import db_entity.db_objects_i.BankAccount;

public class BankAccountImpl implements BankAccount {
    private int ID, UserID;
    private String currency;
    private double avaliableMoney;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAvaliableMoney(double avaliableMoney) {
        this.avaliableMoney = avaliableMoney;
    }

    public int getID() {
        return ID;
    }


    public double getAvaliableMoney() {
        return avaliableMoney;
    }

    public String getCurrency() {
        return currency;
    }


    public int getUserID() {
        return UserID;
    }
}
