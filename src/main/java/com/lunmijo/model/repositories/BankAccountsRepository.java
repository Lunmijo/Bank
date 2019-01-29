package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.BankAccountEntity;
import com.lunmijo.model.services.BankAccountsService;
import com.lunmijo.model.services.GeneralService;

import java.util.List;

public class BankAccountsRepository {

    public static BankAccountEntity findByID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"ID\"=" + id;
        return BankAccountsService.readBankAccount(select);
    }

    public static BankAccountEntity findByUserID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"UserID\"=" + id;
        return BankAccountsService.readBankAccount(select);
    }

    public static void save(BankAccountEntity bankAccount) {
        int ID = IDGenerator.generateID("BankAccounts");
        String insert = "insert into \"Bank_Accounts\"(\"ID\", \"UserID\", \"Currency\", \"AvaliableMoney\") values (" +
                ID + ", " +
                "\'" + bankAccount.getUserID() + "\'" + ", " +
                "\'" + bankAccount.getCurrency() + "\'" + ", " +
                bankAccount.getAvaliableMoney() + ")";
        GeneralService.executeQueryWithoutResult(insert);
    }

    public static void update(BankAccountEntity bankAccount) {
        String update = "update \"Bank_Accounts\" set \"AvaliableMoney\"=" + bankAccount.getAvaliableMoney();
        GeneralService.executeQueryWithoutResult(update);
    }

    public static void delete(BankAccountEntity bankAccount) {
        String delete = "delete from \"Bank_Accounts\" where \"UserID\"= " + (Integer)bankAccount.getUserID();
        GeneralService.executeQueryWithoutResult(delete);
    }

    public static List<BankAccountEntity> findAllByUserID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"UserID\"=" + id;
        return BankAccountsService.readBankAccounts(select);
    }

}
