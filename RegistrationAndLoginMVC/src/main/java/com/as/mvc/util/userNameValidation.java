package com.as.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userNameValidation {
	
	public boolean validate(String userName) throws SQLException {
		
		Connection connection = null;
		
		try {
			connection = DatabaseConnection.createConnection();
			if (connection != null ) {
				PreparedStatement ps = connection.prepareStatement("select * from user where username =? ");
				ps.setString(1, userName);
				ResultSet rs = ps.executeQuery();
				
				boolean results = rs.next();
				
				if (results) {
					
					do {
						if (userName.equals(userName)) {
							return true;
						}
					} while (rs.next());
				} else {
					return false;
				}	
			}
		} finally {	
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
