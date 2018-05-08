package edu.matc.controller;

import grocery.api.deals.Deal;
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
 * A servlet to grab logged in user,
 * and forward to shopperPage
 * @author rbruinsma
 */

@WebServlet(
		name = "toShopperPage",
        urlPatterns = {"/toShopperPage"}
)

public class RoutingToShopperPage extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Routes to doGet, to reload list of deals
     *
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("I'm being routed to ShopperPage doGet");
    	boolean isLoggedIn = true;
    	String anchorName = "top";
    	String role = "shopper";

    	// from GET request
        String username = request.getRemoteUser();
        logger.info("username is: " + username);
        List<Deal> deals = (List)request.getAttribute("deals");
        String searchPage = (String)request.getAttribute("searchPage");
        logger.info("what's in the deals object? " + deals);
        //set username into session variable
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

    	request.setAttribute("isLoggedIn", isLoggedIn);
        request.setAttribute("anchorName", anchorName);
        request.setAttribute("role", role);
        request.setAttribute("deals", deals);
        request.setAttribute("searchPage", searchPage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("shopperPage.jsp");
        dispatcher.forward(request, response);
    }
}