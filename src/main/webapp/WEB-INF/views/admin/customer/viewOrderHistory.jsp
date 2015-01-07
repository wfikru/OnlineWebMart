<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="span9">
	<table class="table table-bordered" value="${orders}" var="order">
		<thead>
			<th>Date</th>
			<th>Purchased Products</th>
			<th>Amount Paid</th>

		</thead>


		<tbody>
			<tr>${order.date }</tr>
			<tr>
			<c:forEach items="${order.products}" var="product" varStatus="loopCounter">

			<li class="span3">${product.name }
			</li></c:forEach>
			</tr>
		</tbody>
	</table>
</div>
