<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
<!-- Fav and Touch Icons -->
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
	<div id="header">
		<div class="container">
			<!-- Navbar ================================================== -->

			<div id="welcomeLine" class="row">
				<div class="span6">
					Welcome!<strong> User</strong>
				</div>
				<div class="span6"></div>
			</div>
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<!-- Logo Image -->
					<a class="brand" href="index.html"><img
						src="/cs490/resources/themes/images/logo.png" alt="Bootsshop" /></a>
					
					<ul id="topMenu" class="nav pull-right">
						<li class=""><a href="special_offer.html">Home</a></li>
						<li class=""><a href="normal.html">Delivery</a></li>
						<li class=""><a href="contact.html">Contact</a></li>
						
					</ul>
				</div>
			</div>

			<div class="container">
				<sitemesh:write property='body' />
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>