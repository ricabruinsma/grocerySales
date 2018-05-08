package edu.matc.controller;

import edu.matc.entity.ShoppingList;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A servlet to grab and return the shopper's shopping list
 * @author rbruinsma
 */

@WebServlet(
        name = "showShoppingList",
        urlPatterns = {"/showShoppingList"}
)

public class ShopperShowShoppingList extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Route to doGet, after deleting a shopping list item.  Re-load remaining shopping list
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

        // grab user object from username
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByPropertyEqual("username", username);
        User user = users.get(0);

        // retrieve user's shopping list
        GenericDao shoppingListDao = new GenericDao(ShoppingList.class);
        List<ShoppingList> lists = shoppingListDao.getByPropertyEqual("user", user);
        ShoppingList list = lists.get(0);

		request.setAttribute("shoppingList", list);
		request.setAttribute("showList", true);

		RequestDispatcher dispatcher = request.getRequestDispatcher("shopperPage.jsp");
        dispatcher.forward(request, response);
    }
}