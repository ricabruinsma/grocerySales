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

        String message = null;

        //from POST request
        String email = request.getParameter("email");
        String password = request.getParameter("newPassword");
        String username = request.getParameter("userName");
        String address1 = request.getParameter("userAddress");
        String city = request.getParameter("userCity");
        String state = request.getParameter("userState");
        String postalCode = request.getParameter("userZip");
        User newUser = new User(email, password, username, address1, city, state, postalCode);
        logger.info(newUser);

        // check if username is already in use
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByPropertyEqual("username", username);
        //logger.info("how many users are there???" + users.size());
        if (users.size() == 0) {

            String genericUserRole = "shopper";
            Role newRole = new Role(newUser, genericUserRole, username);
            newUser.addRole(newRole);

            int id = userDao.insert(newUser);

            if (id > 0) {
                message = "success";
            } else {
                message = "failure";
            }
        } else {
            message = "duplicate";
        }

        request.setAttribute("searchPage", "signup");
        request.setAttribute("anchorName", "signup");
        request.setAttribute("signUp", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
