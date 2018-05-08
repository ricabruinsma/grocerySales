package edu.matc.controller;

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
import java.io.IOException;
import java.util.List;

/**
 * A servlet to sign up a new User
 * @author rbruinsma
 */

@WebServlet(
        name = "editShopperInfo",
        urlPatterns = {"/editShopperInfo"}
)
public class ShopperEditUserInfo extends HttpServlet {

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
        int id  = Integer.parseInt(request.getParameter("id"));
        String newPassword = request.getParameter("newPassword");

        // get user by Id
        GenericDao userDao = new GenericDao(User.class);
        User userToUpdate = (User)userDao.getById(id);

        // update user info
        userToUpdate.setPassword(newPassword);
        userDao.saveOrUpdate(userToUpdate);

        //request.setAttribute("searchPage", "userEdit");
        //request.setAttribute("anchorName", "signup");

        RequestDispatcher dispatcher = request.getRequestDispatcher("shopperPage.jsp");
        dispatcher.forward(request, response);
    }
}
