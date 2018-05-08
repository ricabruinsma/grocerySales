package edu.matc.controller;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A servlet to gather the user's shopping list
 * This is called after the item is added to DB (if not already in there)
 * And will forward information to add item to user's shopping list.
 * @author rbruinsma
 */

@WebServlet(
        name = "retrieveShoppingList",
        urlPatterns = {"/retrieveShoppingList"}
)

public class ShopperRetrieveShoppingList extends HttpServlet {

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

        int shoppingListId = 0;

        // from the POST
        //String routeDealsTo = request.getParameter("routeDealsTo");
        //String searchType = request.getParameter("searchType");
        //String username = request.getParameter("username");
        //int itemToAddId = (Integer)request.getAttribute("itemToAddId");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");



        // get the user by username
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByPropertyEqual("username", username);
        User user = users.get(0);

        // get shopping list for user
        GenericDao shoppingListDao = new GenericDao(ShoppingList.class);
        List<ShoppingList> lists = shoppingListDao.getByPropertyEqual("user", user);

        if (lists.size() == 0) {
            ShoppingList newList = new ShoppingList(99.99, user);
            shoppingListId = shoppingListDao.insert(newList);
        } else {
            ShoppingList userList = lists.get(0);
            shoppingListId = userList.getId();
        }

        //request.setAttribute("routeDealsTo", routeDealsTo);
        //request.setAttribute("searchType", searchType);
        //request.setAttribute("username", username);
        //request.setAttribute("itemId", itemToAddId);
        request.setAttribute("shoppingListId", shoppingListId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("addToList");

        dispatcher.forward(request, response);
    }
}