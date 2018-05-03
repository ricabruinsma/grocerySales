package edu.matc.controller;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.net.www.content.text.Generic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to delete a User from the database.
 * @author rbruinsma
 */

@WebServlet(
		name = "deleteUser",
        urlPatterns = {"/deleteUser"}
)

public class AdminDeleteUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //from GET request
		int userIdToDelete = Integer.parseInt(request.getParameter("id"));
		logger.info("userId: " + userIdToDelete);
		
        //grab user to delete
		GenericDao userDao = new GenericDao(User.class);
		User userToDelete = (User)userDao.getById(userIdToDelete);

		//find user's roles by username
		GenericDao roleDao = new GenericDao(Role.class);
		List<Role> rolesToDelete = roleDao.getByPropertyEqual("username", userToDelete.getUsername());

		// delete roles first
		for (Role role : rolesToDelete) {
			roleDao.delete(role);
		}

		// then delete user
		userDao.delete(userToDelete);

		request.setAttribute("deletePage", "user");
		request.setAttribute("anchorName", "#deleteUsersResults");
		request.setAttribute("deleteMessage", "success");

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}