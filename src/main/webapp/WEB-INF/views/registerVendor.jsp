<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="container">
	<form:form modelAttribute="vendor" class="form-horizontal"
		enctype="multipart/form-data" action="vendor/add">

		<legend>Add new customer</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="address">First
				Name</label>
			<div class="col-lg-10">
				<form:input id="address" path="address" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">Last
				Name</label>
			<div class="col-lg-10">
				<form:input id="name" path="name" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Register" />
			</div>
		</div>

	</form:form>

</div>