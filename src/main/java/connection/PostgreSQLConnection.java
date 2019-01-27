package connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLConnection {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Bank";
    static final String USER = "postgres";
    static final String PASS = "superdb";

    private static volatile Connection connection;

    public static synchronized void connect() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }
}