
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">


	<form:form modelAttribute="customer" class="form-horizontal"
		action="customer/add">

		<legend>Add new customer</legend>

		<!-- <form:errors path="*" cssClass="alert alert-danger" element="div"/> -->

		<div class="form-group">
			<label class="control-label col-lg-2" for="firstName">First
				Name</label>
			<div class="col-lg-10">
				<form:input id="firstName" path="firstName" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="lastName">Last
				Name</label>
			<div class="col-lg-10">
				<form:input id="lastName" path="lastName" type="text"
					class="form:input-large" />

			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-lg-2" for="address.state">State
			</label>
			<div class="col-lg-10">
				<form:input id="address.state" path="address.state" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="address.street">Street
			</label>
			<div class="col-lg-10">
				<form:input id="address.street" path="address.street" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="address.zip">ZIP </label>
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
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
			</div>
		</div>


	</form:form>

	<a href="vendor" class="btn btn-primary">Vendor Registration</a> 
</div>
