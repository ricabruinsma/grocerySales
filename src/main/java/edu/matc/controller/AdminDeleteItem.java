package edu.matc.controller;

import edu.matc.entity.Item;
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
 * A servlet to delete an Item from the database.
 * @author rbruinsma
 */

@WebServlet(
		name = "deleteItem",
        urlPatterns = {"/deleteItem"}
)

public class AdminDeleteItem extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //from POST request
		int itemIdToDelete = Integer.parseInt(request.getParameter("itemToDeleteId"));
		logger.info("itemId: " + itemIdToDelete);
		String searchBy = request.getParameter("searchBy");
		String searchTerm = request.getParameter("searchTerm");
		
        //grab item to delete
		GenericDao itemDao = new GenericDao(Item.class);
		Item itemToDelete = (Item)itemDao.getById(itemIdToDelete);

		// then delete item
		itemDao.delete(itemToDelete);

		request.setAttribute("searchPage", "item");
		request.setAttribute("anchorName", "#deleteItemResults");
		request.setAttribute("deleteMessage", "success");
		request.setAttribute("searchBy", searchBy);
		request.setAttribute("searchTerm", searchTerm);

        RequestDispatcher dispatcher = request.getRequestDispatcher("searchItems");
        dispatcher.forward(request, response);
    }
}