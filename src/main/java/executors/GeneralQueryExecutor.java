package executors;

import connection.PostgreSQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneralQueryExecutor {

    private GeneralQueryExecutor() { }

    /**
     * @param query SQL statement
     * @return ResultSet
     */
    static ResultSet executeQueryWithResult(String query) {
        ResultSet result = null;

        try {
            result = PostgreSQLConnection.getConnection()
                    .createStatement()
                    .executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param query SQL statement
     */
    public static void executeQueryWithoutResult(String query) {

        try {

            PostgreSQLConnection.getConnection()
                    .createStatement()
                    .execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
