package common;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
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
        
        try {
            String email = request.getParameter("username");
            String password = request.getParameter("password");
            
            Class.forName("com.mysql.jdbc.Driver");
            String connURL = "jdbc:mysql://localhost:8889/web_final";
            conn = DriverManager.getConnection(connURL, "root", "root");
            st = conn.createStatement();
            String sql = "SELECT * FROM user WHERE email='" + email +"'";
            rs = st.executeQuery(sql);
            
            if (rs.next()) {
                if (password.equals(rs.getString("password").trim())) {
                    successLogin(request, response, rs.getString("email").trim());
                }
                else {
                    output = "Wrong password!";
                    failLogin(request, response);
                }
            }else {
                output = "Wrong email!";
                failLogin(request, response);
            }
            rs.close();
            st.close();
        }
        catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
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
            out.println("<script>window.location.href = 'http://localhost:8080/WebHw6/index.jsp';</script>");
        }
    }
    
    /**
     * Login success methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param name username
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void successLogin (HttpServletRequest request, HttpServletResponse response, String name)
            throws ServletException, IOException  {
        HttpSession session = request.getSession();
        session.setAttribute("username", name);
        response.sendRedirect("icecream.jsp");
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
