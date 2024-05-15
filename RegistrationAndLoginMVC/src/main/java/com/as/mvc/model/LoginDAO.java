package com.as.mvc.model;

import com.as.mvc.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public String userAuthentication (UserInformation userInfo) throws SQLException {

		Connection connection = null;
		
		String userName = userInfo.getUserName();
		String password = userInfo.getPassword();
		
		String userNameDatabase = "";
		String passwordDatabase = "";
		
		try {
			connection = DatabaseConnection.createConnection();
			if (connection != null ) {
				PreparedStatement ps = connection.prepareStatement("select username, password from `user`");
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					userNameDatabase = rs.getString("username");
					passwordDatabase = rs.getString("password");
					
					if (userName.equals(userNameDatabase) && password.equals(passwordDatabase)) {
						return "Authentication Successful!";
					}
				}
			}
		} finally {	
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	}
		return "Invalid user credentials!";
  }
}
