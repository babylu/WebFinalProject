/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import common.DBConnecter;
import entity.StatisticData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author babylu
 */
public class PrepareStatisticData {
    StatisticData statisticData = new StatisticData();
    private DBConnecter dbConnecter = new DBConnecter();
    private Connection conn = dbConnecter.connetDatabase();
    private ResultSet rs;
    
    public StatisticData prepareStatisticData(){
        try{
            Statement st = conn.createStatement();
            String genderSQL = "SELECT gender,count(*) As sum from customer group by gender";
            rs = st.executeQuery(genderSQL);
            while(rs.next()){
                if(rs.getString("gender").equals("female")){
                    statisticData.setFemale(rs.getInt("sum"));
                }else{
                    statisticData.setMale(rs.getInt("sum"));
                }
            }
            String productSQL = "SELECT kind,sum(product_price) AS sum FROM transaction T, product P WHERE T.product_id = P.product_id GROUP BY kind;";
            rs = st.executeQuery(productSQL);
            while(rs.next()){
                if(rs.getString("kind").equals("cake")){
                    statisticData.setCake(rs.getInt("sum"));
                }else if(rs.getString("kind").equals("chocolate")){
                    statisticData.setChocolate(rs.getInt("sum"));
                }else if(rs.getString("kind").equals("cookie")){
                    statisticData.setCookie(rs.getInt("sum"));
                }else{
                    statisticData.setIcecream(rs.getInt("sum"));
                }
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        } 
        return statisticData;
    }
}
