<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row">
		<div class="span5">
			<div class="col-md-12">

				<div class="alert alert-success">
					<strong><span class="glyphicon glyphicon-send"></span>
						Send us your questions. We will get back to you</strong>
				</div>
			</div>
			<form:form modelAttribute="contact" action="" method="post">
				<div class="col-lg-6">

					<div class="form-group">
						<label for="InputName">Your Name</label>
						<div class="input-group">
							<form:input path="username" type="text" class="form-control"
								id="InputName" placeholder="Enter Name" required />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputEmail">Your Email</label>
						<div class="input-group">
							<form:input path="email" class="form-control" id="InputEmail"
								placeholder="Enter Email" required />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label for="InputMessage">Message</label>
						<div class="input-group">
							<form:textarea path="message" id="InputMessage"
								class="form-control" rows="5" required style="width: 455px;" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<input type="submit" name="submit" id="submit" value="Submit"
						class="btn btn-info pull-right">
				</div>
			</form:form>

		</div>
	</div>
</div>