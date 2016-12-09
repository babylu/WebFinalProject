
package customer;

import common.DBConnecter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author babylu
 */
public class BuyProduct extends HttpServlet {
    private Statement st;
    private ResultSet rs = null;
    private Connection conn = null;
    private String output;
    private String page;
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
        DBConnecter dbConnecter = new DBConnecter();
        Connection conn = dbConnecter.connetDatabase();
        
        //no session name -> to login
        if (session.getAttribute("username") == null) {
            out.println("<script>alert('Please login first!')</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
            return;
        }
        
        //check input number
        Pattern r = Pattern.compile("/[0-9]+/");
        Matcher m = r.matcher(request.getParameter("number"));
        if (!m.matches()) {
            out.println("<script>alert('Input Error!');</script>");
//            out.println("<script>window.location.reload();</script>");
            return;
        }
        
        
//        //generate all parameters
//        
//        String username = (String)session.getAttribute("username");
//        // get parameters submitted from the form
//        String productId = request.getParameter("product_id");
//        double productPrice = Double.parseDouble(request.getParameter("product_price"));
//        int productQuantity = Integer.parseInt(request.getParameter("number"));
//        SimpleDateFormat df = new SimpleDateFormat("mmddyyyyhhmmss");
//
//        // Get the date today using Calendar object.
//        Date today = Calendar.getInstance().getTime();        
//        // Using DateFormat format method we can create a string 
//        // representation of a date with the defined format.
//        String orderNum = df.format(today);
//        try{
//            st = conn.createStatement();
//            String insertSql = "INSERT INTO transaction (order_num, product_id, product_price, product_quantity, customer_id) VALUES ('"+orderNum+"','"+productId+"','"+productPrice+"','"+productQuantity+"','"+username+"')";
//            st.executeUpdate(insertSql);
//            out.println("<script>alert('Buy success!   Your order number is "+ orderNum +"');</script>");
//            out.println("<script>window.location.href = 'http://localhost:8080/WebHw6/icecream.jsp';</script>");
//        }
//        catch (SQLException se)
//        {
//            se.printStackTrace();  
//        }
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