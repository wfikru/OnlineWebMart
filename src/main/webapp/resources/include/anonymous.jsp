<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="logoArea" class="navbar">
	<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
		class="btn btn-navbar"> <span class="icon-bar"></span> <span
		class="icon-bar"></span> <span class="icon-bar"></span>
	</a>
	<div class="navbar-inner">
		<!-- Logo Image -->
		<a class="brand" href="home"><img
			src="/cs490/resources/themes/images/logo.png" alt="Bootsshop" /></a>
			
		<form:form action="productByName" methodParam="name"  modelAttribute="searchProduct" class="form-inline navbar-search" method="POST">
			<form:input  path="name" type="text" /> 
			<button type="submit" id="submitButton" class="btn btn-primary" >Search</button>
		</form:form>
		<ul id="topMenu" class="nav pull-right">
			<li class=""><a href="special_offer.html">Specials Offer</a></li>
			<li class=""><a href="normal.html">Delivery</a></li>
			<li class=""><a href="contact.html">Contact</a></li>
			<li class=""><a href="login" 
				style="padding-right: 0"><span class="btn btn-large btn-success">Login</span></a>
				</li>
		</ul>
	</div>
</div>
</div>
</div>
