package edu.matc.controller;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
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
import java.util.List;

/**
 * A servlet to set variables before hitting the landing page
 * @author rbruinsma
 */

@WebServlet(
		name = "landingPageSetup",
        urlPatterns = {"/landingPageSetup"}
)

public class LandingPageSetup extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//logger.info("I'm in the LandingPageSetup doGet");
    	boolean isLoggedIn = false;
    	String anchorName = "";

    	// from GET request
        anchorName = request.getParameter("anchorName");

        if (!(anchorName != null && !anchorName.isEmpty())) {
            anchorName = "top";
        }
        logger.info("anchor name: " + anchorName);

        HttpSession session = request.getSession();
        String username = request.getRemoteUser();
        logger.info("username: " + username);

    	request.setAttribute("isLoggedIn", isLoggedIn);
        request.setAttribute("anchorName", anchorName);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}