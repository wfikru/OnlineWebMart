<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid" style="padding: 0">
	<div class="row-fluid">
		<div class="span2">
			<!--Sidebar content-->
			<ul class="nav nav-list">
				<li class="nav-header">Administrative</li>
				<li class="active"><a href="#">Manage my product</a></li>
				<li class="nav-header">Reports</li>
				<li><a href="/cs490/admin/vendor/report">Generate reports</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<div>
				<table>
					<tr>
						<td><h3>Product List</h3></td>
						<td>
							<div style="padding-left: 20px; padding-top: 10px;">
								<form action="/cs490/admin/vendor/product/add">
									<input type="submit" id="btnAdd"
										class="btn btn-mini btn-success" value="Add Product" />
								</form>
							</div>
						</td>
					</tr>
				</table>
				<table id="example" class="table table-hove" cellspacing="0"
					width="75%">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Category</th>
							<th>Action</th>
						</tr>
					</thead>


					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td><img src="/cs490/admin/vendor/product/pic?pid=${product.id}"
									style="width: 100px; height: 100px" /></td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.price}</td>
								<td>${product.quantity}</td>
								<td>${product.category.name}</td>
								<td>
									<button
										onclick="location.href = '/cs490/admin/vendor/product/edit?pid=${product.id}';"
										id="btnEdit" class="btn btn-mini">Edit</button>
									<button
										onclick="location.href = '/cs490/admin/vendor/product/delete?pid=${product.id}';"
										id="btnDelete" class="btn btn-mini btn-danger">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>


