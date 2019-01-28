package executors;

import entity.ATMTransactionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ATMTransactionsQueryExecutor {

    private ATMTransactionsQueryExecutor() { }

    public static List<ATMTransactionEntity> getTransactionsByQuery(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
        ArrayList<ATMTransactionEntity> bankAccountEntities = new ArrayList<ATMTransactionEntity>();

        try {
            while (result.next()) {
                int tempID = result.getInt("ID");
                int tempBankAccountID = result.getInt("BankAccountID");
                double tempSum = result.getDouble("Sum");
                Double tempAvaliableMoney = result.getDouble("AvaliableMoney");
                bankAccountEntities.add(new ATMTransactionEntity(tempID, tempBankAccountID, tempSum));
            }

            return bankAccountEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
