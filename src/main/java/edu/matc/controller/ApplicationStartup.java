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
 * A servlet to set variables before hitting the landing page
 * @author rbruinsma
 */

@WebServlet(
		name = "applicationStartup",
        urlPatterns = {"/grocerySales-startup"}

)

public class ApplicationStartup extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * initializes application
     * @throws ServletException if there is a servlet failure
     */
    @Override
    public void init() throws ServletException {

		logger.info("I'm in the Application Startup");
    	boolean isLoggedIn = false;


    }
}