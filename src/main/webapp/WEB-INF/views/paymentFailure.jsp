<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="span5">
			<legend>Error</legend>


			<%
				String errorMessage = null;
				String result = (String) request.getSession()
						.getAttribute("result");
				if (result.equals("n")) {
					errorMessage = "Not sufficient amount in your account";
				} else if (result.equals("N")) {
					errorMessage = "Invalid Credit card number. Please fill out correctly";
				}
			%>
			<h4><%=errorMessage%></h4>

			<div class=" spacer">
				<a href="payment" class="btn pull-right ">Back</a>
			</div>
		</div>
	</div>
</div>