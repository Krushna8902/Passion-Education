
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class StudentAttendance extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException, SQLException, ClassNotFoundException
    {
        PrintWriter out=res.getWriter();
        try
        {
            String stu_id=req.getParameter("stu_id");
            String mail=req.getParameter("email");
            String atten=req.getParameter("attendance");
            Connection conn=DatabaseConnection.IntilizeConnection();
            String qry="Insert into student_attendance(Student_ID,Email,Attendance) values(?,?,?);";
            PreparedStatement s= conn.prepareStatement(qry);
            s.setInt(1,Integer.parseInt(stu_id));
            s.setString(2, mail);
            s.setInt(3,Integer.parseInt(atten));
            s.execute();
            out.println("<script>alert(\"registered Sucessfully\")</script></body></html>");
            res.sendRedirect("Login");    
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e)
        {
            out.println("<script>alert(\"error\")</script></body></html>");
            out.println(e);
        }
    }
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      
    public String getServletInfo() {
        return "Short description";
    }       
}