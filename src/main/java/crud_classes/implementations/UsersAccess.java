package crud_classes.implementations;

import connection.PostgreSQLConnection;
import crud_classes.interfaces.Users;
import db_entity.db_objects_i.User;
import db_entity.db_objects_impl.UserImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersAccess implements Users {

    public User findByID(int id) {

        String select = "select * from \"Users\" where \"ID\"=" + id;

        ResultSet result = this.executeQueryWithResult(select);

        UserImpl user = null;

        try {
            if (result.next()) {
                user = new UserImpl();
                user.setID(id);
                //user.setBankUAHAccountID(result.getInt("BankAccountID"));
                user.setFirstName(result.getString("FirstName"));
                user.setLastName(result.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

        public User findByBankAccountID(int id) {

            String select = "select * from \"Users\" where \"BankAccountID\"= " + id;
            ResultSet result = this.executeQueryWithResult(select);

            UserImpl user = new UserImpl();

            user.setBankUAHAccountID(id);

            try {
                user.setID(result.getInt("ID"));
                user.setFirstName(result.getString("FirstName"));
                user.setLastName(result.getString("LastName"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
    }

    public void save(User user) {
        //WITHOUT bankAccountsIDs!!!!!
        String insert = "insert into \"Users\"(\"ID\", \"FirstName\", \"LastName\") values (" + user.getID() + ", " + "\'" + user.getFirstName() + "\'" + ", " + "\'" + user.getLastName() + "\'" + ")";
        executeQueryWithoutResult(insert);


    }

    public void delete(User user) {
        String delete = "delete from \"Users\" where \"ID\"= " + (Integer)user.getID();
        this.executeQueryWithoutResult(delete);
    }

    public void update(User user) {
        String update = "update \"Users\" set \"FirstName\"=" + "\'" + user.getFirstName() + "\'" +
                ", \"LastName\"=" + "\'" + user.getLastName() + "\'" +
                " where \"ID\"=" + user.getID();
        this.executeQueryWithoutResult(update);
    }

    public List<User> getAllUsersByID(int id) {
        return null;
    }

    public List<User> getAllUsersByLastName(String lastName) {
        return null;
    }

    private ResultSet executeQueryWithResult(String query) {
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
    private void executeQueryWithoutResult(String query) {

        try {

            PostgreSQLConnection.getConnection()
                    .createStatement()
                    .execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
