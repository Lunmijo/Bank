package crud_classes.implementations;

import crud_classes.interfaces.Users;
import entity.UserEntity;
import executors.GeneralQueryExecutor;
import executors.UserQueryExecutor;

import java.util.List;

public class UsersAccess implements Users {

    public UserEntity findByID(int id) {

        String select = "select * from \"Users\" where \"ID\"=" + id;
        return UserQueryExecutor.getUserByQuery(select);
    }

    public UserEntity findByBankAccountID(int id) {

        String select = "select * from \"Users\" where \"BankAccountID\"= " + id;
        return UserQueryExecutor.getUserByQuery(select);
    }

    public void save(UserEntity user) {
        //WITHOUT bankAccountsIDs!!!!!
        String insert = "insert into \"Users\"(\"ID\", \"FirstName\", \"LastName\") values (" + user.getID() + ", " + "\'" + user.getFirstName() + "\'" + ", " + "\'" + user.getLastName() + "\'" + ")";
        GeneralQueryExecutor.executeQueryWithoutResult(insert);


    }

    public void delete(UserEntity user) {
        String delete = "delete from \"Users\" where \"ID\"= " + (Integer)user.getID();
        GeneralQueryExecutor.executeQueryWithoutResult(delete);
    }

    public void update(UserEntity user) {
        String update = "update \"Users\" set \"FirstName\"=" + "\'" + user.getFirstName() + "\'" +
                ", \"LastName\"=" + "\'" + user.getLastName() + "\'" +
                " where \"ID\"=" + user.getID();
        GeneralQueryExecutor.executeQueryWithoutResult(update);
    }

    public List<UserEntity> findAllUsers() {
        String select = "select * from \"Users\"";
        return UserQueryExecutor.getSomeUsersByParam(select);
        }

    public List<UserEntity> findAllUsersByLastName(String lastName) {
        String select = "select * from \"Users\" where \"LastName\"=" + "\'" + lastName + "\'";

        return UserQueryExecutor.getSomeUsersByParam(select);
    }

    public void addBankAccount(String currency) {
        //TODO: въебать как реализовать добавление банк аккаунта юзверю и в таблицу банк аккаунтов
    }

}
