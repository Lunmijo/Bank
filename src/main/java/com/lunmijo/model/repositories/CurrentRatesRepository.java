package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.CurrentRateEntity;
import com.lunmijo.model.services.GeneralService;
import com.lunmijo.model.services.RatesService;

import java.util.List;

public class CurrentRatesRepository {

    public static void saveRate(CurrentRateEntity currentRateEntity) {
        String insert = "insert into \"Current_Rates\"(\"Date\", \"UAHtoUSD\", \"UAHtoEUR\", \"USDtoUAH\", \"EURtoUAH\", \"USDtoEUR\", \"EURtoUSD\"values (" +
                currentRateEntity.getDate() + ", " +
                "\'" + currentRateEntity.getUAHtoUSD() + "\'" + ", " +
                "\'" + currentRateEntity.getUAHtoEUR() + "\'" + ", " +
                "\'" + currentRateEntity.getUSDtoUAH() + "\'" + ", " +
                "\'" + currentRateEntity.getEURtoUAH() + "\'" + ", " +
                "\'" + currentRateEntity.getUSDtoEUR() + "\'" + ", " +
                currentRateEntity.getEURtoUSD() + ")";
        GeneralService.executeQueryWithoutResult(insert);
    }

    public static void updateRate(CurrentRateEntity currentRateEntity) {
        String update = "update \"Current_Rates\" set \"UAHtoUSD\"=" + currentRateEntity.getUAHtoUSD() + ", " +
                "\"UAHtoUSD\"=" + "\'" + currentRateEntity.getUAHtoUSD() + "\'" + ", " +
                "\"UAHtoEUR\"=" + "\'" + currentRateEntity.getUAHtoEUR() + "\'" + ", " +
                "\"USDtoUAH\"=" + "\'" + currentRateEntity.getUSDtoUAH() + "\'" + ", " +
                "\"EURtoUAH\"=" + "\'" + currentRateEntity.getEURtoUAH() + "\'" + ", " +
                "\"USDtoEUR\"=" + "\'" + currentRateEntity.getUSDtoEUR() + "\'" + ", " +
                "\"EURtoUSD\"=" + "\'" + currentRateEntity.getEURtoUSD() + "\'";
        GeneralService.executeQueryWithoutResult(update);
    }

    public static void deleteRate(CurrentRateEntity currentRateEntity) {
        String delete = "delete from \"Current_Rates\" where \"Date\"=" + "\'" + currentRateEntity.getDate() + "\'";
        GeneralService.executeQueryWithoutResult(delete);
    }

    public static CurrentRateEntity findByDate(String date) {
        String select = "select * from \"Current_Rates\" where \"Date\"=" + "\'" + date + "\'";
        return RatesService.getRateByQuery(select);
    }
    public static List<CurrentRateEntity> findAll() {
        String select = "select * from \"Current_Rates\"";
        return RatesService.getRatesByQuery(select);
    }
}
