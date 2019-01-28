package crud_classes.implementations;

import crud_classes.interfaces.CurrentRates;
import entity.CurrentRateEntity;
import executors.RatesQueryExecutor;
import executors.GeneralQueryExecutor;

import java.util.List;

public class CurrentRatesAccess implements CurrentRates {

    public void saveRate(CurrentRateEntity currentRateEntity) {
        String insert = "insert into \"Current_Rates\"(\"Date\", \"UAHtoUSD\", \"UAHtoEUR\", \"USDtoUAH\", \"EURtoUAH\", \"USDtoEUR\", \"EURtoUSD\"values (" +
                currentRateEntity.getDate() + ", " +
                "\'" + currentRateEntity.getUAHtoUSD() + "\'" + ", " +
                "\'" + currentRateEntity.getUAHtoEUR() + "\'" + ", " +
                "\'" + currentRateEntity.getUSDtoUAH() + "\'" + ", " +
                "\'" + currentRateEntity.getEURtoUAH() + "\'" + ", " +
                "\'" + currentRateEntity.getUSDtoEUR() + "\'" + ", " +
                currentRateEntity.getEURtoUSD() + ")";
        GeneralQueryExecutor.executeQueryWithoutResult(insert);
    }

    public void updateRate(CurrentRateEntity currentRateEntity) {
        String update = "update \"Current_Rates\" set \"UAHtoUSD\"=" + currentRateEntity.getUAHtoUSD() + ", " +
                "\"UAHtoUSD\"=" + "\'" + currentRateEntity.getUAHtoUSD() + "\'" + ", " +
                "\"UAHtoEUR\"=" + "\'" + currentRateEntity.getUAHtoEUR() + "\'" + ", " +
                "\"USDtoUAH\"=" + "\'" + currentRateEntity.getUSDtoUAH() + "\'" + ", " +
                "\"EURtoUAH\"=" + "\'" + currentRateEntity.getEURtoUAH() + "\'" + ", " +
                "\"USDtoEUR\"=" + "\'" + currentRateEntity.getUSDtoEUR() + "\'" + ", " +
                "\"EURtoUSD\"=" + "\'" + currentRateEntity.getEURtoUSD() + "\'";
        GeneralQueryExecutor.executeQueryWithoutResult(update);
    }

    public void deleteRate(CurrentRateEntity currentRateEntity) {
        String delete = "delete from \"Current_Rates\" where \"Date\"=" + "\'" + currentRateEntity.getDate() + "\'";
        GeneralQueryExecutor.executeQueryWithoutResult(delete);
    }

    public List<CurrentRateEntity> findAllByDate(String date) {
        String select = "select * from \"Current_Rates\"";
        return RatesQueryExecutor.getRatesByQuery(select);
    }
}
