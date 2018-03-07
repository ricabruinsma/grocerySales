package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    /**
     * @param req Http Servlet Request
     * @param resp Http Servlet Response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get search information from GET request
        //String lastNameQuery = req.getParameter("lastName");

        //UserData userData = new UserData();
        GenericDao userDao = new GenericDao(User.class);
        //req.setAttribute("users", userData.getUserByLastName(lastNameQuery));

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", userDao.getByPropertyLike("lastName", req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}