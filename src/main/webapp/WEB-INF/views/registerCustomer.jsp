
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">


	<form:form modelAttribute="customer" class="form-horizontal">

		<legend>Add new customer</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="control-group">
			<label class="control-label col-lg-2" for="firstName">First
				Name</label>
			<div class="controls">
				<form:input id="firstName" path="firstName" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="control-group">
			<label class="control-label col-lg-2" for="lastName">Last
				Name</label>
			<div class="controls">
				<form:input id="lastName" path="lastName" type="text"
					class="form:input-large" />

			</div>
		</div>


		<div class="control-group">
			<label class="control-label col-lg-2" for="address.state">State
			</label>
			<div class="controls">
				<form:input id="address.state" path="address.state" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="control-group">
			<label class="control-label col-lg-2" for="address.street">Street
			</label>
			<div class="controls">
				<form:input id="address.street" path="address.street" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="control-group">
			<label class="control-label col-lg-2" for="address.zip">ZIP </label>
			<div class="controls">
				<form:input id="address.zip" path="address.zip" type="text"
					class="form:input-large" />

			</div>
		</div>
		<hr>
		<div class="control-group">
			<label class="control-label col-lg-2" for="email">Email </label>
			<div class="controls">
				<form:input id="email" path="email" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="control-group">
			<label class="control-label col-lg-2" for="password">Password
			</label>
			<div class="controls">
				<form:input id="password" path="password" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="control-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Register" />
			</div>
		</div>


	</form:form>

	<a href="<spring:url value="/vendor/add" />" class="btn btn-primary">Vendor
		Registration</a> <a href="vendors" class="btn btn-primary">Vendors</a>
</div>


