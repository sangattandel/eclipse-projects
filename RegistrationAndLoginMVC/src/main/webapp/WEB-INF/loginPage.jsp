<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body>
		<span style="color: red;">${error}</span><br><br>
		<form action="login" method="post">
			UserName: <input type="text" name="username" required>
			Password: <input type="password" name="password" required> 
			<input type="submit" value="Log In">
		</form>
	</body>
</html>