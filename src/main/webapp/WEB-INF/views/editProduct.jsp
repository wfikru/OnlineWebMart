<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	
	<title>Edit Product</title>	
</head>
 
 <body class="skin-blue">
 	<div class="wrapper row-offcanvas row-offcanvas-left">
 		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Edit Product
				</h1>
				<ol class="breadcrumb">
					<li><a href="/cs490"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="/cs490/product/list">Products</a></li>
					<li class="active">Edit</li>
				</ol>
				
			</section>
			
			<section class="container">
			<br><br>

				<springForm:form method="POST" commandName="product" action="update?pid=${product.id}">
				
					<fieldset>
						<legend>Edit product</legend>
				
						
				
							<table>
							
							<tr>
								 <td>id:${product.id}</td>
							</tr>
							
					
							
			<tr>
				<td>name:</td>
				<td><springForm:input path="name" /></td>
				<td><springForm:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>description:</td>
				<td><springForm:input path="description" /></td>
				<td><springForm:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><springForm:input path="price" /></td>
				<td><springForm:errors path="price" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>category:</td>
				<td><springForm:input path="category.id" /></td>
				<td><springForm:errors path="category.id" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Save Product"></td>
			</tr>
		</table>
				
					
				
						
		
						

					</fieldset>
					</springForm:form>		    
			</section>
		</aside>
	</div>    

</body>
</html>
