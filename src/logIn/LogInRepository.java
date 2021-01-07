package logIn;

import java.sql.*;

public class LogInRepository {

    Connection con = null;

    public static Connection connectDB() {
        try {
            String DATABASE_URL = "jdbc:derby:./db/dataBase";
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            return connection;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
