
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class InsertRegister extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=res.getWriter())
        {
            out.println("<html><body>");
            String fname=req.getParameter("fname");
            String lname=req.getParameter("lname");
            String mail=req.getParameter("email");
            String pass=req.getParameter("password");
            String qury="insert into register( First_Name, Last_Name, Email, Password ) values(?,?,?,?);"; 
            Connection conn=DatabaseConnection.IntilizeConnection();
            
            PreparedStatement s=conn.prepareStatement(qury);
            out.print(fname);
            s.setString(1,fname);
            s.setString(2,lname);
            s.setString(3,mail);
            s.setString(4,pass);
            s.executeUpdate();
            
            
            out.println("<script>alert(\"registered Sucessfully\")</script></body></html>");
            res.sendRedirect("Register");
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e)
        {
            out.println("error");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }
}