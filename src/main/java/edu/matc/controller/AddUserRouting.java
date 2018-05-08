package edu.matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to send admin to sign-up form on index page
 * @author rbruinsma
 */

@WebServlet(
		name = "addUserRouting",
        urlPatterns = {"/addUser"}
)

public class AddUserRouting extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("I'm in the AddUserRouting doGet");
    	boolean isLoggedIn = true;
    	String anchorName = "signUpSection";

        logger.info("anchor name: " + anchorName);

    	request.setAttribute("isLoggedIn", isLoggedIn);
        request.setAttribute("anchorName", anchorName);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}