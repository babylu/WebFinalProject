package customer;

import common.DBConnecter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author babylu
 */
public class GetUserInfo extends HttpServlet {
    private DBConnecter dbConnecter = new DBConnecter();
    private Connection conn = dbConnecter.connetDatabase();
    private ResultSet rs;
    
    public UserInfo getBasicInfo(String username){
        UserInfo userInfo = new UserInfo();
        if(username == ""){
            return userInfo;
        }
        try{
            String sql = "SELECT * FROM customer WHERE customer_id ='" + username + "';";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                userInfo.setUsername(username);
                userInfo.setName(rs.getString("name"));
                userInfo.setAddress_street(rs.getString("address_street"));
                userInfo.setAddress_state(rs.getString("address_state"));
                userInfo.setAddress_city(rs.getString("address_city"));
                userInfo.setAddress_zipcode(rs.getInt("address_zipcode"));
                userInfo.setMarriage(rs.getString("marriage"));
                userInfo.setGender(rs.getString("gender"));
                userInfo.setAge(rs.getInt("age"));
                userInfo.setIncome(rs.getInt("income"));
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        
        return userInfo;
    }
    public String getPurchaseHistory(String username){
        String output="";
        try{
            Statement st = conn.createStatement();
            String selectTransactionSQL = "SELECT * FROM transaction WHERE customer_id = '" + username + "'";
            rs = st.executeQuery(selectTransactionSQL);
            while (rs.next()){
                    output = output + "<tr><td>" + rs.getString("order_number") + "</td>";
                    output = output + "<td>" + rs.getString("date") + "</td>";
                    
                    String selectProductSQL = "SELECT name FROM product WHERE product_id='"+rs.getString("product_id")+"';";
                    Statement st1 = conn.createStatement();
                    ResultSet rsProduct = st1.executeQuery(selectProductSQL);
                    
                    if(rsProduct.next()){
                        output = output + "<td>" + rsProduct.getString("name") + "</td>";
                    }else{
                        output = output + "<td></td>";
                    }
                    output = output + "<td>" + rs.getInt("product_quantity") + "</td>";
                    output = output + "<td>" + rs.getBigDecimal("product_price") + "</td>";
                    output = output + "</tr>";
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        return output;
    }
}
