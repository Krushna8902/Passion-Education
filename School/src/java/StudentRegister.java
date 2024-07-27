

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
public class StudentRegister extends HttpServlet{
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        PrintWriter out=res.getWriter();
        try
        {
            res.setContentType("text/html;charset=UTF-8");
            String stu_id=req.getParameter("stu_id");
            String name=req.getParameter("name");
            String mail=req.getParameter("email");
            String mobile=req.getParameter("mobile");
            String address=req.getParameter("address");
            out.println(stu_id);
            String qry="insert into student_register(Student_id,Name,Email,Mobile,Address) values(?,?,?,?,?)";
            Connection conn=DatabaseConnection.IntilizeConnection();
            PreparedStatement s=conn.prepareStatement(qry);
            s.setInt(1,Integer.parseInt(stu_id));
            s.setString(2,name);
            s.setString(3, mail);
            s.setString(4,mobile);
            s.setString(5,address);
            s.execute();
            out.println("<script>alert(\"registered Sucessfully\")</script></body></html>");
            res.sendRedirect("Login");
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e)
        {
            out.println("<script>alert(\"error\")</script></body></html>");
            res.sendRedirect("Login");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

     
    public String getServletInfo() {
        return "Short description";
    }
}
