<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Registration Form</title>
	</head>
	<body>
		<form action="register" method="post">
			First Name: <input type="text" name="firstname" required>
			Last Name: <input type="text" name="lastname" required>
			UserName: <input type="text" name="username" required>
			Password: <input type="password" name="password" required>
			<input type="submit" value="Sign Up">
		</form>
	</body>
</html>