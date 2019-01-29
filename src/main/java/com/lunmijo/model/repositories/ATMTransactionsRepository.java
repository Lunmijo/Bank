package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.ATMTransactionEntity;
import com.lunmijo.model.services.ATMTransactionsService;
import com.lunmijo.model.services.GeneralService;

import java.util.List;

public class ATMTransactionsRepository {

    public static void save(ATMTransactionEntity atmTransactionEntity) {
        String insert = "insert into \"Bank_Accounts\"(\"ID\", \"BankAccountID\", \"Sum\") values (" +
                atmTransactionEntity.getID() + ", " +
                "\'" + atmTransactionEntity.getBankAccountID() + "\'" + ", " +
                atmTransactionEntity.getSum() + ")";
        GeneralService.executeQueryWithoutResult(insert);
    }

    public static void delete(ATMTransactionEntity atmTransactionEntity) {
        String delete = "delete from \"ATM_Transactions\" where \"ID\"= " + (Integer)atmTransactionEntity.getID();
        GeneralService.executeQueryWithoutResult(delete);
    }

    //Transactions cannot be updated

    public static ATMTransactionEntity findByID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"BankAccountID\"=" + id;
        return ATMTransactionsService.readTransaction(select);
    }

    public static List<ATMTransactionEntity> findAllByBankAccountID(int id) {
        String select = "select * from \"Bank_Accounts\" where \"BankAccountID\"=" + id;
        return ATMTransactionsService.readTransactions(select);
    }
}
