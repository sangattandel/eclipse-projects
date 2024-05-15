package com.as.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.as.mvc.model.*;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserInformation userInfo = new UserInformation();
		
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		
		RegisterDAO registerDAO = new RegisterDAO();
		
		String registerUser = registerDAO.registerUser(userInfo);
		
		if (registerUser.equals("User Registered Successfully!")) {
			request.getRequestDispatcher("/registrationSuccess.jsp").forward(request, response);
		} if (registerUser.equals("Username already exists!")) {
			request.setAttribute("error", registerUser);
			request.getRequestDispatcher("/userRegistration.jsp").include(request, response);
		} else {
			request.setAttribute("error", registerUser);
			request.getRequestDispatcher("/userRegistration.jsp").include(request, response);
		}
	}

}
