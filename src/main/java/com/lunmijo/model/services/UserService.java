package com.lunmijo.model.services;

import com.lunmijo.model.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserService() { }
    /**
     * @param statement SQL statement
     * @return UserEntity
     */
    public static UserEntity getUserByQuery(String statement) {
        return GeneralService.readOne(statement, new UserEntity(), new UserService());
    }

    /**
     * @param statement SQL statement
     * @return ArrayList filled by UserEntity
     */
    public static List<UserEntity> getUserList(String statement) {
        return GeneralService.readFew(statement, new UserEntity(), new UserService());
    }

    public static UserEntity makeEntity(ResultSet result){
        UserEntity user = new UserEntity();
        try {
            while(result.next()) {
                user.setID(result.getInt("ID"));
                user.setFirstName(result.getString("FirstName"));
                user.setLastName(result.getString("LastName"));
                user.setBankUAHAccountID(result.getInt("BankUAHAccountID"));
                user.setBankEURAccountID(result.getInt("BankEURAccountID"));
                user.setBankUSDAccountID(result.getInt("BankUSDAccountID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
