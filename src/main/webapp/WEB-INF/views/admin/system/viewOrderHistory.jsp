<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="container-fluid" style="padding: 0">
	<div class="row-fluid">
		<div class="span2">
			<!--Sidebar content-->
			<ul class="nav nav-list">
				<li class="nav-header">Administrative</li>

				<li><a href="/cs490/admin/system/vendors">Manage
						vendors</a></li>

				<li><a href="/cs490/admin/vendor/category">Manage category</a></li>

				<li class="active"><a href="/cs490/admin/system/viewHistory">Generate
						report</a></li>

			</ul>
		</div>
		<div class="span10">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Order Number</th>
						<th>Purchase Date</th>
						<th>Purchased Products</th>
						<th>Total Amount Paid</th>
						<th>Profit</th>
					</tr>
				</thead>


				<tbody>
					<c:forEach items="${orders}" var="order">

						<tr>
							<td>#${order.id }</td>

							<td>${order.date }</td>
							<td>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Product</th>
											<th>Price</th>
											<th>Quantity</th>
										</tr>
									</thead>
									<c:forEach items="${order.items}" var="item">
										<tr>
											<td><img style="width: 100px; height: 100px;"
												src="/cs490/admin/vendor/product/pic?pid=${item.product.id}" />
												${item.product.name}</td>
											<td>$ ${item.product.price}</td>
											<td>${item.quantity}</td>
										</tr>
									</c:forEach>
								</table>
							</td>
							<td>${order.total }</td>
							<td><b>${order.profit_for_mycompany }</b></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>