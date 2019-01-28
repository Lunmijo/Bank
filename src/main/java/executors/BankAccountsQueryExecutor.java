package executors;

import entity.BankAccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankAccountsQueryExecutor {

    private BankAccountsQueryExecutor() { }

    /**
     * @param query SQL statement
     * @return BankAccountEntity
     */
    public static BankAccountEntity getBankAccountByQuery(String query) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(query);

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

    public static ArrayList<BankAccountEntity> getBankAccountsByQuery(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
        ArrayList<BankAccountEntity> bankAccountEntities = new ArrayList<BankAccountEntity>();

        try {
            while (result.next()) {
                int tempID = result.getInt("ID");
                int tempUserID = result.getInt("UserID");
                String tempCurrency = result.getString("Currency");
                double tempAvaliableMoney = result.getDouble("AvaliableMoney");
                bankAccountEntities.add(new BankAccountEntity(tempID, tempUserID, tempCurrency, tempAvaliableMoney));
            }

            return bankAccountEntities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
