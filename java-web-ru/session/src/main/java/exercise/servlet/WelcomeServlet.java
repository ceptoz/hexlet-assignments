package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
        requestDispatcher.forward(request, response);
    }
}
