<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="com.hibernate.user.model.PersonalInformation" %>
<%@page import="com.hibernate.user.model.ContactInformation" %>
<%@page import="com.hibernate.user.model.BankInformation" %>

<html>
<head>
		<meta charset="ISO-8859-1">
		<%@ page isELIgnored="false" %>
		<title>User Information</title>
	</head>
	<body>
		<h1>User Information:</h1>
		<h2>Personal Information:</h2>
			First Name: ${personalInfo.firstName} <br>
			Middle Name: ${personalInfo.middleName}<br>
			Last Name: ${personalInfo.lastName} <br>
			Gender: ${personalInfo.gender} <br>
		<h2>Contact Information:</h2>
			Address: ${contactInfo.address} <br>
			City: ${contactInfo.city} <br>
			State: ${contactInfo.state} <br>
			Country: ${contactInfo.country} <br>
			Phone: ${contactInfo.phone} <br>
		<h2>Bank Information:</h2>
			Bank Name: ${bankInfo.bankName} <br>
			Account #: ${bankInfo.accountNumber} <br>
			SSN: ${bankInfo.ssn} <br>
	</body>
</html>