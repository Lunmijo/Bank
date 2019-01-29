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
        return GeneralService.readOne(statement, new OnlineTransactionEntity(), new OnlineTransactionsService());
    }

    /**
     * @param statement SQL statement
     * @return List<OnlineTransactionEntity>
     */
    public static List<OnlineTransactionEntity> getTransactionsList(String statement) {
        return GeneralService.readFew(statement, new OnlineTransactionEntity(), new OnlineTransactionsService());
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
