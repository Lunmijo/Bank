package com.lunmijo.model.services;

import com.lunmijo.model.entity.CurrentRateEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatesService {

    /**
     * @param statement SQL statement
     * @return ArrayList<CurrentRateEntity>
     */
    public static List<CurrentRateEntity> getRatesByQuery(String statement) {
        return GeneralService.readFew(statement, new CurrentRateEntity(), new RatesService());
    }
    public static CurrentRateEntity getRateByQuery(String statement) {
        return GeneralService.readOne(statement, new CurrentRateEntity(), new RatesService());
    }

    private static ArrayList<CurrentRateEntity> makeEntityList(ResultSet result) {
        ArrayList<CurrentRateEntity> currentRateEntities = new ArrayList<CurrentRateEntity>();

        try {
            while (result.next()) {
                String tempDate = result.getString("Date");
                double tempUAHtoUSD = result.getDouble("UAHtoUSD");
                double tempUAHtoEUR = result.getDouble("UAHtoEUR");
                double tempUSDtoUAH = result.getDouble("USDtoUAH");
                double tempEURtoUAH = result.getDouble("EURtoUAH");
                double tempUSDtoEUR = result.getDouble("USDtoEUR");
                double tempEURtoUSD = result.getDouble("EURtoUSD");

                currentRateEntities.add(new CurrentRateEntity(tempDate, tempUAHtoUSD, tempUAHtoEUR, tempUSDtoUAH, tempEURtoUAH, tempEURtoUSD, tempUSDtoEUR));
            }

            return currentRateEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
