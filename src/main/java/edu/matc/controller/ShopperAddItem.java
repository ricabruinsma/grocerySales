package edu.matc.controller;

import edu.matc.entity.*;
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
import java.util.Set;

/**
 * A servlet to add item to DB.
 * The item will be routed to a servlet to add to user's shopping list
 * @author rbruinsma
 */

@WebServlet(
        name = "addItem",
        urlPatterns = {"/addItem"}
)
public class ShopperAddItem extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean active = true;
        boolean alreadyInDb = false;
        int itemId = 0;

        //from POST request
        //String routeDealsTo = request.getParameter("routeDealsTo");
        //String searchType = request.getParameter("searchType");
        //String username = request.getParameter("username");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        String product = request.getParameter("product");
        String size = request.getParameter("size");
        String salePrice = request.getParameter("salePrice");
        String savingsAmount = request.getParameter("savingsAmount");
        String saleEndDate = request.getParameter("saleEndDate");
        String storeName = request.getParameter("storeName");

        // grab category entity
        GenericDao categoryDao = new GenericDao(Category.class);
        List<Category> categories = categoryDao.getByPropertyEqual("name", category);
        Category itemCategory = categories.get(0);

        // grab store entity
        GenericDao storeDao = new GenericDao(Store.class);
        List<Store> stores = storeDao.getByPropertyEqual("name", storeName);
        Store itemStore = stores.get(0);

        Item newItem = new Item(brand, itemCategory, product, size, salePrice, savingsAmount, saleEndDate, active, itemStore);
        //logger.info(newItem);

        Set<Item> storeItems = itemStore.getItems();
        for (Item item: storeItems) {
            if (item == newItem) {
                alreadyInDb = true;
                itemId = item.getId();
            }
        }

        if (!alreadyInDb) {
            GenericDao itemDao = new GenericDao(Item.class);
            itemId = itemDao.insert(newItem);
        }


        //request.setAttribute("routeDealsTo", routeDealsTo);
        //request.setAttribute("searchType", searchType);
        //request.setAttribute("username", username);
        request.setAttribute("itemToAddId", itemId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("retrieveShoppingList");
        dispatcher.forward(request, response);
    }
}
