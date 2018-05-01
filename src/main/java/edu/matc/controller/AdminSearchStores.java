package edu.matc.controller;

import edu.matc.entity.Store;
import edu.matc.persistence.GenericDao;
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
 * A servlet to search the Stores database.
 * @author rbruinsma
 */

@WebServlet(
        urlPatterns = {"/searchStores"}
)

public class AdminSearchStores extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //from GET request

        //String searchTypeQuery = request.getParameter("searchType");
        //field to search by
        String searchByQuery = request.getParameter("searchBy");
        //term to look for in field above
        String searchKeywordQuery = request.getParameter("searchTerm");

        logger.info(searchByQuery);
        logger.info(searchKeywordQuery);


        GenericDao storeDao = new GenericDao(Store.class);
		request.setAttribute("stores", storeDao.getByPropertyLike(searchByQuery, searchKeywordQuery));
		request.setAttribute("searchPage", "store");


        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}