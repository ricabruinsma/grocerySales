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

/**
 * A servlet to sign up a new User
 * @author rbruinsma
 */

@WebServlet(
        name = "userSignUp",
        urlPatterns = {"/userSignUp"}
)
public class UserSignUp extends HttpServlet {

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
        String email = request.getParameter("email");
        String password = request.getParameter("newPassword");
        String username = request.getParameter("userName");
        String address1 = request.getParameter("userAddress");
        String city = request.getParameter("userCity");
        String state = request.getParameter("userState");
        String postalCode = request.getParameter("userZip");
        User newUser = new User(email, password, username, address1, city, state, postalCode);

        String genericUserRole = "shopper";
        Role newRole = new Role(newUser, genericUserRole, username);
        newUser.addRole(newRole);


        GenericDao userDao = new GenericDao(User.class);
        int id = userDao.insert(newUser);


        request.setAttribute("searchPage", "signup");
        request.setAttribute("anchorName", "#signup");
        request.setAttribute("success", true);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
