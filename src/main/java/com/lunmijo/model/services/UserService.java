package com.lunmijo.model.services;

import com.lunmijo.model.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserService() { }
    /**
     * @param query SQL statement
     * @return UserEntity
     */
    public static UserEntity getUserByQuery(String query) {
        ResultSet result = GeneralService.executeQueryWithResult(query);

        return UserService.makeEntity(result);
    }

    /**
     * @param statement SQL statement
     * @return ArrayList filled by UserEntity
     */
    public static List<UserEntity> getUserList(String statement) {
        ResultSet result = GeneralService.executeQueryWithResult(statement);
        ArrayList<UserEntity> userList = new ArrayList<UserEntity>();
        try {
            while (result.next()) {
                userList.add(UserService.makeEntity(result));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static UserEntity makeEntity(ResultSet result){
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
}
