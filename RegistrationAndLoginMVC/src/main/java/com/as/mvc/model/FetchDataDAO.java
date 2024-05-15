package com.as.mvc.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.as.mvc.util.*;

public class FetchDataDAO {
	
	public ArrayList<OrderData> fetchData() throws SQLException {
		
		ArrayList<OrderData> data = new ArrayList<OrderData>();
		Connection connection = null;
		
		try {
			connection = DatabaseConnection.createConnection();
			if (connection != null) {
				PreparedStatement ps = connection.prepareStatement("select * from `order`");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					OrderData orderData = new OrderData();
					orderData.setId(rs.getString("ID"));
					orderData.setItem(rs.getString("Item"));
					orderData.setPrice(rs.getString("Price"));
					orderData.setDate(rs.getString("manufDate"));
					data.add(orderData);
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return data;
	}
}
