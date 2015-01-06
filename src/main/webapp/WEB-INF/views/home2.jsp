
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<!-- body================================== -->
<div class="span9">
	<div class="well well-small">
		<h4>
			 Brand Products <small class="pull-right">High Quality
				products</small>
		</h4>
		<div class="row-fluid">
			<div id="myCarousel" class="carousel slide">
				<div class="carousel-inner">
					<div class="item active">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/3.png"
							alt="special offers" /></a>
					</div>
					<div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/2.png" alt="" /></a>
					</div>
					<div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/1.png" alt="" /></a>
					</div>
					<div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/4.png" alt="" /></a>
					</div><div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/5.png" alt="" /></a>
					</div><div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/6.png" alt="" /></a>
					</div><div class="item">

						<a href="registration"><img
							src="/cs490/resources/themes/images/carousel/7.png" alt="" /></a>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
			
		</div>
	</div>
<div class="span9">
	<ul class="thumbnails">		<c:forEach items="${allProducts}" var="product"
			varStatus="loopCounter">

			<li class="span3">
				<div class="thumbnail">
					<a href="product_details.html"><img style="width: 200px; height: 200px" src='/cs490/admin/vendor/product/pic?pid=${product.id}'/></a>
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

