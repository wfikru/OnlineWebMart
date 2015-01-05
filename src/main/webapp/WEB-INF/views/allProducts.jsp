<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="span9">
	<ul class="thumbnails">

		<c:forEach items="${allProducts}" var="product" varStatus="loopCounter">

			<li class="span3">
				<div class="thumbnail">
					<a href="product_details.html"><c:out value="${product.image}" /></a>
					<div class="caption">
						<h5>
							<c:out value="${product.name}" />
						</h5>
						<p>
							<c:out value="${product.description}" />
						</p>

						<h4 style="text-align: center">
							<a href="<c:url value='addToCart'>
								<c:param name='id' value='${product.id }'/>
								</c:url>" class="btn"> Add to <i
								class="icon-shopping-cart" ></i></a> <a  class="btn btn-primary"
								href=""><c:out value="${product.price}" /></a>
						</h4>
					</div>
				</div>
			</li>
	</c:forEach>
		</ul>
</div>

