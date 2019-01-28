package executors;

import entity.OnlineTransactionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OnlineTransactionsExecutor {

    private OnlineTransactionsExecutor() { }

    /**
     * @param statement SQL statement
     * @return OnlineTransactionEntity
     */
    public static OnlineTransactionEntity getTransactionByQuery(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
        return getTransactionEntity(result);
    }

    /**
     * @param statement SQL statement
     * @return List<OnlineTransactionEntity>
     */
    public static List<OnlineTransactionEntity> getSomeTransactionsByParam(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
        ArrayList<OnlineTransactionEntity> transactionsList = new ArrayList<OnlineTransactionEntity>();
        try {
            while (result.next()) {

                transactionsList.add(getTransactionEntity(result));
            }

            return transactionsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static OnlineTransactionEntity getTransactionEntity(ResultSet result) {
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
