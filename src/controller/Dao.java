package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 
 */
public class Dao {
    public Connection connect;
    private final String DB_URL = "jdbc:mysql://localhost/ql_banhang";
    private final String USER_NAME = "root";
    private final String PASSWORD = "";
    
    public Dao() {
        try {
            connect = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
