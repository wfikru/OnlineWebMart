<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<legend>Registration Succesfull</legend>
	
	<form:form>
	First Name:	<p>${customer.firstName }</p>
	Last Name:	<p>${customer.lastName }</p>
	Email:	<p>${customer.email }</p>
	State:	<p>${customer.address.state }</p>
	Street:	<p>${customer.address.street }</p>
	ZIP:	<p>${customer.address.zip }</p>
	
		<a href="back" class="glyphicon glyphicon-home">Back to home</a>
		
	</form:form>
</body>
</html>