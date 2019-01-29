package com.lunmijo.model.repositories;

import com.lunmijo.model.entity.UserEntity;
import com.lunmijo.model.services.GeneralService;
import com.lunmijo.model.services.UserService;

import java.util.List;

public class UsersRepository {

    public UserEntity findByID(int id) {

        String select = "select * from \"Users\" where \"ID\"=" + id;
        return UserService.getUserByQuery(select);
    }

    public UserEntity findByBankAccountID(int id) {

        String select = "select * from \"Users\" where \"BankAccountID\"= " + id;
        return UserService.getUserByQuery(select);
    }

    public void save(UserEntity user) {
        //WITHOUT bankAccountsIDs!!!!!
        String insert = "insert into \"Users\"(\"ID\", \"FirstName\", \"LastName\") values (" + user.getID() + ", " + "\'" + user.getFirstName() + "\'" + ", " + "\'" + user.getLastName() + "\'" + ")";
        GeneralService.executeQueryWithoutResult(insert);


    }

    public void delete(UserEntity user) {
        String delete = "delete from \"Users\" where \"ID\"= " + (Integer)user.getID();
        GeneralService.executeQueryWithoutResult(delete);
    }

    public void update(UserEntity user) {
        String update = "update \"Users\" set \"FirstName\"=" + "\'" + user.getFirstName() + "\'" +
                ", \"LastName\"=" + "\'" + user.getLastName() + "\'" +
                " where \"ID\"=" + user.getID();
        GeneralService.executeQueryWithoutResult(update);
    }

    public List<UserEntity> findAllUsers() {
        String select = "select * from \"Users\"";
        return UserService.getUserList(select);
    }

    public List<UserEntity> findAllUsersByLastName(String lastName) {
        String select = "select * from \"Users\" where \"LastName\"=" + "\'" + lastName + "\'";

        return UserService.getUserList(select);
    }

    public void addBankAccount(String currency) {
        //TODO: понять как реализовать добавление банк аккаунта юзверю и в таблицу банк аккаунтов
    }

}
