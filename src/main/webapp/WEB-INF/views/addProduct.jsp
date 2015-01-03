<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title>
</head>
<body>
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
					<li class="active">Add</li>
				</ol>
				
			</section>
			
						<section class="container">
			<br><br>

	<springForm:form method="POST" commandName="product" action="addit">
		<table>
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
				<td>Add picture:</td>
				<td><springForm:input path="productImage" type="file"/></td>
				<td><springForm:errors path="productImage" cssClass="error" /></td>
			</tr>




			<tr>
				<td colspan="3"><input type="submit" value="Save Product"></td>
			</tr>
		</table>

	</springForm:form>
			</section>
		</aside>
	</div>    

</body>
</html>