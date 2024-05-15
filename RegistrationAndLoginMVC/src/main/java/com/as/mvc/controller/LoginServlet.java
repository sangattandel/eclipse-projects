package com.as.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.as.mvc.model.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserInformation userInfo = new UserInformation();
		
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		
		LoginDAO loginDAO = new LoginDAO();
		
		try {
			String validateCredentials = loginDAO.userAuthentication(userInfo);
			
			if(validateCredentials.equals("Authentication Successful!")) {
				
				FetchDataDAO fetchDAO = new FetchDataDAO();
				ArrayList<OrderData> fetchedData = fetchDAO.fetchData();
				HttpSession session = request.getSession();
				if (fetchedData != null) {
					session.setAttribute("username", userName);
					request.getSession().setAttribute("data" , fetchedData);
					request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/homePage.jsp").forward(request, response);
				}
				
			} else {
				request.setAttribute("error", validateCredentials);
				request.getRequestDispatcher("/loginPage.jsp").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
