package common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;


/**
 *
 * @author babylu
 */
public class Login extends HttpServlet {
    private Statement st;
    private ResultSet rs = null;
    private Connection conn = null;
    private String output;
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
        
        // connect database
        DBConnecter dbConnecter = new DBConnecter();
        conn = dbConnecter.connetDatabase();
        //connect error
        if(conn == null){
            output = "Connect Database Error";
            failLogin(request, response);
            return;
        }
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        
        try{
            //user login
            st = conn.createStatement();
            String sql = "";
            if(type.equals("customer")){
                //customer login
                sql = "SELECT * FROM customer WHERE customer_id = '" + username +"'";
            }else if(type.equals("admin")){
                //admin login
                sql = "SELECT * FROM admin WHERE username = '" + username +"'";
            }else{
                output = "User Type Error";
                failLogin(request, response);
                return;
            }
            
            rs = st.executeQuery(sql);

            if (rs.next()) {
                if (password.equals(rs.getString("password").trim())) {
                    if(type.equals("customer")){
                        successLogin(request, response, rs.getString("name"),username,type);
                    }else{
                        successLogin(request, response, "", username,type);
                    }
                    
                }
                else {
                    output = "Wrong password!";
                    failLogin(request, response);
                    return;
                }
            }else {
                output = "Wrong email!";
                failLogin(request, response);
                return;
            }
            rs.close();
            st.close();
            conn.close();
        }
        catch (SQLException se)
        {
            se.printStackTrace();  
        }
    }
    
    /**
     * Login failed methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void failLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        try (PrintWriter out = response.getWriter()) {
            out.println("<script>alert('Failed login: " + output + " Please try again!');</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
        }
    }
    
    /**
     * Login success methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param name username
     * @param type usertype
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void successLogin (HttpServletRequest request, HttpServletResponse response, String name,String username, String type)
            throws ServletException, IOException  {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("name", name);
        session.setAttribute("type", type);
        if(type.equals("customer")){
            response.sendRedirect("../index.jsp");
        }else{
            response.sendRedirect("./adminStock.jsp");
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
