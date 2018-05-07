package edu.matc.controller;

import edu.matc.entity.Item;
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
import java.util.*;

/**
 * A servlet to search the Item database.
 * @author rbruinsma
 */

@WebServlet(
        urlPatterns = {"/searchItems"}
)

public class AdminSearchItems extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * When re-loading the page after an item is deleted, shuttle from doPost to doGet
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

		//from GET request
		//String searchTypeQuery = request.getParameter("searchType");

		//field to search by
		String searchByQuery = request.getParameter("searchBy");
		//term to look for in field above
		String searchKeywordQuery = request.getParameter("searchTerm");

		//logger.info(searchTypeQuery);
		logger.info(searchByQuery);
		logger.info(searchKeywordQuery);

		GenericDao itemDao = new GenericDao(Item.class);

		// store query needs to go through the store DB first...
		if (searchByQuery.equals("store")) {
			//search store entity by name entered
			GenericDao storeDao = new GenericDao(Store.class);
			List<Store> storeList = storeDao.getByPropertyLike("name", searchKeywordQuery);
			logger.info("storeList size " + storeList.size());

			//for each store object, grab items associated with that store
			Set<Item> items = new HashSet<>();
			for (Store store : storeList) {
				List<Item> itemsToAdd = itemDao.getByPropertyEqual("store", store);
				logger.info("items from willy: " + itemsToAdd.size());
				for (Item item : itemsToAdd) {
					items.add(item);
				}
			}

			request.setAttribute("items", items);

		} else if (searchByQuery.equals("all")) {
			List<Item> itemAll = itemDao.getAll();
			request.setAttribute("items", itemAll);
		} else {
			//logger.info("in the case/switch");
			List<Item> itemList = itemDao.getByPropertyLike(searchByQuery, searchKeywordQuery);
			//logger.info("number of items found: " + itemList.size());
			request.setAttribute("items", itemList);
		}
		request.setAttribute("searchPage", "item");
		request.setAttribute("searchBy", searchByQuery);
		request.setAttribute("searchTerm", searchKeywordQuery);


        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}