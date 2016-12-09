/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author babylu
 */
public class DBConnecter {
    public Connection connetDatabase(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connURL = "jdbc:mysql://localhost:8889/web_final";
            conn = DriverManager.getConnection(connURL, "root", "root");
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();  
        }
        return conn;
    } 
}
