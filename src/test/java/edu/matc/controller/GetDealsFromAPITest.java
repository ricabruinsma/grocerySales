package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import grocery.api.deals.Deal;
import grocery.api.deals.DealList;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Test for the GetDealsFromAPI controller *
 */
@SuppressWarnings("unchecked")
public class GetDealsFromAPITest {


    /**
     * Confirm objects are built from api response test.
     *
     * @throws IOException the io exception
     */
    @Test
    void confirmObjectsBuiltFromAPIResponseTest() throws IOException {
        String uri = "http://18.222.154.101:8080/groceryDeals/api/deals/willystreet";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(uri);
        String responseJSON = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //API sometimes needs to be hit several times, to give a non-empty list
        if (responseJSON.equals("[]")) {
            responseJSON = target.request(MediaType.APPLICATION_JSON).get(String.class);
            if (responseJSON.equals("[]")) {
                responseJSON = target.request(MediaType.APPLICATION_JSON).get(String.class);
                if (responseJSON.equals("[]")) {
                    responseJSON = target.request(MediaType.APPLICATION_JSON).get(String.class);
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

        assertNotNull(deals);
    }

}
