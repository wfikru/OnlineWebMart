<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product list</title>
</head>
<body>
 		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Companies
				</h1>
				<ol class="breadcrumb">
					<li><a href="/cs490/"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">View Products</li>
				</ol>
				
			</section>
			<!-- Plug main content here -->
			<!-- ====================== -->
			    <section class="container">
			    <br><br>	
					<div class="row">
						<table id="example" class="table table-striped table-bordered" cellspacing="0" width="75%">
							<thead>
					            <tr>
					                <th>Name</th>
					                <th>Desription</th>
					                <th>Price</th>
					                <th>Category</th>
					                <th></th>
					            </tr>
			        		</thead>
			        		
			        		
			        		<tbody>
				        		<c:forEach items="${products}" var = "product">
				            	<tr>
					                <td>${product.name}</td>
					                <td>${product.description}</td>
					                <td>${product.price}</td>
					                <td>${product.category.id}</td>
					                
					                <td>
					                <a href="edit?pid=${product.id}">Edit</a>
					                <a href="delete?pid=${product.id}">Delete</a></td>
				            	</tr>
				            	</c:forEach>
			        		</tbody>
			        		
						</table>
					</div>
					<form action="/cs490/product/add">
						<div class="form-group">
							<div class="pull-right">
								<input type="submit" id="btnAdd" class="btn btn-success" value="Add Product" />
							</div>
						</div>
					</form>
				</section>
			<!-- ====================== -->
			<!-- ====================== -->
			
		</aside>
	</div>
</body>        

</html>