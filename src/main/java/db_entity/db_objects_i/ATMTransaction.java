package db_entity.db_objects_i;

public interface ATMTransaction {

    void setID(int ID);
    void setBankAccountID(int bankAccountID);
    void setSum(double sum);

    int getID();
    int getBankAccountID();
    double getSum();

}
