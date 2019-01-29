package com.lunmijo.model.services;

import com.lunmijo.model.connection.PostgreSQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneralService {

    private GeneralService() { }

    /**
     * @param query SQL statement
     * @return ResultSet
     */
    public static ResultSet executeQueryWithResult(String query) {
        ResultSet result = null;

        try {
            result = makeStatement()
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
            makeStatement()
                    .execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Statement makeStatement() {
        try {
            return PostgreSQLConnection.getConnection()
                    .createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
