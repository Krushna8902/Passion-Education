
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
public class StudentMarks extends HttpServlet
{
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException, SQLException, ClassNotFoundException
    {
        PrintWriter out=res.getWriter();
        try
        {
           String stu_id=req.getParameter("stu_id");
           String mail=req.getParameter("email");
           String date=req.getParameter("exam_date");
           String mara=req.getParameter("marathi");
           String hindi=req.getParameter("hindi");
           String sans=req.getParameter("sanskrut");
           String sci=req.getParameter("science");
           String math=req.getParameter("math");
           Connection conn=DatabaseConnection.IntilizeConnection();
           String qry="Insert into student_marks(Student_ID,Email,Exam_Date,Marathi,Hindi,Sanskrut,Science,Math) values(?,?,?,?,?,?,?,?);";
           PreparedStatement s= conn.prepareStatement(qry);
           s.setInt(1,Integer.parseInt(stu_id));
           s.setString(2, mail);
           s.setString(3,date);
           s.setInt(4,Integer.parseInt(mara));
           s.setInt(5,Integer.parseInt(hindi));
           s.setInt(6,Integer.parseInt(sans));
           s.setInt(7,Integer.parseInt(sci));
           s.setInt(8,Integer.parseInt(math));
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
            Logger.getLogger(StudentMarks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(StudentMarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      
    public String getServletInfo() {
        return "Short description";
    }
}
