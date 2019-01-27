package db_entity.db_objects_i;

public interface User {

    void setID(int id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setBankUAHAccountID(int id);
    void setBankEURAccountID(int id);
    void setBankUSDAccountID(int id);

    int getID();
    String getFirstName();
    String getLastName();
    int getBankUAHAccountID();
    int getBankEURAccountID();
    int getBankUSDAccountID();


}
