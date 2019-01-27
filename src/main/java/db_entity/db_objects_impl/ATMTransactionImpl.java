package db_entity.db_objects_impl;

import db_entity.db_objects_i.ATMTransaction;

public class ATMTransactionImpl implements ATMTransaction {
    private int ID, bankAccountID;
    private double sum;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBankAccountID(int bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getID() {
        return this.ID;
    }

    public int getBankAccountID() {
        return this.bankAccountID;
    }

    public double getSum() {
        return this.sum;
    }
}
