<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="span12">
	<div >
		<div class="span5">

			<form:form modelAttribute="creditCard" class="form-horizontal"
				method="POST">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<legend>Shipping Address</legend>

				<div class="control-group">
					<label class="control-label">State</label>
					<div class="controls">
						<form:input id="state" type="text" class="input-block-level"
							title="Fill your first and last name" path="address.state" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">City</label>
					<div class="controls">
						<form:input id="city" type="text" class="input-block-level"
							title="Fill your first and last name" path="address.city" />
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">Street</label>
					<div class="controls">
						<form:input id="street" type="text" class="input-block-level"
							title="Fill your first and last name" path="address.street" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">ZIP</label>
					<div class="controls">
						<form:input id="zip" type="text" class="input-block-level"
							pattern="\d{5}" path="address.zip" />
					</div>
				</div>

				<legend>Payment Information</legend>

				<div class="control-group">
					<label class="control-label">Card Type</label>
					<div class="controls">
						<form:radiobutton path="cardType" value="visaCard" />
						<img src="/cs490/resources/themes/images/credit_card.png"
							width="60px" />

						<form:radiobutton path="cardType" value="masterCard" />
						<img src="/cs490/resources/themes/images/mastercard.png"
							width="60px" />
					</div>
				</div>

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
								<form:select id="month" path="month" class="input-block-level">
									<form:option value="1">January</form:option>
									<form:option value="2">February</form:option>
									<form:option value="3">March</form:option>
									<form:option value="4">April</form:option>
									<form:option value="5">May</form:option>
									<form:option value="6">June</form:option>
									<form:option value="7">July</form:option>
									<form:option value="8">August</form:option>
									<form:option value="9">September</form:option>
									<form:option value="10">October</form:option>
									<form:option value="11">November</form:option>
									<form:option value="12">December</form:option>
								</form:select>
							</div>
							<div class="span4">
								<form:select id="year" path="year" class="input-block-level">
									<c:forEach begin="2000" end="2015" var="i">

										<form:option value="${i}">
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
				<hr>
				<div class="span4 pull-right">
					<div class="control-group">
						<div class=" spacer">
							<input type="submit" id="btnAdd"
								class="btn btn-block btn-default btn-primary" value="Pay" /> <a
								href="product_summary" class="btn  btn-block ">Cancel</a>

						</div>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</div>

