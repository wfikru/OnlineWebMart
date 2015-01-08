<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<!-- Logo Image -->
					<a class="brand" href="back"><img
						src="/cs490/resources/themes/images/logo.png" alt="Mercato" /></a>

					<form:form action="/cs490/product/search" methodParam="query"
					 	class="form-inline navbar-search"
						method="POST">
						<input type="text" name="query" value="${query}" />
						<button type="submit" id="submitButton" class="btn btn-primary">Search</button>
					</form:form>
					<ul id="topMenu" class="nav pull-right">
						<li class=""><a href="/cs490/registration">Login /
								Register</a></li>
					</ul>
				</div>
			</div>
