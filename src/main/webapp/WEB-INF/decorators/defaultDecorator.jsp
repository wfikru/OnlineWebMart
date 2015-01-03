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
			<div id="welcomeLine" class="row">
				<div class="span6">
					Welcome!<strong> User</strong>
				</div>
				<div class="span6">
					<div class="pull-right">
						<a href="product_summary.html"><span class="">Fr</span></a> <a
							href="product_summary.html"><span class="">Es</span></a> <span
							class="btn btn-mini">En</span> <a href="product_summary.html"><span>&pound;</span></a>
						<span class="btn btn-mini">$155.00</span> <a
							href="product_summary.html"><span class="">$</span></a> <a
							href="product_summary.html"><span
							class="btn btn-mini btn-primary"><i
								class="icon-shopping-cart icon-white"></i> ${productList.size()}
								Itemes in your cart </span> </a>

					</div>
				</div>
			</div>

			<div class="container">
				<sitemesh:write property='body' />
			</div>
			<!-- Side bar ======================================= -->
			<div id="sidebar" class="span3">
				<div class="well well-small">
					<a id="myCart" href="product_summary.html"><img
						src="/cs490/resources/themes/images/ico-cart.png" alt="cart">3
						Items in your cart <span class="badge badge-warning pull-right">$155.00</span></a>
				</div>
				<ul id="sideManu" class="nav nav-tabs nav-stacked">
					<li class="subMenu open"><a> ELECTRONICS [230]</a>
						<ul>
							<li><a class="active" href="products.html"><i
									class="icon-chevron-right"></i>Cameras (100) </a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Computers, Tablets & laptop (30)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Mobile Phone (80)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Sound & Vision (15)</a></li>
						</ul></li>
					<li class="subMenu"><a> CLOTHES [840] </a>
						<ul style="display: none">
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Women's Clothing (45)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Women's Shoes (8)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Women's Hand Bags (5)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Men's Clothings (45)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Men's Shoes (6)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Kids Clothing (5)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Kids Shoes (3)</a></li>
						</ul></li>
					<li class="subMenu"><a>FOOD AND BEVERAGES [1000]</a>
						<ul style="display: none">
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Angoves (35)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Bouchard Aine & Fils (8)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>French Rabbit (5)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Louis Bernard (45)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>BIB Wine (Bag in Box) (8)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Other Liquors & Wine (5)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Garden (3)</a></li>
							<li><a href="products.html"><i
									class="icon-chevron-right"></i>Khao Shong (11)</a></li>
						</ul></li>
					<li><a href="products.html">HEALTH & BEAUTY [18]</a></li>
					<li><a href="products.html">SPORTS & LEISURE [58]</a></li>
					<li><a href="products.html">BOOKS & ENTERTAINMENTS [14]</a></li>
				</ul>
				<br />
				<div class="thumbnail">
					<img src="/cs490/resources/themes/images/products/panasonic.jpg"
						alt="Bootshop panasonoc New camera" />
					<div class="caption">
						<h5>Panasonic</h5>
						<h4 style="text-align: center">
							<a class="btn" href="product_details.html"> <i
								class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
								class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
								href="#">$222.00</a>
						</h4>
					</div>
				</div>
				<br />
				<div class="thumbnail">
					<img src="/cs490/resources/themes/images/products/kindle.png"
						title="Bootshop New Kindel" alt="Bootshop Kindel">
					<div class="caption">
						<h5>Kindle</h5>
						<h4 style="text-align: center">
							<a class="btn" href="product_details.html"> <i
								class="icon-zoom-in"></i></a> <a class="btn" href="cart">Add to
								<i class="icon-shopping-cart"></i>
							</a> <a class="btn btn-primary" href="#">$222.00</a>
						</h4>
					</div>
				</div>
				<br />
				<div class="thumbnail">
					<img src="/cs490/resources/themes/images/payment_methods.png"
						title="Bootshop Payment Methods" alt="Payments Methods">
					<div class="caption">
						<h5>Payment Methods</h5>
					</div>
				</div>
			</div>
			<!-- End of side bar========================================= -->
			<div class="span9">
				<div class="well well-small">
					<h4>
						Featured Products <small class="pull-right">200+ featured
							products</small>
					</h4>
					<div class="row-fluid">
						<div id="featured" class="carousel slide">
							<div class="carousel-inner">
								<div class="item active">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/b1.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/b2.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/b3.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/b4.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="item">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/5.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<i class="tag"></i> <a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/6.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/7.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/8.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="item">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/9.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/10.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/11.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/1.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="item">
									<ul class="thumbnails">
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/2.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/3.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/4.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
										<li class="span3">
											<div class="thumbnail">
												<a href="product_details.html"><img
													src="/cs490/resources/themes/images/products/5.jpg" alt=""></a>
												<div class="caption">
													<h5>Product name</h5>
													<h4>
														<a class="btn" href="product_details.html">VIEW</a> <span
															class="pull-right">$222.00</span>
													</h4>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<a class="left carousel-control" href="#featured"
								data-slide="prev"></a> <a class="right carousel-control"
								href="#featured" data-slide="next"></a>
						</div>
					</div>
				</div>
				<h4>Latest Products</h4>
				<ul class="thumbnails">
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/cs490/resources/themes/images/products/6.jpg" alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>

								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/cs490/resources/themes/images/products/7.jpg" alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>
								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/OnlineWebMart/resources/themes/images/products/8.jpg"
								alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>
								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/cs490/resources/themes/images/products/9.jpg" alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>
								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/cs490/resources/themes/images/products/10.jpg" alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>
								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
					<li class="span3">
						<div class="thumbnail">
							<a href="product_details.html"><img
								src="/cs490/resources/themes/images/products/11.jpg" alt="" /></a>
							<div class="caption">
								<h5>Product name</h5>
								<p>Lorem Ipsum is simply dummy text.</p>
								<h4 style="text-align: center">
									<a class="btn" href="product_details.html"> <i
										class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#">$222.00</a>
								</h4>
							</div>
						</div>
					</li>
				</ul>

			</div>
		</div>
	</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>