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
 * A servlet to set variables before hitting the landing page
 * @author rbruinsma
 */

@WebServlet(
		name = "loginRouter",
        urlPatterns = {"/loginRouter"}
)

public class LoginRouter extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("I'm in the login router");
    	boolean isLoggedIn = false;
    	String userRole = "";
    	String fileName = "";

    	// GET from the request object
		HttpSession session = request.getSession();
		String pageToGoTo = request.getParameter("routingTo");
		logger.info("page I want to go to: " + pageToGoTo);
		String username = request.getRemoteUser();
		logger.info("username is: " + username);

		if (request.isUserInRole("admin")){
			userRole = "admin";
			isLoggedIn = true;
		} else if (request.isUserInRole("shopper")) {
			userRole = "shopper";
			isLoggedIn = true;
		}

		logger.info("user's role is: " + userRole);
		request.setAttribute("anchorName", "#tm");

		if (pageToGoTo.equals("admin")) {
			fileName = "adminPage.jsp";
		} else if (pageToGoTo.equals("shopper")) {
			fileName = "shopperPage.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(fileName);
        dispatcher.forward(request, response);
    }
}