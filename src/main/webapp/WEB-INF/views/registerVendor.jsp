<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="container">
	<form:form modelAttribute="vendor" class="form-horizontal"
		enctype="multipart/form-data">

		<legend>Add new vendor</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="vendorName">Company
				Name</label>
			<div class="col-lg-10">
				<form:input id="vendorName" path="vendorName" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="address.street">Street</label>
			<div class="col-lg-10">
				<form:input id="address.street" path="address.street" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">State</label>
			<div class="col-lg-10">
				<form:input id="address.state" path="address.state" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="address.zip">Zip</label>
			<div class="col-lg-10">
				<form:input id="address.zip" path="address.zip" type="text"
					class="form:input-large" />
			</div>
		</div>

		<hr>
		<div class="form-group">
			<label class="control-label col-lg-2" for="email">Email </label>
			<div class="col-lg-10">
				<form:input id="email" path="email" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="password">Password
			</label>
			<div class="col-lg-10">
				<form:input id="password" path="password" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="productImage"> Add
				Logo </label>
			<div class="col-lg-10">
				<form:input id="productImage" path="productImage" type="file"
					class="form:input-large" />
			</div>
		</div>

		<!-- <div class="form-group">
			<img
				src="<c:url value="/resource/images/aa.png"></c:url>"
				alt="image" style="width: 100%" />
		</div>  -->

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Register" />
			</div>
		</div>

	</form:form>

</div>