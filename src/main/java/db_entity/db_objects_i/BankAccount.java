package db_entity.db_objects_i;

public interface BankAccount {

    void setID(int ID);
    void setUserID(int userID);
    void setCurrency(String currency);
    void setAvaliableMoney(double avaliableMoney);

    int getID();
    int getUserID();
    String getCurrency();
    double getAvaliableMoney();

}
