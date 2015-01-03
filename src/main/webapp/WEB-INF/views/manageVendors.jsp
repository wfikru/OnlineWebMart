<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="container">

	<legend>Vendors</legend>

	<table class="table table-bordered">
		<tr>
			<th>Vendor Name</th>
			<th>Logo</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="vendor" items="${ vendors}">

			<tr>
				<td><c:out value="${vendor.vendorName}" /></td>
				<td><img alt="logo" src="${vendor.filePath }" width="50px"></td>
				<td><a>Edit</a></td>
				<td><a>Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</div>