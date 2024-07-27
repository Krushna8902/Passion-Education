
import jakarta.servlet.ServletException;
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
public class Register extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter())
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\" ng-app=\"signupApp\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "  <title>Signup Form</title>\n" +
                        "  <!-- Bootstrap CSS -->\n" +
                        "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
                        "  <style>\n" +
                        "    body {\n" +
                        "      background-color: #f8f9fa; \n" +
                        "    }\n" +
                        "  </style>\n" +
                        "</head>\n" +
                        "<body ng-controller=\"SignupController as vm\">\n" +
                        "\n" +
                        "  <div class=\"container mt-5\">\n" +
                        "    <div class=\"row justify-content-center\">\n" +
                        "      <div class=\"col-md-4\">\n" +
                        "        <div class=\"card\">\n" +
                        "          <div class=\"card-header\">\n" +
                        "            Sign Up\n" +
                        "          </div>\n" +
                        "          <div class=\"card-body\">\n" +
                        "            <form  action=\"insert\" method=\"post\">\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"firstName\">First Name</label>\n" +
                        "                <input type=\"text\" name=\"fname\" class=\"form-control\" ng-model=\"vm.firstName\" placeholder=\"Enter your first name\">\n" +
                        "                <small class=\"text-danger\">{{ vm.firstNameError }}</small>\n" +
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"lastName\">Last Name</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" name=\"lname\" ng-model=\"vm.lastName\" placeholder=\"Enter your last name\">\n" +
                        "                <small class=\"text-danger\">{{ vm.lastNameError }}</small>\n" +
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"email\">Email</label>\n" +
                        "                <input type=\"email\" class=\"form-control\" name=\"email\" ng-model=\"vm.email\" placeholder=\"Enter your email\">\n" +
                        "                <small class=\"text-danger\">{{ vm.emailError }}</small>\n" +
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"password\">Password</label>\n" +
                        "                <input type=\"password\" class=\"form-control\" name=\"password\" ng-model=\"vm.password\" placeholder=\"Enter your password\">\n" +
                        "                <small class=\"text-danger\">{{ vm.passwordError }}</small>\n" +
                        "              </div>\n" +
                        "              <button type=\"submit\" class=\"btn btn-primary\">Sign Up</button>\n" +
                        "            </form>\n" +
                        "            <div class=\"mt-3\">\n" +
                        "              <p>Already have an account? <a href=\"Login\">Login</a></p>\n" +
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
                        "    angular.module('signupApp', [])\n" +
                        "    .controller('SignupController', function() {\n" +
                        "      var vm = this;\n" +
                        "\n" +
                        "      vm.signup = function() {\n" +
                        "       \n" +
                        "        vm.firstNameError = \"\";\n" +
                        "        vm.lastNameError = \"\";\n" +
                        "        vm.emailError = \"\";\n" +
                        "        vm.passwordError = \"\";\n" +
                        "\n" +
                        "        if (!vm.firstName || vm.firstName.trim() === \"\") {\n" +
                        "          vm.firstNameError = \"First name is required\";\n" +
                        "          return;\n" +
                        "        }     \n" +
                        "        if (!vm.lastName || vm.lastName.trim() === \"\") {\n" +
                        "          vm.lastNameError = \"Last name is required\";\n" +
                        "          return;\n" +
                        "        }       \n" +
                        "        if (!vm.email || vm.email.trim() === \"\") {\n" +
                        "          vm.emailError = \"Email is required\";\n" +
                        "          return;\n" +
                        "        }         \n" +
                        "        if (!vm.password || vm.password.trim() === \"\") {\n" +
                        "          vm.passwordError = \"Password is required\";\n" +
                        "          return;\n" +
                        "        }       \n" +
                        "      \n" +
                        "      };\n" +
                        "\n" +
                        "      \n" +
                        "      \n" +
                        "      \n" +
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

