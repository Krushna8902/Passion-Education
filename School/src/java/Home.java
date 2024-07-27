
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException, SQLException
    {
        PrintWriter out=res.getWriter();
        try
        {
            res.setContentType("text/html;charset=UTF-8");
            
            String user=req.getParameter("username");
            String pass=req.getParameter("password");
            try (Connection conn = DatabaseConnection .IntilizeConnection()) {
                Statement s=conn.createStatement();
                ResultSet rs=s.executeQuery("select * from register where Email='"+user+"' and Password='"+pass+"';");
                
                HttpSession session=req.getSession();
                session.setAttribute("email",user);
                if(rs.next())
                {
                    out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "    <title>Simple Dashboard</title>\n" +
                    "    <!-- Bootstrap CSS -->\n" +
                    "    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            display: flex;\n" +
                    "            min-height: 100vh;\n" +
                    "            flex-direction: column;\n" +
                    "        }\n" +
                    "        .wrapper {\n" +
                    "            display: flex;\n" +
                    "            flex: 1;\n" +
                    "        }\n" +
                    "        .sidebar {\n" +
                    "            width: 250px;\n" +
                    "            background: #343a40;\n" +
                    "            color: white;\n" +
                    "            padding: 15px;\n" +
                    "        }\n" +
                    "        .sidebar a {\n" +
                    "            color: white;\n" +
                    "            display: block;\n" +
                    "            padding: 10px 0;\n" +
                    "            text-decoration: none;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "        .sidebar a:hover {\n" +
                    "            background: #495057;\n" +
                    "        }\n" +
                    "        .content {\n" +
                    "            flex: 1;\n" +
                    "            padding: 20px;\n" +
                    "            display: none; /* Hide all content sections by default */\n" +
                    "        }\n" +
                    "        .content.active {\n" +
                    "            display: block; /* Show the active content section */\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<!-- Wrapper -->\n" +
                    "<div class=\"wrapper\">\n" +
                    "    <!-- Sidebar -->\n" +
                    "    <div class=\"sidebar text-center m-2\">\n" +
                    "        <a id=\"link-attendance\">Attendance</a>\n" +
                    "        <a id=\"link-marks\">Marks</a>\n" +
                    
                    "        <a id=\"link-logout\">Log Out</a>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <!-- Content Sections -->\n" +
                   /* "    <div id=\"content-welcome\" class=\"content active\">\n" +
                    "        <h2>Welcome </h2>\n" +
                    "        <p>This is the main content area. You can add your dashboard components here.</p>\n" +
                    "    </div>\n" +*/
                    "    <div id=\"content-attendance\" class=\"content active\">\n" );
                            Statement f=conn.createStatement(); 
                            ResultSet r=f.executeQuery("select * from student_attendance where Email='"+user+"';");
                            out.println("<table class=\"table\">\n" +
                                "  <thead class=\"thead-light\">");
                            out.println("<tr><th>Id</th><th>Student ID</th><th>Attendance</th><tr></thread>");       
                            while(r.next())
                            {
                                String at_Id=r.getString("ID");
                                String at_stu_id=r.getString("Student_ID");
                                String at_atten=r.getString("Attendance");
                                out.println("<tr><td>"+at_Id+"</td><td>"+at_stu_id+"</td><td>"+at_atten+"</td></tr></table>");
                            }
                            out.println("</div>");
                            out.println("<div id=\"content-marks\" class=\"content\">\n" );
                            Statement ms=conn.createStatement(); 
                            ResultSet rss=ms.executeQuery("select * from student_marks where Email='"+user+"';");
                            out.println("<table class=\"table\">\n" +
                                "  <thead class=\"thead-light\">");
                            out.println("<tr><th>Id</th><th>Student ID</th><th>Exam Date</th><th>Marathi</th><th>Hindi</th><th>Sanskrut</th><th>Science</th><th>Math</th><tr></thread>");  
                            
                            while(rss.next())
                            {
                                String a_Id=rss.getString("ID");
                                String a_stu_id=rss.getString("Student_ID");
                                String a_date=rss.getString("Exam_Date");
                                String mara=rss.getString("Marathi");
                                String hin=rss.getString("Hindi");
                                String sans=rss.getString("Sanskrut");
                                String sci=rss.getString("Science");
                                String ma=rss.getString("Math");
                                out.println("<tr><td>"+a_Id+"</td><td>"+a_stu_id+"</td><td>"+a_date+"</td><td>"+mara+"</td><td>"+hin+"</td><td>"+sans+"</td><td>"+sci+"</td><td>"+ma+"</td></tr></table>");
                            }
                    out.println("</div>"+
                           
                    "</div>\n" +
                    "\n" +
                    "<!-- Bootstrap JS and dependencies -->\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js\"></script>\n" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
                    "\n" +
                    "<script>\n" +
                    "    // Function to handle showing and hiding content sections\n" +
                    "    function showContent(contentId) {\n" +
                    "       document.querySelectorAll('.content').forEach(function(content) {\n" +
                    "            content.classList.remove('active');\n" +
                    "        });\n" +
                    "        // Show the selected content section\n" +
                    "        document.getElementById(contentId).classList.add('active');\n" +
                    "    }\n" +
                    "\n" +
                    "    // Add click event listeners to sidebar links\n" +
                    "    document.getElementById('link-attendance').addEventListener('click', function() {\n" +
                    "        showContent('content-attendance');\n" +
                    "    });\n" +
                    "	\n" +
                    "    document.getElementById('link-marks').addEventListener('click', function() {\n" +
                    "        showContent('content-marks');\n" +
                    "    });\n" +
                    "\n" +
                    "    document.getElementById('link-fees').addEventListener('click', function() {\n" +
                    "        showContent('content-fees');\n" +
                    "    });\n" +
                    "</script>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
                }
                else if(user.equals("admin")&& pass.equals("admin"))
                {
                    out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "    <title>Admin</title>\n" +
                    "    <!-- Bootstrap CSS -->\n" +
                    "    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            display: flex;\n" +
                    "            min-height: 100vh;\n" +
                    "            flex-direction: column;\n" +
                    "        }\n" +
                    "        .wrapper {\n" +
                    "            display: flex;\n" +
                    "            flex: 1;\n" +
                    "        }\n" +
                    "        .sidebar {\n" +
                    "            width: 250px;\n" +
                    "            background: #343a40;\n" +
                    "            color: white;\n" +
                    "            padding: 15px;\n" +
                    "        }\n" +
                    "        .sidebar a {\n" +
                    "            color: white;\n" +
                    "            display: block;\n" +
                    "            padding: 10px 0;\n" +
                    "            text-decoration: none;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "        .sidebar a:hover {\n" +
                    "            background: #495057;\n" +
                    "        }\n" +
                    "        .content {\n" +
                    "            flex: 1;\n" +
                    "            padding: 20px;\n" +
                    "            display: none; /* Hide all content sections by default */\n" +
                    "        }\n" +
                    "        .content.active {\n" +
                    "            display: block; /* Show the active content section */\n" +
                    "        }\n" +
                    "        body {\n" +
                    "            font-family: Arial, sans-serif;\n" +
                    "            background-color: #f0f0f0;\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "        }\n" +
                    "        form {\n" +
                    "            width: 500px;\n" +
                    "            margin: 50px auto;\n" +
                    "            padding: 20px;\n" +
                    "            background-color: #fff;\n" +
                    "            border: 1px solid #ddd;\n" +
                    "            height:60%\n"+
                    "        }\n" +
                    "        label {\n" +
                    "            display: block;\n" +
                    "            margin-top: 10px;\n" +
                    "            font-size: 16px;\n" +
                    "        }\n" +
                    "		input[type=\"number\"],\n" +
                    "        input[type=\"text\"],\n" +
                    "        input[type=\"email\"],\n" +
                    "        input[type=\"tel\"],\n" +
                    "        input[type=\"date\"],\n" +
                    "        input[type=\"password\"] {\n" +
                    "            width: 100%;\n" +
                    "            padding: 10px;\n" +
                    "            margin-top: 5px;\n" +
                    "            border: 1px solid #ddd;\n" +
                    "            border-radius: 5px;\n" +
                    "            box-sizing: border-box;\n" +
                    "        }\n" +
                    "        input[type=\"submit\"] {\n" +
                    "            width: 100%;\n" +
                    "            padding: 10px;\n" +
                    "            margin-top: 20px;\n" +
                    "            background-color: #007bff;\n" +
                    "            color: #fff;\n" +
                    "            border: none;\n" +
                    "            border-radius: 5px;\n" +
                    "            cursor: pointer;\n" +
                    "        }\n" +
                    "        input[type=\"submit\"]:hover {\n" +
                    "            background-color: #0056b3;\n" +
                    "        }\n" +

                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<!-- Wrapper -->\n" +
                    "<div class=\"wrapper\">\n" +
                    "    <!-- Sidebar -->\n" +
                    "    <div class=\"sidebar text-center m-2\">\n" +
                    "        <a id=\"link-student\">Add Student</a>\n" +
                    "        <a id=\"link-attendence\">Add Attendence</a>\n" +
                    "        <a id=\"link-marks\">Add Marks</a>\n" +
                    "        <a id=\"link-logout\">Log Out</a>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <!-- Content Sections -->\n" +
                    "    <div id=\"content-student\" class=\"content active\">\n" +
                    "    <div class=\"container\">\n" +
                    "        <h1 class=\"text-center p-2\">Enter Student Details</h1>\n" +
                    "        <form method=\"post\" action=\"student_register\" target=\"_blank\">\n" +
                    "            <label for=\"stu_id\">Student ID</label>\n" +
                    "            <input type=\"text\" id=\"stu_id\" name=\"stu_id\">\n" +
                    "            <label for=\"name\">Name:</label>\n" +
                    "            <input type=\"text\" id=\"name\" name=\"name\">\n" +
                    "            <label for=\"email\">Email:</label>\n" +
                    "            <input type=\"email\" id=\"email\" name=\"email\">\n" +
                    "            <label for=\"mobile\">Mobile:</label>\n" +
                    "            <input type=\"tel\" id=\"mobile\" name=\"mobile\">\n" +
                    "            <label for=\"address\">Address:</label>\n" +
                    "            <input type=\"text\" id=\"address\" name=\"address\">\n" +
                    "            <input type=\"submit\" value=\"Save\">\n" +
                    "        </form>\n" +
                    "    </div>\n" +
                    "    </div>\n" +
                    "    <div id=\"content-attendance\" class=\"content\">\n" +
                    "        <div class=\"container\">\n" +
                    "        <h1 class=\"text-center p-4\">Enter Attendance</h1>\n" +
                    "        <form method=\"post\" action=\"student_attendance\" target=\"_blank\">\n" +
                    "            <label for=\"stu_id\">Student ID</label>\n" +
                    "            <input type=\"number\" id=\"stu_id\" name=\"stu_id\">\n" +
                    "            <label for=\"email\">Email:</label>\n" +
                    "            <input type=\"email\" id=\"email\" name=\"email\">\n" +
                    "            <label for=\"attendance\">Attendance:</label>\n" +
                    "            <input type=\"number\" id=\"attendance\" name=\"attendance\">\n" +
                    "            <input type=\"submit\" value=\"Save\">\n" +
                    "        </form>\n" +
                    "       </div>"+      
                    "     </div>\n" +
                    "    <div id=\"content-marks\" class=\"content\">\n" +
                    " <div class=\"container\">\n" +
                    "        <h1 class=\"text-center p-4\">Enter Marks</h1>\n" +
                    "        <form method=\"post\" action=\"student_marks\" target=\"_blank\">\n" +
                    "                   <label for=\"stu_id\">Student ID</label>\n" +
                    "                   <input type=\"number\" id=\"stu_id\" name=\"stu_id\">\n" +
                    "			<label for=\"email\">Email:</label>\n" +
                    "                   <input type=\"email\" id=\"email\" name=\"email\">\n" +
                    "			<label for=\"exam_date\">Exam Date:</label>\n" +
                    "                   <input type=\"date\" id=\"exam_date\" name=\"exam_date\">\n" +
                    "			<label for=\"marathi\">Marathi:</label>\n" +
                    "			<input type=\"number\" id=\"marathi\" name=\"marathi\">\n" +
                    "			<label for=\"hindi\">Hindi:</label>\n" +
                    "			<input type=\"number\" id=\"hindi\" name=\"hindi\">\n" +
                    "			<label for=\"sanskrut\">Sanskrut:</label>\n" +
                    "			<input type=\"number\" id=\"sanskrut\" name=\"sanskrut\">\n" +
                    "			<label for=\"math\">Math:</label>\n" +
                    "			<input type=\"number\" id=\"math\" name=\"math\">\n" +
                    "			<label for=\"science\">Science:</label>\n" +
                    "			<input type=\"number\" id=\"science\" name=\"science\">\n" +
                    "            <input type=\"submit\" value=\"Save\">\n" +
                    "        </form>\n" +
                    "    </div>"+   
                    "    </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "<!-- Bootstrap JS and dependencies -->\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js\"></script>\n" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
                    "\n" +
                    "<script>\n" +
                    "    // Function to handle showing and hiding content sections\n" +
                    "    function showContent(contentId) {\n" +
                    "       document.querySelectorAll('.content').forEach(function(content) {\n" +
                    "            content.classList.remove('active');\n" +
                    "        });\n" +
                    "        // Show the selected content section\n" +
                    "        document.getElementById(contentId).classList.add('active');\n" +
                    "    }\n" +
                    "\n" +
                    "    // Add click event listeners to sidebar links\n" +
                    "    document.getElementById('link-student').addEventListener('click', function() {\n" +
                    "        showContent('content-student');\n" +
                    "    });\n" +
                    "	\n" +
                    "	document.getElementById('link-attendence').addEventListener('click', function() {\n" +
                    "        showContent('content-attendance');\n" +
                    "    });\n" +
                    "	\n" +
                    "    document.getElementById('link-marks').addEventListener('click', function() {\n" +
                    "        showContent('content-marks');\n" +
                    "    });\n" +
                    "\n" +
                    "</script>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
                }
                else
                {
                    res.sendRedirect("Login");
                }
                
                out.println("<!-- Bootstrap JS (optional, if needed) -->\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>\n" +
                "</body>\n" +
                "</html>");
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
         out.println(e);
        } 
    }
    
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      
    public String getServletInfo() {
        return "Short description";
    }            
}

