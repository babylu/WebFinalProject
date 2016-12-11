package customer;

import common.DBConnecter;
import java.sql.*;
import java.util.*;
/**
 *
 * @author babylu
 */
public class SearchItem {
    private DBConnecter dbConnecter = new DBConnecter();
    private Connection conn = dbConnecter.connetDatabase();
    private ResultSet rs;
    public String searchItemByType(String type){
        String output = "";
        
        try{
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM product WHERE kind = '" + type + "'";
            rs = st.executeQuery(sql);
            while (rs.next()){
                    output = output + "<tr><td>" + rs.getString("name") + "</td>";
                    output = output + "<td>" + rs.getString("amount") + "</td>";
                    output = output + "<td>" + rs.getString("price") + "</td>";
                    output = output + "<td>";
                    output = output + "<form action='buyProduct'  method='post'>";
                    output = output + "<input type='text' name='number'>";
                    output = output + "<input type='hidden' name='product_id' value='" + rs.getString("product_id") + "'>";
                    output = output + "<input type='hidden' name='product_price' value='" + rs.getString("price") + "'>";
                    output = output + "<button type='submit'>Buy</button>";
                    output = output + "</form></td></tr>";
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        return output;
    }
    
    public String searchItemByUserInput(String searchInfo){
        String output = "";
        String[] searchList = searchInfo.split(" ");
        try{
            ArrayList<String> idList = new ArrayList<>();
            for(int i=0; i<searchList.length; i++){
                Statement st = conn.createStatement();
                String sql = "SELECT * FROM product WHERE name like '%" + searchList[i] + "%' or kind like '%" + searchList[i] + "%';"; 
                rs = st.executeQuery(sql);
                while (rs.next()){
                    if(!idList.contains(rs.getString("product_id"))){
                        output = output + "<tr><td>" + rs.getString("name") + "</td>";
                        output = output + "<td>" + rs.getString("kind") + "</td>";
                        output = output + "<td>" + rs.getString("amount") + "</td>";
                        output = output + "<td>" + rs.getString("price") + "</td>";
                        output = output + "<td>";
                        output = output + "<form action='buyProduct'  method='post'>";
                        output = output + "<input type='text' name='number'>";
                        output = output + "<input type='hidden' name='product_id' value='" + rs.getString("product_id") + "'>";
                        output = output + "<input type='hidden' name='product_price' value='" + rs.getString("price") + "'>";
                        output = output + "<button type='submit'>Buy</button>";
                        output = output + "</form></td></tr>";
                        idList.add(rs.getString("product_id"));
                    }
                }
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        }
        return output;
    }
}
