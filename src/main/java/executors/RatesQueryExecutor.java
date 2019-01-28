package executors;

import entity.CurrentRateEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RatesQueryExecutor {

    /**
     * @param statement SQL statement
     * @return ArrayList<CurrentRateEntity>
     */
    public static ArrayList<CurrentRateEntity> getRatesByQuery(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
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
