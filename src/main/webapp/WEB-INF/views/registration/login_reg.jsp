<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>


<div class="container">
	<h2>Login / register</h2>
</div>
<div class="container-fluid" style="padding: 0">
	<div class="row-fluid">
		<div class="span5" style="padding-right: 10px;">
			<!--Sidebar content-->

			<div>
				<!--Login-->
				<div class="col-lg-5 col-md-5 col-sm-5">
					<form:form action="/cs490/registration/login" method="POST"
						modelAttribute="user" class="login-form" novalidate="novalidate">
						
						<c:if test="${ login_error }">
							<label class="error" style="font-weight: bold; color:red">User name or password are incorrect</label>
						</c:if>
						<div class="form-group "
							style="padding-top: 10px; padding-bottom: 10px;">
							<label for="log-email2" style="font-weight: bold;">Email</label>
							<form:input  class="form-control" type="text" id="inputEmail" path="email"
									placeholder="Enter your email" required=""
								style="width: 100%"/>
							
						</div>
						<div class="form-group group"
							style="padding-top: 10px; padding-bottom: 10px;">
							<label for="log-password2" style="font-weight: bold;">Password</label>
							<form:input type="password" class="form-control" id="inputPassword" path="password"
									placeholder="Enter your password" required=""
								style="width: 100%" />
						</div>
						<input class="btn btn-primary" type="submit" value="Login">
					</form:form>
				</div>

			</div>
		</div>
		<div class="span5"
			style="border-left: 1px solid #033833; padding-left: 30px;">
			<div class="col-lg-7 col-md-7 col-sm-7" style="">
				<springForm:form action="/cs490/registration/register" method="POST"
						modelAttribute="reg_user" class="login-form" novalidate="novalidate">
					<div class="form-group group"
						style="padding-top: 10px; padding-bottom: 10px;">
						<label for="rf-email" style="font-weight: bold;">Email</label> 
						<form:input  class="form-control" type="text" id="inputEmail2" path="email"
									placeholder="Enter email" required=""
								style="width: 100%"/>
						<form:errors path="email" cssClass="alert alert-danger" />
					</div>
					<div class="form-group group"
						style="padding-top: 10px; padding-bottom: 10px;">
						<label for="rf-password" style="font-weight: bold;">Password</label>
						<form:input  class="form-control" type="password" path="password"
									placeholder="Enter password" required=""
								style="width: 100%"/>
						<form:errors path="password" cssClass="alert alert-danger" />
					</div>
					<div class="form-group group"
						style="padding-top: 10px; padding-bottom: 10px;">
						<label for="rf-password-repeat" style="font-weight: bold;">Repeat
							password</label> 
						<form:input  class="form-control" type="password" path="confirmPassword"
									placeholder="Repeat password" required=""
								style="width: 100%"/>
						<form:errors path="confirmPassword" cssClass="alert alert-danger" />
					</div>
					<fieldset>
						<legend>Registration Type</legend>
						<div>
							<label class="radio-inline"> <input type="radio"
								name="role" value="customer" id=male /> I want to register as a
								customer
							</label> <label class="radio-inline"> <input type="radio"
								name="role" value="V" id=female /> I want to register as a
								vendor
							</label> <br />
						</div>
					</fieldset>

					<input class="btn btn-primary" type="submit" value="Register" />

				</springForm:form>
			</div>
		</div>
	</div>
</div>
