package crud_classes.implementations;

import crud_classes.interfaces.OnlineTransactions;
import entity.OnlineTransactionEntity;
import executors.GeneralQueryExecutor;
import executors.OnlineTransactionsExecutor;

import java.util.List;

public class OnlineTransactionsAccess implements OnlineTransactions {

    public OnlineTransactionEntity findByID(int id) {
    String select = "select * from \"Online_Transactions\" where \"ID\"=" + id;
        return OnlineTransactionsExecutor.getTransactionByQuery(select);
    }

    public List<OnlineTransactionEntity> findAllByCurrency(String currency) {
        String select = "select * from \"Online_Transactions\" where \"Currency\"=" + currency;
        return OnlineTransactionsExecutor.getSomeTransactionsByParam(select);
    }

    public List<OnlineTransactionEntity> findAllByFromAccountID(int id) {
        String select = "select * from \"Online_Transactions\" where \"FromAccountID\"=" + id;
        return OnlineTransactionsExecutor.getSomeTransactionsByParam(select);
    }

    public List<OnlineTransactionEntity> findAllByToAccountID(int id) {
        String select = "select * from \"Online_Transactions\" where \"ToAccountID\"=" + id;
        return OnlineTransactionsExecutor.getSomeTransactionsByParam(select);
    }

    public List<OnlineTransactionEntity> findAllByCurrencyRateDay(String date) {
        String select = "select * from \"Online_Transactions\" where \"CurrencyRateDay\"=" + date;
        return OnlineTransactionsExecutor.getSomeTransactionsByParam(select);
    }

    public void save(OnlineTransactionEntity onlineTransaction) {
        String insert = "insert into \"OnlineTransactions\"(\"ID\", \"Currency\", \"FromAccountID\", \"ToAccountID\", \"Sum\", \"CurrencyRateDay\") values (" +
                onlineTransaction.getID() + ", " +
                "\'" + onlineTransaction.getCurrency() + "\'" + ", " +
                "\'" + onlineTransaction.getFromAccountID() + "\'" + ", " +
                "\'" + onlineTransaction.getToAccountID() + "\'" + ", " +
                "\'" + onlineTransaction.getSum() + "\'" + ", " +
                "\'" + onlineTransaction.getCurrency() + "\'" + ")";
        GeneralQueryExecutor.executeQueryWithoutResult(insert);
    }

  //OnlineTransactions cannot be updated

    public void delete(OnlineTransactionEntity onlineTransaction) {
        String delete = "delete from \"OnlineTransactions\" where \"ID\"= " + (Integer)onlineTransaction.getID();
        GeneralQueryExecutor.executeQueryWithoutResult(delete);
    }
}
