<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="container-fluid" style="padding: 0">
	<div class="row-fluid">
		<div class="span2">
			<!--Sidebar content-->
			<ul class="nav nav-list">
				<li class="nav-header">Administrative</li>
				<li class="active"><a href="/cs490/admin/system/vendors">Manage
						vendors</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<div>

				<legend>Vendors</legend>

				<table class="table table-bordered">
					<tr>
						<th>Vendor Name</th>
						<th>Street</th>
						<th>City</th>
						<th>State</th>
						<th>status</th>
					</tr>
					<c:forEach var="vendor" items="${vendors}">

						<tr>
							<td>${vendor.vendorName}</td>
							<td>${vendor.address.street}</td>
							<td>${vendor.address.city}</td>
							<td>${vendor.address.state}</td>
							<td>${vendor.status}</td>
							<td>
								<button onclick="location.href = 'disable?vid=${vendor.userId}';"
									id="disable" class="btn btn-mini btn-danger">Disable</button>
								<button onclick="location.href = 'activate?vid=${vendor.userId}';"
									id="activate" class="btn btn-mini btn-success">Activate</button>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>



