<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bank Information</title>
	</head>
	<body>
		<h1>Enter Bank Information</h1>
		<form action="bankinfo" method="post">
			Bank Name: <input type="text" name="bankName" required>
			Account #: <input type="text" name="accountNumber" required>
			SSN: <input type="text" name="ssn" required>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>