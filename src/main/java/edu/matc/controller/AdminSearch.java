package edu.matc.controller;

import edu.matc.entity.Item;
import edu.matc.entity.Role;
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
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * A servlet to search the database.
 * @author rbruinsma
 */

@WebServlet(
        urlPatterns = {"/adminSearch"}
)

public class AdminSearch extends HttpServlet {

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
        //search type - either items, users, stores
        String searchTypeQuery = request.getParameter("searchType");
        //field to search by
        String searchByQuery = request.getParameter("searchBy");
        //term to look for in field above
        String searchKeywordQuery = request.getParameter("searchTerm");

        logger.info(searchTypeQuery);
        logger.info(searchByQuery);
        logger.info(searchKeywordQuery);

        switch (searchTypeQuery) {
            case "item":    GenericDao itemDao = new GenericDao(Item.class);
                            if (searchByQuery.equals("store")) {
                                //search store entity by name entered
                                GenericDao storeDao = new GenericDao(Store.class);
                                List<Store> storeList = storeDao.getByPropertyLike("name", searchKeywordQuery);
                                // from store objects, make a list of store ids
                                List<Integer> storeIdList = new ArrayList<>();
                                for (Store store : storeList) {
                                    storeIdList.add(store.getId());
                                }
                                //for each store id, grab items associated with the store
                                TreeSet<Item> items = new TreeSet<Item>();
                                for (int storeId : storeIdList) {
                                    List<Item> itemsToAdd = itemDao.getByPropertyEqual("store.get(store_id", storeId);
                                    for (Item item : itemsToAdd) {
                                        items.add(item);
                                    }
                                }

                                request.setAttribute("items", items);

                            } else {
                                //logger.info("in the case/switch");
                                List<Item> itemList = itemDao.getByPropertyLike(searchByQuery, searchKeywordQuery);
                                //logger.info("number of items found: " + itemList.size());
                                request.setAttribute("items", itemList);
                            }
                            request.setAttribute("searchPage", "item");
                            break;
            case "user":    GenericDao userDao = new GenericDao(User.class);
                            if (searchByQuery.equals("role")) {
                                GenericDao roleDao = new GenericDao(Role.class);
                                List<Role> roleList = roleDao.getByPropertyLike("name", searchKeywordQuery);
                                // from role objects, make a list of users
                                List<User> userList = new ArrayList<>();
                                for (Role role : roleList) {
                                    userList.add(role.getUser());
                                }
                                request.setAttribute("users", userList);
                            } else {
                                request.setAttribute("users", userDao.getByPropertyLike(searchByQuery, searchKeywordQuery));
                            }
                            request.setAttribute("searchPage", "user");
                            break;
            case "store":   GenericDao storeDao = new GenericDao(Store.class);
                            request.setAttribute("stores", storeDao.getByPropertyLike(searchByQuery, searchKeywordQuery));
                            request.setAttribute("searchPage", "store");
                            break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}