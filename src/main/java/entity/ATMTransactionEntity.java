package entity;

public class ATMTransactionEntity {
    private int ID, bankAccountID;
    private double sum;

    public ATMTransactionEntity() { }

    public ATMTransactionEntity(int ID, int bankAccountID, double sum) {
        this.ID = ID;
        this.bankAccountID = bankAccountID;
        this.sum = sum;
    }

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
