<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.as.mvc.model.OrderData" %>
<%@page import="java.util.Iterator" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Successful</title>
	</head>
	<body>
		<h1>
			Welcome ${username}, this is the list of prominent gaming consoles released till date!
		</h1>
		
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Item</td>
				<td>Price</td>
				<td>Release Date</td>
			</tr>
			
			<%
				ArrayList<OrderData> data = (ArrayList<OrderData>) session.getAttribute("data");
				if (data != null) {
					for (OrderData i : data) {
				
			%>
				<tr>
					<td><%=i.getId() %></td>
					<td><%=i.getItem() %></td>
					<td><%=i.getPrice() %></td>
					<td><%=i.getDate() %></td>
				</tr>
				<% } 
				} 
			%>		 
		</table>
	</body>
</html>