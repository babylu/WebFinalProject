/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import common.DBConnecter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author babylu
 */
public class SearchProduct {
    private DBConnecter dbConnecter = new DBConnecter();
    private Connection conn = dbConnecter.connetDatabase();
    private ResultSet rs;
    
    public String searchProduct(String userType){
        if(!userType.equals("admin") ){
            return "<script>alert('Please login admin account first!');window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>";
        }
        String output = "";
        
        try{
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM product;";
            rs = st.executeQuery(sql);
            while (rs.next()){
               
                output = output + "<form name='modifyProduct' action='modifyProduct' method='POST'>";
                output = output + "<tr><td>"
                        + "<label>" +rs.getString("product_id")+ "</label>" 
                        + "<input type='hidden' name='productId' value='"+rs.getString("product_id")+"'>" 
                        + "</td>";
                output = output + "<td><input type='text' name='name' value='"+rs.getString("name")+"' required></td>";
                output = output + "<td><input type='text' name='amount' value='"+rs.getString("amount")+"' required></td>";
                output = output + "<td><input type='text' name='price' value='"+rs.getString("price")+"' required></td>";
                output = output + "<td><select name='kind''>" 
                        + "<option value='"+rs.getString("kind")+"'>"+rs.getString("kind")
                        + "<option>cake</option>" 
                        + "<option>cookie</option>" 
                        + "<option>chocolate</option>" 
                        +"<option>icecream</option>" 
                        +"</select></td>";
                output = output + "<td><button type='submit' value='change'>change</button></td></form>";
//                        + "<td><form name='deleteProduct' action='deleteProduct' method='POST'>"
//                        + "<input type='hidden' name='productId' value='"+rs.getString("product_id")+"'>"
//                        + "<button type='submit' value='delete'>delete</button>"
//                        + "</form></td>";
                output = output + "</tr>";
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        return output;
    }
}
