<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<springForm:form method="POST" commandName="customer" action="customer/add">
		<table>
			<tr>
				<td>Name:</td>
				<td><springForm:input path="firstName" /></td>
				<td><springForm:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><springForm:input path="lastName" /></td>
				<td><springForm:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><springForm:input path="address" /></td>
				<td><springForm:errors path="address" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Save Customer"></td>
			</tr>
		</table>

	</springForm:form>


</body>
</html>