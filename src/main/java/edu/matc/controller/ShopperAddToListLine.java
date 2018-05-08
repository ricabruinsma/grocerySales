package edu.matc.controller;

import edu.matc.entity.Item;
import edu.matc.entity.ListLine;
import edu.matc.entity.ShoppingList;
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
import java.util.List;


/**
 * Adds item to user's shoppingList
 *
 * @author rbruinsma
 */

@WebServlet(
        name = "addToList",
        urlPatterns = {"/addToList"}
)

public class ShopperAddToListLine extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This retrieves the shopper's shopping list or creates a new one for the shopper
     *
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // from the POST
        //String routeDealsTo = request.getParameter("routeDealsTo");
        //String searchType = request.getParameter("searchType");
        //String username = request.getParameter("username");
        int shoppingListId = (Integer)request.getAttribute("shoppingListId");
        int itemToAddId = (Integer)request.getAttribute("itemToAddId");


        // grab shopping list object
        GenericDao shoppingListDao = new GenericDao(ShoppingList.class);
        ShoppingList shoppingList = (ShoppingList)shoppingListDao.getById(shoppingListId);

        // grab item object
        GenericDao itemDao = new GenericDao(Item.class);
        Item itemToAdd = (Item)itemDao.getById(itemToAddId);

        // is there a listline that has this object already?
        GenericDao listLineDao = new GenericDao(ListLine.class);
        List<ListLine> listLines = listLineDao.getByPropertyEqual("item", itemToAdd);

        // if so, update the quantity of item in listline, and update in DB
        if (listLines.size() > 0) {
            ListLine listLineToUpdate = listLines.get(0);
            int oldQuantity = listLineToUpdate.getQuantity();
            int newQuantity = oldQuantity + 1;
            listLineToUpdate.setQuantity(newQuantity);
            listLineDao.saveOrUpdate(listLineToUpdate);
        } else {
            // create new listline
            ListLine newListLine = new ListLine(1, shoppingList, itemToAdd);

            // insert new listline into DB
            int listLineId = listLineDao.insert(newListLine);
        }

        //request.setAttribute("routeDealsTo", routeDealsTo);
        //request.setAttribute("searchType", searchType);
        //request.setAttribute("username", username);
        //request.setAttribute("itemId", itemToAddId);
        //request.setAttribute("shoppingListId", shoppingListId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("getDeals");

        dispatcher.forward(request, response);
    }
}