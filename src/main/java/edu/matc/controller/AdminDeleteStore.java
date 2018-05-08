package edu.matc.controller;

import edu.matc.entity.Store;
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
import java.io.IOException;


/**
 * A servlet to delete a Store from the database.
 * @author rbruinsma
 */

@WebServlet(
		name = "deleteStore",
        urlPatterns = {"/deleteStore"}
)

public class AdminDeleteStore extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String searchTerm = null;
        //from POST request
		int storeIdToDelete = Integer.parseInt(request.getParameter("id"));
		logger.info("storeId: " + storeIdToDelete);
		String searchBy = request.getParameter("searchBy");
		if (searchBy.equals("all")) {
			searchTerm = null;
		} else {
			searchTerm = request.getParameter("searchTerm");
			request.setAttribute("searchTerm", searchTerm);
		}
		logger.info("searchTerm is: " + searchTerm);
		
        //grab store to delete
		GenericDao storeDao = new GenericDao(Store.class);
		Store storeToDelete = (Store)storeDao.getById(storeIdToDelete);

		// delete store
		storeDao.delete(storeToDelete);

		request.setAttribute("searchPage", "store");
		//request.setAttribute("anchorName", "#deleteUsersResults");
		//request.setAttribute("deleteMessage", "success");
		request.setAttribute("searchBy", searchBy);

        RequestDispatcher dispatcher = request.getRequestDispatcher("searchStores");
        dispatcher.forward(request, response);
    }
}