<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<section class="log-reg container">
	<h2>Login/ register</h2>
	<div class="row">
		<!--Login-->
		<div class="col-lg-5 col-md-5 col-sm-5">
			<form method="post" class="login-form" novalidate="novalidate">
				<div class="form-group group">
					<label for="log-email2">Email</label> <input type="email"
						class="form-control" name="log-email2" id="log-email2"
						placeholder="Enter your email" required=""> <a
						class="help-link"
						href="http://the8guild.com/themes/html/limo/v1.1/register.html#">Forgot
						email?</a>
				</div>
				<div class="form-group group">
					<label for="log-password2">Password</label> <input type="text"
						class="form-control" name="log-password2" id="log-password2"
						placeholder="Enter your password" required=""> <a
						class="help-link"
						href="http://the8guild.com/themes/html/limo/v1.1/register.html#">Forgot
						password?</a>
				</div>
				<div class="checkbox">
					<label><div class="icheckbox" style="position: relative;">
							<input type="checkbox" name="remember"
								style="position: absolute; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
						</div> Remember me</label>
				</div>
				<input class="btn btn-black" type="submit" value="Login">
			</form>
		</div>
		<!--Registration-->
		<div class="col-lg-7 col-md-7 col-sm-7">
			<form method="post" class="registr-form" novalidate="novalidate">
				<div class="form-group group">
					<label for="rf-email">Email</label> <input type="email"
						class="form-control" name="rf-email" id="rf-email"
						placeholder="Enter email" required="">
				</div>
				<div class="form-group group">
					<label for="rf-password">Password</label> <input type="password"
						class="form-control" name="rf-password" id="rf-password"
						placeholder="Enter password" required="">
				</div>
				<div class="form-group group">
					<label for="rf-password-repeat">Repeat password</label> <input
						type="password" class="form-control" name="rf-password-repeat"
						id="rf-password-repeat" placeholder="Repeat password" required="">
				</div>
				<div class="checkbox">
					<label class=""><div class="icheckbox"
							style="position: relative;">
							<input type="checkbox" name="remember"
								style="position: absolute; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
						</div> I have read and agree with the terms</label>
				</div>
				<input class="btn btn-black" type="submit" value="Register">
			</form>
		</div>
	</div>
</section>
