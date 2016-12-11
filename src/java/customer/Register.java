/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import common.DBConnecter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author babylu
 */
public class Register extends HttpServlet {
    private Statement st;
    private ResultSet rs = null;
    private Connection conn = null;
    private String output;
    
    public void userRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // connect database
        DBConnecter dbConnecter = new DBConnecter();
        conn = dbConnecter.connetDatabase();
        //connect error
        if(conn == null){
            output = "Connect Database Error";
            out.println("<script>alert('Failed register: " + output + " Please try again!');</script>");
            out.println("<script>window.history.go(-1);</script>");
        }
        
       
        
        //check username
        String username = request.getParameter("username");
        if(username == ""){
            out.println("<script>alert('Please Input Username!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        try{
            String selectSQL = "SELECT * FROM customer WHERE customer_id = '" + username + "';";
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);
            if(rs.next()){
                out.println("<script>alert('Username has been used. Please change!');</script>");
                out.println("<script>window.history.go(-1);</script>");
                return;
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();  
        }
        
        //check password
        String password = request.getParameter("password");
        if(password == ""){
            out.println("<script>alert('Please Input Password!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        try{
            String selectSQL = "SELECT * FROM customer WHERE customer_id = '" + username + "';";
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);
            if(rs.next()){
                out.println("<script>alert('Username has been used. Please change!');</script>");
                out.println("<script>window.history.go(-1);</script>");
                return;
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();  
        }
        
        //check zipcode
        String zipcode = request.getParameter("address_Zipcode");
        //check input number
        Pattern r = Pattern.compile("[0-9]{5}");
        Matcher m = r.matcher(zipcode);
        if (!m.matches()) {
            out.println("<script>alert('Input Zip Code Error!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        //check age
        String age = request.getParameter("age");
        r = Pattern.compile("[0-9]{1,2}");
        m = r.matcher(age);
        if (!m.matches()) {
            out.println("<script>alert('Input Age Error!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        //check income
        String income = request.getParameter("income");
        r = Pattern.compile("[0-9]{1,10}");
        m = r.matcher(income);
        if (!m.matches()) {
            out.println("<script>alert('Input Income Error!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        
        
        
        
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userRegister(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userRegister(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
