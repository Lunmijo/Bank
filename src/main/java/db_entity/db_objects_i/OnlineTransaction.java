package db_entity.db_objects_i;

public interface OnlineTransaction {

    void setID(int ID);
    void setCurrency(String currency);
    void setToAccountID(int toAccountID);
    void setFromAccountID(int fromAccountID);
    void setSum(double sum);
    void setCurrencyRateDay(String currencyRateDay);

    int getID();
    String getCurrency();
    int getToAccountID();
    int getFromAccountID();
    double getSum();
    String getCurrencyRateDay();

}
