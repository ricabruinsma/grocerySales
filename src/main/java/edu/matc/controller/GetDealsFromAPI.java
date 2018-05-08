package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import grocery.api.deals.Deal;
import grocery.api.deals.DealList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A servlet to hit the groceryDeals API and return deals
 * @author rbruinsma
 */

@WebServlet(
        name = "getDeals",
        urlPatterns = {"/getDeals"}
)
public class GetDealsFromAPI extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // to hold uri
        String uri = null;

        //from GET request
        String storeName = request.getParameter("storeName");
        String categoryName = request.getParameter("categoryName");
        String pageToRouteTo = request.getParameter("routeDealsTo");

        String searchType = request.getParameter("searchType");

        if (searchType.equals("keywordSearch")) {
            String keywordSearch = request.getParameter("keyword");
            uri = "http://18.222.154.101:8080/groceryDeals/api/deals/search/" + keywordSearch;
        } else if (searchType.equals("getAll")) {
            uri = "http://18.222.154.101:8080/groceryDeals/api/deals/willystreet";
        }
        logger.info("This is the uri: " + uri);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(uri);
        String responseJSON = getAPIResponse(target);
        logger.info("response1: " + responseJSON);

        //API sometimes needs to be hit several times, to give a non-empty list
        if (responseJSON.equals("[]")) {
            responseJSON = getAPIResponse(target);
            logger.info("response2: " + responseJSON);
            if (responseJSON.equals("[]")) {
                responseJSON = getAPIResponse(target);
                logger.info("response3: " + responseJSON);
                if (responseJSON.equals("[]")) {
                    responseJSON = getAPIResponse(target);
                    logger.info("response4: " + responseJSON);
                }
            }
        }
        String configResponseJSON = "{\"dealList\": " + responseJSON + "}";
        ObjectMapper mapper = new ObjectMapper();
        DealList results = mapper.readValue(configResponseJSON, DealList.class);
        List<Deal> deals = new ArrayList<Deal>();
        for (Deal deal : results.getDealList()) {
          deals.add(deal);
        }
        request.setAttribute("deals", deals);


        //request.setAttribute("searchPage", "shopper");
        request.setAttribute("searchPage", "index");
        request.setAttribute("anchorName", "dealSearch");

        if (pageToRouteTo.equals("Shopper")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/toShopperPage");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected String getAPIResponse(WebTarget target) {
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
}
