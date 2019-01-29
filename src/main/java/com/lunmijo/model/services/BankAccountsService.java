package com.lunmijo.model.services;

import com.lunmijo.model.entity.BankAccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BankAccountsService {

    private BankAccountsService() { }

    /**
     * @param statement SQL statement
     * @return BankAccountEntity
     */
    public static BankAccountEntity readBankAccount(String statement) {
        return GeneralService.readOne(statement, new BankAccountEntity(), new BankAccountsService());
    }

    public static List<BankAccountEntity> readBankAccounts(String statement) {
        return GeneralService.readFew(statement, new BankAccountEntity(), new BankAccountsService());
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
