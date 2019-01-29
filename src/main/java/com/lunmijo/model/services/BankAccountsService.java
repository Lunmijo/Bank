package com.lunmijo.model.services;

import com.lunmijo.model.entity.BankAccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankAccountsService {

    private BankAccountsService() { }

    /**
     * @param query SQL statement
     * @return BankAccountEntity
     */
    public static BankAccountEntity getBankAccountByQuery(String query) {
        ResultSet result = GeneralService.executeQueryWithResult(query);
        return makeEntity(result);
    }

    public static ArrayList<BankAccountEntity> getBankAccountsByQuery(String statement) {
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        ArrayList<BankAccountEntity> transactionsList = new ArrayList<BankAccountEntity>();
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

    /**
     * @param result ResultSet - result from database
     * @return BankAccountEntity
     */
    private static BankAccountEntity makeEntity(ResultSet result) {
        BankAccountEntity bankAccount = null;

        try {
            if (result.next()) {
                bankAccount = new BankAccountEntity();
                bankAccount.setID(result.getInt("ID"));
                bankAccount.setUserID(result.getInt("UserID"));
                bankAccount.setCurrency(result.getString("AvaliableMoney"));
                bankAccount.setCurrency(result.getString("Currency"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bankAccount;
    }
}
