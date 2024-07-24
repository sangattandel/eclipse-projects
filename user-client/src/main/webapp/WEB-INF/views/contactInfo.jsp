<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Contact Information</title>
	</head>
	<body>
		<h1>Enter Contact Information</h1>
		<form action="contactinfo" method="post">
			Address: <input type="text" name="address" required>
			City: <input type="text" name="city" required>
			State: <input type="text" name="state" required>
			Country: <input type="text" name="country" required>
			Phone: <input type="text" name="phone" required>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>