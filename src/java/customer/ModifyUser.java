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
import javax.servlet.http.HttpSession;

/**
 *
 * @author babylu
 */
public class ModifyUser extends HttpServlet {
    private Statement st;
    private ResultSet rs = null;
    private Connection conn = null;

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
        conn = dbConnecter.connetDatabase();
        

        if(session.getAttribute("username")==null){
            out.println("<script>alert('Please login first!')</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/login.jsp';</script>");
            return;
        }
        
        String username = session.getAttribute("username").toString();
        
        //check name
        String name = request.getParameter("name");
        if(name.equals("")){
            out.println("<script>alert('Please Input Name!');</script>");
            out.println("<script>window.history.go(-1);</script>");
            return;
        }
        
        //check zipcode
        String zipcode = request.getParameter("address_zipcode");
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
        //prepare data
        String street = request.getParameter("address_street");
        String city = request.getParameter("address_city");
        String state = request.getParameter("address_state");
        int zipcodeInt = Integer.parseInt(zipcode);
        String marriageStatue = request.getParameter("marriageStatue");
        String gender = request.getParameter("gender");
        int ageInt = Integer.parseInt(age);
        int incomeInt = Integer.parseInt(income);
        try{
            st = conn.createStatement();;
            String updateSql = "UPDATE customer SET address_street='" + street +"',address_city='"+city+"',address_state='"+state+"',address_zipcode="+zipcodeInt+
                    ",marriage='"+marriageStatue+"',gender='"+gender+"',age="+ageInt+",income="+incomeInt+" WHERE customer_id='"+username+"';";
            st.executeUpdate(updateSql);
            out.println("<script>alert('Modeify Success!');</script>");
            out.println("<script>window.location.href = 'http://localhost:8080/WebFinalProject/html/personalPage.jsp';</script>\")");
            st.close();
            conn.close();
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
