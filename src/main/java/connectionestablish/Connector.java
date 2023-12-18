package connectionestablish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String databaseUrl = "jdbc:postgresql://localhost:5432/login";
        Connection con = DriverManager.getConnection(databaseUrl, "login", "password");
        return con;
    }
}
