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
				<li><a href="/cs490/admin/system/vendors">Manage vendors</a></li>
				<li class="active"><a href="#">Manage category</a></li>
				<li><a href="/cs490/admin/system/viewHistory">Generate
						report</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<table>
				<tr>
					<td><h3>Add New Category</h3></td>
					<td></td>
				</tr>
			</table>
			<div>
				<springForm:form modelAttribute="category" class="form-horizontal"
					action="doAdd" enctype="multipart/form-data">
					<springForm:errors path="*" cssClass="alert alert-danger"
						element="div" />
					<fieldset>
						<legend>Category details</legend>
						<table class="mytbl">
							<tr>
								<td style="width: 130px">Category Name:</td>
								<td><springForm:input id="name" path="name" type="text" /></td>
								<td><springForm:errors path="name" cssClass="error" /></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><springForm:textarea id="description"
										path="description" type="text" /></td>
								<td><springForm:errors path="description" cssClass="error" /></td>
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




