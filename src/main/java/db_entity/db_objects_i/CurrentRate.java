package db_entity.db_objects_i;

public interface CurrentRate {

    void setDate(String date);
    void setEURtoUAH(double EURtoUAH);
    void setEURtoUSD(double EURtoUSD) ;
    void setUAHtoEUR(double UAHtoEUR);
    void setUAHtoUSD(double UAHtoUSD);
    void setUSDtoUAH(double USDtoUAH);
    void setUSDtoEUR(double USDtoEUR);


    double getEURtoUAH();
    double getEURtoUSD();
    double getUAHtoEUR();
    double getUAHtoUSD();
    double getUSDtoEUR();
    double getUSDtoUAH();
    String getDate();

}
