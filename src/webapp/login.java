package webapp;

import appLayer.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "login"
)
public class login extends HttpServlet {
    public login() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userObject = new User();
        PrintWriter out = response.getWriter();
        out.println("doPost-version");
        String var10001 = request.getParameter("loginname");
        out.print("login-name:" + var10001 + " Password:" + request.getParameter("password"));
        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));
        if (userObject.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password"))) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid login and password. Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String var10001 = request.getParameter("loginname");
        out.print("login-name:" + var10001 + " Password:" + request.getParameter("password"));
    }
}
