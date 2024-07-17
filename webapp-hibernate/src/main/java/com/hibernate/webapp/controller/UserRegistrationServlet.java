package com.hibernate.webapp.controller;

import java.io.IOException;


import com.hibernate.webapp.dao.UserDAO;
import com.hibernate.webapp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public UserRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("registrationForm.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
	    User user = new User(firstName, lastName, userName, password);
	    UserDAO userDAO = new UserDAO();
	    userDAO.addUser(user);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("registrationSuccess.jsp");
	    rd.forward(request, response);
	}

}
