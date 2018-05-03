package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Role;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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
        String uri = "";

        //from GET request
        String searchType = request.getParameter("searchType");

        if (searchType.equals("keywordSearch")) {
            String keywordSearch = request.getParameter("keyword");
            uri = "18.222.154.101:8080/grocery/api/deals/search/" + keywordSearch;
        } else if (searchType.equals("getAll")) {
            uri = "18.222.154.101:8080/grocery/api/deals/willystreet";
        }


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(uri);
        String responseJSON = target.request(MediaType.APPLICATION_JSON).get(String.class);
        //String configResponseJSON = "{\"responseList\": " + responseJSON + "}";
        ObjectMapper mapper = new ObjectMapper();
        //ResponseList results = mapper.readValue(configResponseJSON, ResponseList.class);
        //List<Deal> deals = new ArrayList<Deal>();
        //for (Response deal : results.getResponseList()) {
        //  deals.add(deal);
        // }
        //request.setAttribute("deals", deals);


        // request.setAttribute("searchPage", "shopper");
        request.setAttribute("searchPage", "index");
        request.setAttribute("anchorName", "dealSearch");

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
