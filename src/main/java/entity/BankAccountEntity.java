package entity;

public class BankAccountEntity {
    private int ID, UserID;
    private String currency;
    private double avaliableMoney;

    public BankAccountEntity() { }

    public BankAccountEntity(int ID, int UserID, String currency, double avaliableMoney) {
        this.ID = ID;
        this.UserID = UserID;
        this.currency = currency;
        this.avaliableMoney = avaliableMoney;
    }

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
