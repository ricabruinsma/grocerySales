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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A servlet to search the User database.
 * @author rbruinsma
 */

@WebServlet(
		name = "searchUsers",
        urlPatterns = {"/searchUsers"}
)

public class AdminSearchUsers extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * When re-loading the page after a delete, need to shuttle doPost request into the doGet
	 *
	 * @param request Http Servlet Request
	 * @param response Http Servlet Response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    /**
     * @param request Http Servlet Request
     * @param response Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //from GET request

		String searchKeywordQueryString = null;
        //field to search by
        String searchByQuery = request.getParameter("searchBy");
        //term to look for in field above
		if (searchByQuery.equals("all")) {
			searchKeywordQueryString = null;
		} else {
			searchKeywordQueryString = request.getParameter("searchTerm");
		}

		String searchPage = request.getParameter("searchPage");

        logger.info(searchByQuery);
        logger.info(searchKeywordQueryString);

		GenericDao userDao = new GenericDao(User.class);

		switch (searchByQuery) {
								// role query needs to go through role DB first
			case "role": 		GenericDao roleDao = new GenericDao(Role.class);
								List<Role> roleList = roleDao.getByPropertyLike("name", searchKeywordQueryString);

								// from role objects, make a list of users
								Set<User> userList = new HashSet<>();
								for (Role role : roleList) {
									userList.add(role.getUser());
								}
								request.setAttribute("users", userList);
								break;

								// id query goes through User DB, but needs to be cast to int
			case "id":			User retrievedUser = (User)userDao.getById(Integer.parseInt(searchKeywordQueryString));
								Set<User> userListOfOne = new HashSet<>();
								userListOfOne.add(retrievedUser);
								request.setAttribute("users", userListOfOne);
								break;

			case "username":	List<User> userListByUsername = userDao.getByPropertyLike("username", searchKeywordQueryString);
								request.setAttribute("users", userListByUsername);
								break;
			case "all":			List<User> allUsers = userDao.getAll();
								request.setAttribute("users", allUsers);

		}


		request.setAttribute("searchPage", searchPage);
		request.setAttribute("anchorName", "#searchUsersResults");
		request.setAttribute("searchBy", searchByQuery);
		request.setAttribute("searchTerm", searchKeywordQueryString);

        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}