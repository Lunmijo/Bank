package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.BankAccountEntity;
import com.lunmijo.model.entity.UserEntity;
import com.lunmijo.model.services.GeneralService;
import com.lunmijo.model.services.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersRepository {

    public static UserEntity findByID(int id) {

        String select = "select * from \"Users\" where \"ID\"=" + id;
        return UserService.getUserByQuery(select);
    }

    public static UserEntity findByBankAccountID(int id) {

        String select = "select * from \"Users\" where \"BankAccountID\"= " + id;
        return UserService.getUserByQuery(select);
    }

    public static void save(UserEntity user) {
        int ID = IDGenerator.generateID("Users");
        String insert = "insert into \"Users\"(\"ID\", \"FirstName\", \"LastName\") values (" + ID + ", " + "\'" + user.getFirstName() + "\'" + ", " + "\'" + user.getLastName() + "\'" + ")";
        GeneralService.executeQueryWithoutResult(insert);


    }

    public static void delete(UserEntity user) {
        String delete = "delete from \"Users\" where \"ID\"= " + (Integer)user.getID();
        GeneralService.executeQueryWithoutResult(delete);
    }

    public static void update(UserEntity user) {
        String update = "update \"Users\" set \"FirstName\"=" + "\'" + user.getFirstName() + "\'" +
                ", \"LastName\"=" + "\'" + user.getLastName() + "\'" +
                " where \"ID\"=" + user.getID();
        GeneralService.executeQueryWithoutResult(update);
    }

    public static List<UserEntity> findAllUsers() {
        String select = "select * from \"Users\"";
        return UserService.getUserList(select);
    }

    public static List<UserEntity> findAllUsersByLastName(String lastName) {
        String select = "select * from \"Users\" where \"LastName\"=" + "\'" + lastName + "\'";

        return UserService.getUserList(select);
    }

    public static void addBankAccount(int userID, BankAccountEntity bankAccountEntity) {
        UserEntity user = UsersRepository.findByID(userID);

        if (bankAccountEntity.getCurrency().equals("UAH")) {
            user.setBankUAHAccountID(bankAccountEntity.getID());
        } else if (bankAccountEntity.getCurrency().equals("EUR")) {
            user.setBankUAHAccountID(bankAccountEntity.getID());
        } if (bankAccountEntity.getCurrency().equals("USD")) {
            user.setBankUAHAccountID(bankAccountEntity.getID());
        }
    }

}
