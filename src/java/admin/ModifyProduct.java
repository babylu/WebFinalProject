/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import common.DBConnecter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author babylu
 */
public class ModifyProduct extends HttpServlet {
    private Statement st;
    private ResultSet rs = null;
    DBConnecter dbConnecter = new DBConnecter();
    private Connection conn = dbConnecter.connetDatabase();

    /**
     * Processes requests for both HTTP GET and POST methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        if(session.getAttribute("type")==null){
            out.println("<script>alert('Please login admin account first!')</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
            return;
        }

        if(!session.getAttribute("type").toString().equals("admin") ){
            out.println("<script>alert('Please login admin account first!')</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
            return;
        }
        
        String productId = request.getParameter("productId");
        String kind = request.getParameter("kind");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        
        //check not null
        if(productId.equals("") || kind.equals("") || name.equals("") || price.equals("") || amount.equals("")){
            out.println("<script>alert('Input Error!')</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        //check id
        try{
            String selectSQL = "SELECT * FROM product WHERE product_id='"+productId+"';";
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);
            if(!rs.next()){
                out.println("<script>alert('Product ID Error!')</script>");
                out.println("<script>window.history.go(-1);</script>");
                return;
            }
        }catch (SQLException se)
        {
            se.printStackTrace();  
        }
        
        //check kind
        if((!kind.equals("cake")) && (!kind.equals("icecream")) && (!kind.equals("chocolate")) && (!kind.equals("cookie"))){
            out.println("<script>alert('Catedory Error!')</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
       
        //check price
        Pattern r = Pattern.compile("([0-9]+.[0-9]+)|([0-9]+)");
        Matcher m = r.matcher(price);
        if (!m.matches()) {
            out.println("<script>alert('Input Price Error!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        //check amount
        r = Pattern.compile("[0-9]+");
        m = r.matcher(amount);
        if (!m.matches()) {
            out.println("<script>alert('Input Amount Error!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        try{
            st = conn.createStatement();
            String updateSql = "UPDATE product SET name='"+name+"',amount="+amount+",price="+price+",kind='"+kind+"' WHERE product_id='" + productId + "';";
            st.executeUpdate(updateSql);
            out.println("<script>alert('Modify Product Success');</script>");
            out.println("<script>location.href = document.referrer;</script>");
        }catch (SQLException se)
        {
            se.printStackTrace();  
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
        processRequest(request, response);
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
        processRequest(request, response);
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
