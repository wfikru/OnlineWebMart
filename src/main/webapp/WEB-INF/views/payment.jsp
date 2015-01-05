<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span5">

				<form:form modelAttribute="creditCard" class="form-horizontal"
					action="payment/validate">
					<fieldset>
						<legend>Payment</legend>

						<div class="control-group">
							<label class="control-label">Card Holder's Name</label>
							<div class="controls">
								<form:input id="cardholderName" type="text"
									class="input-block-level" pattern="\w+ \w+.*"
									title="Fill your first and last name" path="cardholderName" />
							</div>
						</div>


						<div class="control-group">
							<label class="control-label">Card Number</label>
							<div class="controls">
								<div class="row-fluid">
									<div class="span3">
										<form:input id="cardno.first" path="first" type="text"
											class="input-block-level" autocomplete="off" maxlength="4"
											pattern="\d{4}" title="First four digits" />
									</div>
									<div class="span3">
										<form:input id="cardno.second" path="second" type="text"
											class="input-block-level" autocomplete="off" maxlength="4"
											pattern="\d{4}" title="Second four digits" />
									</div>
									<div class="span3">
										<form:input id="cardno.third" path="third" type="text"
											class="input-block-level" autocomplete="off" maxlength="4"
											pattern="\d{4}" title="Third four digits" />
									</div>
									<div class="span3">
										<form:input id="cardno.fourth" path="fourth" type="text"
											class="input-block-level" autocomplete="off" maxlength="4"
											pattern="\d{4}" title="Fourth four digits" />
									</div>
								</div>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Card Expiry Date</label>
							<div class="controls">
								<div class="row-fluid">
									<div class="span8">
										<form:select id="month" path="month"
											class="input-block-level">
											<form:option value="">January</form:option>

											<form:option value="">December</form:option>
										</form:select>
									</div>
									<div class="span4">
										<form:select id="year" path="year"
											class="input-block-level">
											<c:forEach begin="2000" end="2015" var="i">

												<form:option value="">
													<c:out value="${i}" />
												</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Card CVV</label>
							<div class="controls">
								<div class="row-fluid">
									<div class="span3">
										<form:input id="SecurityCode" path="SecurityCode" type="text"
											class="input-block-level" autocomplete="off" maxlength="3"
											pattern="\d{3}" title="Three digits at back of your card" />
									</div>
									<div class="span8">
										<!-- screenshot may be here -->
									</div>
								</div>
							</div>
						</div>

						<div calss="control-group">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>