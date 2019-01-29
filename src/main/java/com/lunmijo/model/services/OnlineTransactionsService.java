package com.lunmijo.model.services;

import com.lunmijo.model.entity.OnlineTransactionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OnlineTransactionsService {

    private OnlineTransactionsService() { }

    /**
     * @param statement SQL statement
     * @return OnlineTransactionEntity
     */
    public static OnlineTransactionEntity getTransactionByQuery(String statement) {
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        return makeEntity(result);
    }

    /**
     * @param statement SQL statement
     * @return List<OnlineTransactionEntity>
     */
    public static List<OnlineTransactionEntity> getTransactionsList(String statement) {
        //TODO: с рефлексией и дженериком вынести дублирование кода в отдельный класс и метод
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        ArrayList<OnlineTransactionEntity> transactionsList = new ArrayList<OnlineTransactionEntity>();
        try {
            while (result.next()) {

                transactionsList.add(makeEntity(result));
            }

            return transactionsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static OnlineTransactionEntity makeEntity(ResultSet result) {
        try {
            int tempID = result.getInt("ID");
            String tempCurrency = result.getString("Currency");
            int tempFromAccountID = result.getInt("FromAccountID");
            int tempToAccountID = result.getInt("ToAccountID");
            double tempSum = result.getDouble("Sum");
            String tempCurrencyRateDay = result.getString("CurrencyRateDay");

            return new OnlineTransactionEntity(tempID, tempFromAccountID, tempToAccountID, tempSum, tempCurrencyRateDay, tempCurrency);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
