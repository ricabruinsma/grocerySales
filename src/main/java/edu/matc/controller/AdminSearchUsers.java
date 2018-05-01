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
import java.util.List;

/**
 * A servlet to search the User database.
 * @author rbruinsma
 */

@WebServlet(
        urlPatterns = {"/searchUsers"}
)

public class AdminSearchUsers extends HttpServlet {

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

		//String searchTypeQuery = request.getParameter("searchType");
        //field to search by
        String searchByQuery = request.getParameter("searchBy");
        //term to look for in field above
        String searchKeywordQuery = request.getParameter("searchTerm");

        logger.info(searchByQuery);
        logger.info(searchKeywordQuery);

		GenericDao userDao = new GenericDao(User.class);
		
		// role query needs to go through role DB first
		if (searchByQuery.equals("role")) {
			GenericDao roleDao = new GenericDao(Role.class);
			List<Role> roleList = roleDao.getByPropertyLike("name", searchKeywordQuery);
			// from role objects, make a list of users
			List<User> userList = new ArrayList<>();
			for (Role role : roleList) {
				userList.add(role.getUser());
			}
			request.setAttribute("users", userList);
			
		// all other queries go through user DB
		} else {
			request.setAttribute("users", userDao.getByPropertyLike(searchByQuery, searchKeywordQuery));
		}
		request.setAttribute("searchPage", "user");


        RequestDispatcher dispatcher = request.getRequestDispatcher("adminPage.jsp");
        dispatcher.forward(request, response);
    }
}