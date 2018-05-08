package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Store;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A servlet to get the list of stores ready
 * for consumption by jQuery - to populate a select dropdown
 * @author rbruinsma
 */

@WebServlet(
		name = "loadingStores",
        urlPatterns = {"/loadingStores"}
)

public class LoadingStoresToDealSearch extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.info("I'm in the LoadingStores doGet");
    	//String anchorName = "";

        //logger.info("anchor name: " + anchorName);

        //grab all the stores from DB
        GenericDao storeDao = new GenericDao(Store.class);
        List<Store> stores = storeDao.getAll();

        // create a Map of the stores
        Map<String, String> options = new LinkedHashMap<>();
        options.put("", "choose");
        for (Store store : stores) {
            String storeName = store.getName();
            options.put(storeName, storeName);
        }

        // convert map to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonOptions = mapper.writeValueAsString(options);
        logger.info(jsonOptions);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonOptions);
        //request.setAttribute("anchorName", anchorName);

        //RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        //dispatcher.forward(request, response);
    }
}