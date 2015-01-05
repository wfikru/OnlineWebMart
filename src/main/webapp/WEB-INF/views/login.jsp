<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


					
					<div class="span9">
	<div class="well well-small">
							<div class="modal-body">
						<form:form  action="loginCheck"
							method="POST" modelAttribute="user">
							<div class="control-group">
							<c:if test="${error }">
							<p style="color: red">User name or password incorrect</p>
							</c:if></div>
							<div class="control-group">
								User name: <form:input type="text" id="inputEmail" path="email"
									placeholder="Email"/>
							</div>
							<div class="control-group">
								Password: &nbsp<form:input type="password" id="inputPassword" path="password"
									placeholder="Password"/>
							</div>
							<div class="control-group"></div>
							<button type="submit" class="btn btn-success">Sign in</button>
						</form:form>

					</div></div>
				</div>
