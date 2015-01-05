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
				<li><a href="/cs490/admin/vendor/category">Product Category</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<table>
				<tr>
					<td><h3>Edit Existing Product</h3></td>
					<td></td>
				</tr>
			</table>
			<div>
				<springForm:form method="POST" commandName="product"
					action="update?pid=${product.id}" enctype="multipart/form-data">
					<fieldset>
						<legend>Product details</legend>
						<table>
							<tr>
								<td style="width: 130px">Product Name:</td>
								<td><springForm:input path="name" /></td>
								<td><springForm:errors path="name" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><springForm:input path="description" /></td>
								<td><springForm:errors path="description" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Price:</td>
								<td><springForm:input path="price" /></td>
								<td><springForm:errors path="price" cssClass="error" /></td>
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
								<td><springForm:errors path="productImage" cssClass="error" /></td>
							</tr>

							<tr>
								<td colspan="3"><input type="submit"
									class="btn btn-primary" value="Save Product"></td>
							</tr>
						</table>
					</fieldset>
				</springForm:form>
			</div>
		</div>
	</div>
</div>




