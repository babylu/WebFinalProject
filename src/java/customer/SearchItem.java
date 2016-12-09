package customer;

import common.DBConnecter;
import java.sql.*;
/**
 *
 * @author babylu
 */
public class SearchItem {
    public String searchItemByType(String type){
        DBConnecter dbConnecter = new DBConnecter();
        Connection conn = dbConnecter.connetDatabase();
        ResultSet rs;
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
                output = output + "<button type='submit'>Buy</button>";
                output = output + "</form></td></tr>";
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        return output;
    }
}
