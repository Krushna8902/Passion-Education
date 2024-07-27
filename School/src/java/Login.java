
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Login extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter())
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\" ng-app=\"loginApp\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "  <title>Login</title>\n" +
                        " \n" +
                        "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
                        "  <style>\n" +
                        "    body {\n" +
                        "      background-color: #f8f9fa; \n" +
                        "    }\n" +
                        "  </style>\n" +
                        "</head>\n" +
                        "<body ng-controller=\"LoginController as vm\">\n" +
                        "  \n" +
                        "  <div class=\"container mt-5\">\n" +
                        "    <div class=\"row justify-content-center\">\n" +
                        "      <div class=\"col-md-4\">\n" +
                        "        <div class=\"card\">\n" +
                        "          <div class=\"card-header\">\n" +
                        "            Login\n" +
                        "          </div>\n" +
                        "          <div class=\"card-body\">\n" +
                        "            <form action=\"home\" method=\"post\">\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"username\">Username</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" ng-model=\"vm.username\" placeholder=\"Enter your username\">\n" +
                        "                <small class=\"text-danger\">{{ vm.usernameError }}</small>\n" +
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"password\">Password</label>\n" +
                        "                <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" ng-model=\"vm.password\" placeholder=\"Enter your password\">\n" +
                        "                <small class=\"text-danger\">{{ vm.passwordError }}</small>\n" +
                        "              </div>\n" +
                        "              <button type=\"submit\" class=\"btn btn-primary\">Login</button>\n" +
                        "            </form>\n" +
                        "            <div class=\"mt-3\">\n" +
                        "              <p class=\"mb-0\">Don't have an account? <a href=\"Register\">Sign Up</a></p>\n" +
                        "              <p class=\"mb-0\"><a href=\"forget.html\">Forgot Password?</a></p>\n" +
                        "            </div>\n" +
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "\n" +
                        "  \n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js\"></script>\n" +
                        "  <script>\n" +
                        "    angular.module('loginApp', [])\n" +
                        "    .controller('LoginController', function() {\n" +
                        "      var vm = this;\n" +
                        "\n" +
                        "      vm.login = function() {\n" +
                        "        vm.usernameError = \"\";\n" +
                        "        vm.passwordError = \"\";\n" +
                        "        if (!vm.username || vm.username.trim() === \"\") {\n" +
                        "          vm.usernameError = \"Username is required\";\n" +
                        "          return;\n" +
                        "        }\n" +
                        "        if (!vm.password || vm.password.trim() === \"\") {\n" +
                        "          vm.passwordError = \"Password is required\";\n" +
                        "          return;\n" +
                        "        }\n" +
                        "      };\n" +
                        "    });\n" +
                        "  </script>\n" +
                        "</body>\n" +
                        "</html>");
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

