package edu.matc.controller;

import edu.matc.entity.ListLine;
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
 * A servlet to delete an item from shopper's shopping list
 * @author rbruinsma
 */

@WebServlet(
		name = "deleteShoppingListItem",
        urlPatterns = {"/deleteShoppingListItem"}
)

public class ShopperDeleteListLine extends HttpServlet {

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
		int listLineIdToDelete = Integer.parseInt(request.getParameter("listLineIdToDelete"));
		
        //grab listLine to delete
		GenericDao listLineDao = new GenericDao(ListLine.class);
		ListLine listLineToDelete = (ListLine)listLineDao.getById(listLineIdToDelete);

		// delete store
		listLineDao.delete(listLineToDelete);

		//request.setAttribute("searchPage", "store");
		//request.setAttribute("anchorName", "#deleteUsersResults");
		//request.setAttribute("deleteMessage", "success");
		//request.setAttribute("searchBy", searchBy);

        RequestDispatcher dispatcher = request.getRequestDispatcher("showShoppingList");
        dispatcher.forward(request, response);
    }
}