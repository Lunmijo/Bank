package executors;

import entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserQueryExecutor {

    private UserQueryExecutor() { }
    /**
     * @param query SQL statement
     * @return UserEntity
     */
    public static UserEntity getUserByQuery(String query) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(query);

        UserEntity user = new UserEntity();

        try {
            user.setID(result.getInt("ID"));
            user.setFirstName(result.getString("FirstName"));
            user.setLastName(result.getString("LastName"));
            user.setBankUAHAccountID(result.getInt("BankUAHAccountID"));
            user.setBankEURAccountID(result.getInt("BankEURAccountID"));
            user.setBankUSDAccountID(result.getInt("BankUSDAccountID"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * @param statement SQL statement
     * @return ArrayList filled by UserEntity
     */
    public static ArrayList<UserEntity> getSomeUsersByParam(String statement) {
        ResultSet result = GeneralQueryExecutor.executeQueryWithResult(statement);
        ArrayList<UserEntity> userList = new ArrayList<UserEntity>();
        try {
            while (result.next()) {
                int tempID = result.getInt("ID");
                String tempFirstName = result.getString("FirstName");
                String tempLastName = result.getString("LastName");
                int tempUAHAccount = result.getInt("BankUAHAccountID");
                int tempUSDAccount = result.getInt("BankUSDAccountID");
                int tempEURAccount = result.getInt("BankEURAccountID");

                userList.add(new UserEntity(tempID, tempFirstName, tempLastName, tempEURAccount, tempUAHAccount, tempUSDAccount));
            }

            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
