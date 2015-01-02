<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section class="container">
		<form:form modelAttribute="customer" class="form-horizontal"
			enctype="multipart/form-data" action="customer/add">
			<fieldset>
				<legend>Add new customer</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text"
							class="form:input-large" />

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="address.email">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="address.email" path="address.email" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="password">First
						Name</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Register" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
