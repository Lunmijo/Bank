package com.lunmijo.model.services;

import com.lunmijo.model.entity.ATMTransactionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ATMTransactionsService {

    private ATMTransactionsService() { }

    public static List<ATMTransactionEntity> getTransactionsByQuery(String statement) {

        ResultSet result = GeneralService.executeQueryWithResult(statement);
        return makeListFromDBResult(result);
    }

    /**
     * @param result ResultSet - SQL query result
     * @return ArrayList - transformed into entity resultsResultSet - result from database
     */
    private static ArrayList<ATMTransactionEntity> makeListFromDBResult(ResultSet result) {
        ArrayList<ATMTransactionEntity> bankAccountEntities = new ArrayList<ATMTransactionEntity>();

        try {
            while (result.next()) {
                int tempID = result.getInt("ID");
                int tempBankAccountID = result.getInt("BankAccountID");
                double tempSum = result.getDouble("Sum");
                bankAccountEntities.add(new ATMTransactionEntity(tempID, tempBankAccountID, tempSum));
            }

            return bankAccountEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

