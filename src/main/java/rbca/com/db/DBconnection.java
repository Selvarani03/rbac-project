package rbca.com.db;
import java.sql.*;

public class DBconnection {
	
    public static Connection getConnection() {
        try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             return DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/rbacdb",
                 "root",
                 "sql123"
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

