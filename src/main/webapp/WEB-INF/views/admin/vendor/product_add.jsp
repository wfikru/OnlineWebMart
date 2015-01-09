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
				<li class="active"><a href="#">Manage my product</a></li>
				<li class="nav-header">Reports</li>
				<li><a href="/cs490/admin/vendor/product">Generate reports</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<table>
				<tr>
					<td><h3>Add New Product</h3></td>
					<td></td>
				</tr>
			</table>
			<div>
				<springForm:form modelAttribute="product" class="form-horizontal"
					action="doAdd" enctype="multipart/form-data">

					<fieldset>
						<legend>Product details</legend>
						<table class="mytbl">
							<tr>
								<td style="width: 130px">Product Name:</td>
								<td><springForm:input id="name" path="name" type="text" /></td>
								<td><springForm:errors path="name" cssClass="alert alert-danger" /></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><springForm:textarea id="description" path="description"
										type="text" /></td>
								<td><springForm:errors path="description" cssClass="alert alert-danger" /></td>
							</tr>
							<tr>
								<td>Price:</td>
								<td><springForm:input id="price" path="price" type="text" /></td>
								<td><springForm:errors path="price" cssClass="alert alert-danger" /></td>
							</tr>
							<tr>
								<td>Quantity:</td>
								<td><springForm:input id="quantity" path="quantity" type="text" /></td>
								<td><springForm:errors path="quantity" cssClass="alert alert-danger" /></td>
							</tr>
							
							<tr>
								<td>Category:</td>
								<td><form:select multiple="single" path="category.id"
										id="category.id" cssClass="dropDownSelect-small" tabindex="3"
										onchange="changeState()">
										<form:options items="${categories}" itemValue="id"
											itemLabel="name" />
									</form:select></td>
							</tr>
							<tr>
								<td>Image:</td>
								<td><springForm:input id="productImage" path="productImage"
										type="file" /></td>
								<td><springForm:errors path="productImage" cssClass="alert alert-danger" /></td>
							</tr>
						</table>
					</fieldset>
					<div class="form-group" style="padding-top: 20px;">
						<div style="display: inline-block; padding-right: 10px;">
							<input type="submit" id="btnAdd" class="btn btn-primary"
								value="Register" />
						</div>
					</div>
				</springForm:form>

			</div>
		</div>
	</div>
</div>




