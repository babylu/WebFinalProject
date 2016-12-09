package common;

import java.io.PrintWriter;
import java.sql.*;

/**
 *
 * @author babylu
 */
public class DBConnecter {
    public Connection connetDatabase(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connURL = "jdbc:mysql://52.36.21.186:3306/web_final";
            conn = DriverManager.getConnection(connURL, "babylu", "12345");
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();  
        }
        return conn;
    } 
}
