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
        name = "editUsers",
        urlPatterns = {"/editUsers"}
)
public class AdminEditUsers extends HttpServlet {

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
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        logger.info("role to be updated to:" + role);

        // get user by Id
        GenericDao userDao = new GenericDao(User.class);
        User userToUpdate = (User)userDao.getById(id);

        // update user info
        userToUpdate.setPassword(password);
        userDao.saveOrUpdate(userToUpdate);

        // update role
        GenericDao roleDao = new GenericDao(Role.class);
        List<Role> roles = (List)roleDao.getByPropertyEqual("username", userToUpdate.getUsername());
        for (Role roleToUpdate: roles) {
            roleToUpdate.setName(role);
            roleDao.saveOrUpdate(roleToUpdate);

            logger.info("did the role update? " + roleToUpdate.getName());
        }




        request.setAttribute("searchPage", "userEdit");
        request.setAttribute("anchorName", "signup");

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}
