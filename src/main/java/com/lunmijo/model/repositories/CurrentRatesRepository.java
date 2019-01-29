package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.CurrentRateEntity;
import com.lunmijo.model.services.GeneralService;
import com.lunmijo.model.services.RatesService;

import java.util.List;

public class CurrentRatesRepository {

    public void saveRate(CurrentRateEntity currentRateEntity) {
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

    public void updateRate(CurrentRateEntity currentRateEntity) {
        String update = "update \"Current_Rates\" set \"UAHtoUSD\"=" + currentRateEntity.getUAHtoUSD() + ", " +
                "\"UAHtoUSD\"=" + "\'" + currentRateEntity.getUAHtoUSD() + "\'" + ", " +
                "\"UAHtoEUR\"=" + "\'" + currentRateEntity.getUAHtoEUR() + "\'" + ", " +
                "\"USDtoUAH\"=" + "\'" + currentRateEntity.getUSDtoUAH() + "\'" + ", " +
                "\"EURtoUAH\"=" + "\'" + currentRateEntity.getEURtoUAH() + "\'" + ", " +
                "\"USDtoEUR\"=" + "\'" + currentRateEntity.getUSDtoEUR() + "\'" + ", " +
                "\"EURtoUSD\"=" + "\'" + currentRateEntity.getEURtoUSD() + "\'";
        GeneralService.executeQueryWithoutResult(update);
    }

    public void deleteRate(CurrentRateEntity currentRateEntity) {
        String delete = "delete from \"Current_Rates\" where \"Date\"=" + "\'" + currentRateEntity.getDate() + "\'";
        GeneralService.executeQueryWithoutResult(delete);
    }

    public List<CurrentRateEntity> findAllByDate(String date) {
        String select = "select * from \"Current_Rates\"";
        return RatesService.getRatesByQuery(select);
    }
}
