<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Mercato</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!--Less styles -->
<!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="/cs490/resources/themes/bootshop/bootstrap.min.css"
	media="screen" />
<link href="/cs490/resources/themes/css/base.css" rel="stylesheet"
	media="screen" />
<!-- Bootstrap style responsive -->
<link href="/cs490/resources/themes/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link href="/cs490/resources/themes/css/font-awesome.css"
	rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->
<link
	href="/cs490/resources/themes/js/google-code-prettify/prettify.css"
	rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="/cs490/resources/themes/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="/cs490/resources/themes/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="/cs490/resources/themes/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="/cs490/resources/themes/images/ico/apple-touch-icon-57-precomposed.png">
<style type="text/css" id="enject"></style>
</head>
<body>
	<div>
		<div class="container">
			<div id="welcomeLine" class="row">
				<div class="span6">
					Welcome <strong> <c:out value="${user.email }" /></strong>!
				</div>
				<div class="span6">
					<div class="pull-right">
						<a href="/cs490/product/cart"><span></span></a> </a> <a
							href="/cs490/product/cart"><span class="btn btn-mini btn-primary"><i
								class="icon-shopping-cart icon-white"></i>${size} Items in your
								cart </span> </a>
					</div>
				</div>
			</div>
			<!-- Menu bar============================ -->
			
			<c:if test="${status}">
				<jsp:include page="/resources/include/loggedin.jsp" />
			</c:if>
			<c:if test="${!status}">
				<jsp:include page="/resources/include/anonymous.jsp" />
			</c:if>
			
			<!-- Side bar ======================================= -->
			<div>
				<div class="container">
					<div class="row-fluid" style="height: 500px;">
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
								</div>
								<div class="item">

									<a href="registration"><img
										src="/cs490/resources/themes/images/carousel/5.png" alt="" /></a>
								</div>
								<div class="item">

									<a href="registration"><img
										src="/cs490/resources/themes/images/carousel/6.png" alt="" /></a>
								</div>
								<div class="item">

									<a href="registration"><img
										src="/cs490/resources/themes/images/carousel/7.png" alt="" /></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>

					</div>

					<div class="row">

						<!-- End of side bar========================================= -->
						<sitemesh:write property='body' />
					</div>

					<script
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
					<script
						src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
				</div>
			</div>
		</div>
	</div>

</body>