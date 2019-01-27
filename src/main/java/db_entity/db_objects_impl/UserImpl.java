package db_entity.db_objects_impl;

import db_entity.db_objects_i.User;

public class UserImpl implements User {
    private int ID, bankUAHAccountID, bankEURAccountID, bankUSDAccountID;
    private String firstName, lastName;

    public void setID(int id) {
        this.ID = id;
    }

    public int getBankEURAccountID() {
        return this.bankEURAccountID;
    }

    public int getBankUSDAccountID() {
        return this.bankUSDAccountID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBankUAHAccountID(int id) {
        this.bankUAHAccountID = id;
    }

    public void setBankEURAccountID(int id) {
        this.bankEURAccountID = id;
    }

    public void setBankUSDAccountID(int id) {
        this.bankUSDAccountID = id;
    }

    public int getID() {
                return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBankUAHAccountID() {
        return bankUAHAccountID;
    }

}
