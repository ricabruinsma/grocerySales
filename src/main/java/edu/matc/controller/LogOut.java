package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A servlet to logout the user
 */
@WebServlet (
        name = "LogOut",
        urlPatterns = {"/logout"}
)
public class LogOut extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String loggedInUser = request.getRemoteUser();

        logger.info(loggedInUser);

        session.invalidate();

        //String url = "index.jsp";

        request.setAttribute("anchorName", "top");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}
