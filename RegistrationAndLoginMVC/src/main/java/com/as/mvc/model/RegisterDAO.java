package com.as.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.as.mvc.util.*;

public class RegisterDAO {
	
	public String registerUser(UserInformation userInfo){
		
		Connection connection = null;
		
		String firstName = userInfo.getFirstName();
		String lastName = userInfo.getLastName();
		String userName = userInfo.getUserName();
		String password = userInfo.getPassword();
		
		userNameValidation userValidation = new userNameValidation();
		
		try {
			if (userValidation.validate(userName) == false) {
			
				try {
					connection = DatabaseConnection.createConnection();
					if (connection != null ) {
						
						PreparedStatement preparedStatement = connection.prepareStatement("insert into `user`(firstname,lastname,username,password) values(?,?,?,?)");
						preparedStatement.setString(1,firstName);
						preparedStatement.setString(2,lastName);
						preparedStatement.setString(3,userName);
						preparedStatement.setString(4,password);
						
						int excuteUpdate = preparedStatement.executeUpdate();
						if (excuteUpdate != 0) {
							return "User Registered Successfully!";
						}
					}
				} catch (SQLException e) {
				e.printStackTrace();
				} finally {	
					try {
						connection.close();
					} 	catch (SQLException e) {
					e.printStackTrace();
					}
				}
			} else {
				return "Username already exists!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Registration Unsuccessful!";
	}
}

