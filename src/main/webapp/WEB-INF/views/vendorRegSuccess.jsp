<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<legend>Registration Succesfull</legend>

	<p>Company Name: ${vendor.vendorName }</p>
	<p>State: ${vendor.address.state }</p>
	<p>Street: ${vendor.address.street }</p>
	<p>ZIP: ${vendor.address.zip }</p>
	Logo: <img alt="" src="/src/main/resources/images/1.png" width="50px">

	<a href="home">Back to home</a>
</body>
</html>