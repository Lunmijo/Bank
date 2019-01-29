package com.lunmijo.model.repositories;

import com.lunmijo.model.services.GeneralService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDGenerator {

    public static int generateID(String tableName) {
        String select = "select * from \"" + tableName + "\"" + "order by \"ID\" desc limit 1";
        ResultSet result = GeneralService.executeQueryWithResult(select);
        try {
            result.next();
            return result.getInt("ID") + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
