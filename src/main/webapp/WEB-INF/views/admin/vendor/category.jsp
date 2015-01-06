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
				<li><a href="/cs490/admin/vendor/product">Manage my product</a></li>
				<li class="active"><a href="#">Product Category</a></li>
				<li class="nav-header">Reports</li>
				<li><a href="/cs490/admin/vendor/report">Generate reports</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<div>
				<table>
					<tr>
						<td><h3>Category List</h3></td>
						<td>
							<div style="padding-left: 20px; padding-top: 10px;">
								<form action="/cs490/admin/vendor/category/add">
									<input type="submit" id="btnAdd"
										class="btn btn-mini btn-success" value="Add Category" />
								</form>
							</div>
						</td>
					</tr>
				</table>
				<table id="example" class="table table-hove" cellspacing="0"
					width="75%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Action</th>
						</tr>
					</thead>


					<tbody>
						<c:forEach items="${categories}" var="category">
							<tr>
								<td>${category.name}</td>
								<td>${category.description}</td>
								<td>
									<button onclick="location.href = '/cs490/admin/vendor/category/edit?pid=${category.id}';"
										id="btnEdit" class="btn btn-mini">Edit</button>
									<button onclick="location.href = '/cs490/admin/vendor/category/delete?pid=${category.id}';"
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


