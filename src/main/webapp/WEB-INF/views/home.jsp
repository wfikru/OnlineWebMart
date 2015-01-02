<div class="container">
	<!-- Navbar ================================================== -->
	<div id="logoArea" class="navbar">
		<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
			class="btn btn-navbar"> <span class="icon-bar"></span> <span
			class="icon-bar"></span> <span class="icon-bar"></span>
		</a>
		<div class="navbar-inner">
			<!-- Logo Image -->
			<a class="brand" href="index.html"><img
				src="/cs490/resources/themes/images/logo.png" alt="Bootsshop" /></a>
			<form class="form-inline navbar-search" method="post"
				action="products.html">
				<input id="srchFld" class="srchTxt" type="text" /> <select
					class="srchTxt">
					<option>All</option>
					<option>CLOTHES</option>
					<option>FOOD AND BEVERAGES</option>
					<option>HEALTH & BEAUTY</option>
					<option>SPORTS & LEISURE</option>
					<option>BOOKS & ENTERTAINMENTS</option>
				</select>
				<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
			</form>
			<ul id="topMenu" class="nav pull-right">
				<li class=""><a href="special_offer.html">Specials Offer</a></li>
				<li class=""><a href="normal.html">Delivery</a></li>
				<li class=""><a href="contact.html">Contact</a></li>
				<li class=""><a href="#login" role="button" data-toggle="modal"
					style="padding-right: 0"><span
						class="btn btn-large btn-success">Login</span></a>
					<div id="login" class="modal hide fade in" tabindex="-1"
						role="dialog" aria-labelledby="login" aria-hidden="false">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3>Login Block</h3>
						</div>
						<div class="modal-body">
							<form class="form-horizontal loginFrm" action="loginCheck"
								method="POST" commandName="user">
								<div class="control-group">
									<input type="text" id="inputEmail" path="username"
										placeholder="User Name">
								</div>
								<div class="control-group">
									<input type="password" id="inputPassword" path="password"
										placeholder="Password">
								</div>
								<div class="control-group"></div>
								<button type="submit" class="btn btn-success">Sign in</button>
							</form>

							<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
						</div>
					</div></li>
			</ul>
		</div>
	</div>
</div>
</div>
<!-- body================================== -->
<div id="carouselBlk">
	<div id="myCarousel" class="carousel slide">
		<div class="carousel-inner">
			<div class="item active">
				<div class="container">
					<a href="customer"><img style="width: 100%"
						src="/cs490/resources/themes/images/carousel/1.png"
						alt="special offers" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="container">
					<a href="customer"><img style="width: 100%"
						src="/cs490/resources/themes/images/carousel/2.png" alt="" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="container">
					<a href="customer"><img
						src="/cs490/resources/themes/images/carousel/3.png" alt="" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>

				</div>
			</div>
			<div class="item">
				<div class="container">
					<a href="customer"><img
						src="/cs490/resources/themes/images/carousel/4.png" alt="" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>

				</div>
			</div>
			<div class="item">
				<div class="container">
					<a href="customer"><img
						src="/cs490/resources/themes/images/carousel/5.png" alt="" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="container">
					<a href="customer"><img
						src="/cs490/resources/themes/images/carousel/6.png" alt="" /></a>
					<div class="carousel-caption">
						<h4>Second Thumbnail label</h4>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
</div>

</div>
