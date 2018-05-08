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
import java.util.List;


/**
 * A servlet to search the Stores database.
 * @author rbruinsma
 */

@WebServlet(
        name = "searchStores",
        urlPatterns = {"/searchStores"}
)

public class AdminSearchStores extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * To forward the request from the delete stores servlet to refresh the page with the list of stores
     * minus the deleted one
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

        List<Store> stores;
        //from GET request

        //String searchTypeQuery = request.getParameter("searchType");
        //field to search by
        String searchByQuery = request.getParameter("searchBy");
        //term to look for in field above
        String searchKeywordQuery = request.getParameter("searchTerm");
        String searchPage = request.getParameter("searchPage");

        logger.info(searchByQuery);
        logger.info(searchKeywordQuery);


        GenericDao storeDao = new GenericDao(Store.class);

        if (searchByQuery.equals("all")) {
            stores = storeDao.getAll();
        } else {
            stores = storeDao.getByPropertyLike(searchByQuery, searchKeywordQuery);
        }
		request.setAttribute("stores", stores);
		request.setAttribute("searchPage", searchPage);
        request.setAttribute("searchBy", searchByQuery);
        request.setAttribute("searchTerm", searchKeywordQuery);

		RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");


        dispatcher.forward(request, response);
    }
}