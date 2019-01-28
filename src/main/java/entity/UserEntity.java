package entity;

public class UserEntity {
    private int ID, bankUAHAccountID, bankEURAccountID, bankUSDAccountID;
    private String firstName, lastName;

    public UserEntity() { }

    public UserEntity(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.firstName = lastName;
    }

    public UserEntity(int ID, String firstName, String lastName, int bankEURAccountID, int bankUAHAccountID, int bankUSDAccountID) {
        this.ID = ID;
        this.firstName = firstName;
        this.firstName = lastName;
        this.bankEURAccountID = bankEURAccountID;
        this.bankUAHAccountID = bankUAHAccountID;
        this.bankUSDAccountID = bankUSDAccountID;
    }

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
