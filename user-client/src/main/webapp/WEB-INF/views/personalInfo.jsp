<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Personal Information</title>
	</head>
	<body>
		<h1>Enter Personal Information</h1>
		<form action="personalinfo" method="post">
			First Name:	<input type="text" name="firstName" required><br><br>
			Last Name: <input type="text" name="lastName" required><br><br>
			Middle Name: <input type="text" name="middleName" required><br><br>
			Gender: <input type="checkbox" value="male" name="gender"> Male <input type="checkbox" value="female" name="gender"> Female <br><br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>