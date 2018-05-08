package edu.matc.controller;

import edu.matc.entity.ListLine;
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

/**
 * A servlet to sign up a new User
 * @author rbruinsma
 */

@WebServlet(
        name = "addAgainToList",
        urlPatterns = {"/addAgainToList"}
)
public class ShopperAddAgainToShoppingList extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //from POST request
        int listLineIdToUpdate  = Integer.parseInt(request.getParameter("listLineIdToUpdate"));
        int currentQuantity = Integer.parseInt(request.getParameter("currentQuantity"));

        // get listLine by Id
        GenericDao listLineDao = new GenericDao(ListLine.class);
        ListLine listLineToUpdate = (ListLine)listLineDao.getById(listLineIdToUpdate);

        // increment quantity
        int newQuantity = currentQuantity + 1;

        // update listline info
        listLineToUpdate.setQuantity(newQuantity);
        listLineDao.saveOrUpdate(listLineToUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("showShoppingList");
        dispatcher.forward(request, response);
    }
}
