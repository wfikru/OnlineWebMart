<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="span12">
	<div class="">
		<div class="">
			<legend>Credit Card Problem</legend>

		 <%!String errorMessage = null;%>
			<%
				String result = (String) request.getSession()
						.getAttribute("result");
				if (result.equals("n")) {
					errorMessage = "Not sufficient amount in your account";
				} else if (result.equals("N")) {
					errorMessage = "Invalid Credit card number. Please fill out correctly";
				}
			%> 
			<h4>Invalid Credit card number. Please fill out correctly</h4>

			<div class=" spacer">
				<a href="payment" class="btn btn-warning">Back</a>
			</div>
		</div>
	</div>
</div>