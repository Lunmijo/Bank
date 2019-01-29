package com.lunmijo.model.services;

import com.lunmijo.model.entity.ATMTransactionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ATMTransactionsService {

    private ATMTransactionsService() { }

    /**
     * @param statement SQL statement
     * @return BankAccountEntity
     */
    public static ATMTransactionEntity readTransaction(String statement) {
        return GeneralService.readOne(statement, new ATMTransactionEntity(), new ATMTransactionsService());
    }

    public static List<ATMTransactionEntity> readTransactions(String statement) {
        return GeneralService.readFew(statement, new ATMTransactionEntity(), new ATMTransactionsService());
    }

    /**
     * @param result ResultSet - SQL query result
     * @return ArrayList - transformed into entity resultsResultSet - result from database
     */
    public static ATMTransactionEntity makeEntity(ResultSet result) {

       try {
                int tempID = result.getInt("ID");
                int tempBankAccountID = result.getInt("BankAccountID");
                double tempSum = result.getDouble("Sum");

            return new ATMTransactionEntity(tempID, tempBankAccountID, tempSum);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

