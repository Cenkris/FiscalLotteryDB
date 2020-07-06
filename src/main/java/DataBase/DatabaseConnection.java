package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final static String databaseName = "fiscallotteydb";
    private final static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    private static Connection connection;


    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return connection;
    }
}
