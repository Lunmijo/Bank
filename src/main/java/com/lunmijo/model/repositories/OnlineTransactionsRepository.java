package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.OnlineTransactionEntity;
import com.lunmijo.model.services.GeneralService;
import com.lunmijo.model.services.OnlineTransactionsService;

import java.util.List;

public class OnlineTransactionsRepository {

    public static OnlineTransactionEntity findByID(int id) {
    String select = "select * from \"Online_Transactions\" where \"ID\"=" + id;
        return OnlineTransactionsService.getTransactionByQuery(select);
    }

    public static List<OnlineTransactionEntity> findAllByCurrency(String currency) {
        String select = "select * from \"Online_Transactions\" where \"Currency\"=" + currency;
        return OnlineTransactionsService.getTransactionsList(select);
    }

    public static List<OnlineTransactionEntity> findAllByFromAccountID(int id) {
        String select = "select * from \"Online_Transactions\" where \"FromAccountID\"=" + id;
        return OnlineTransactionsService.getTransactionsList(select);
    }

    public static List<OnlineTransactionEntity> findAllByToAccountID(int id) {
        String select = "select * from \"Online_Transactions\" where \"ToAccountID\"=" + id;
        return OnlineTransactionsService.getTransactionsList(select);
    }

    public static List<OnlineTransactionEntity> findAllByCurrencyRateDay(String date) {
        String select = "select * from \"Online_Transactions\" where \"CurrencyRateDay\"=" + date;
        return OnlineTransactionsService.getTransactionsList(select);
    }

    public static void save(OnlineTransactionEntity onlineTransaction) {
        String insert = "insert into \"OnlineTransactions\"(\"ID\", \"Currency\", \"FromAccountID\", \"ToAccountID\", \"Sum\", \"CurrencyRateDay\") values (" +
                onlineTransaction.getID() + ", " +
                "\'" + onlineTransaction.getCurrency() + "\'" + ", " +
                "\'" + onlineTransaction.getFromAccountID() + "\'" + ", " +
                "\'" + onlineTransaction.getToAccountID() + "\'" + ", " +
                "\'" + onlineTransaction.getSum() + "\'" + ", " +
                "\'" + onlineTransaction.getCurrency() + "\'" + ")";
        GeneralService.executeQueryWithoutResult(insert);
    }

  //OnlineTransactions cannot be updated

    public static void delete(OnlineTransactionEntity onlineTransaction) {
        String delete = "delete from \"OnlineTransactions\" where \"ID\"= " + (Integer)onlineTransaction.getID();
        GeneralService.executeQueryWithoutResult(delete);
    }
}
