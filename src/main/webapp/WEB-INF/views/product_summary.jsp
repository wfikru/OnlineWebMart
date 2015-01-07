<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="span9">
	<table class="table table-bordered" value=${cartProduct }>
		<thead>
			<tr>
				<th>Product</th>
				<th>Name</th>
				<th>Quantity/Update</th>
				<th>Description</th>
				<th>Price</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cartProducts}" var="product"
				varStatus="loopCounter">

				<tr>
					<td><img
						src="/cs490/admin/vendor/product/pic?pid=${product.id}" /></td>

					<td>${product.name }</td>
					<td>
						<div class="input-append">
							<input class="span1" disabled="disabled" style="max-width: 34px"
								placeholder="${product.cartQuantity}" id="appendedInputButtons"
								size="16" type="text"> <a
								href="<c:url value='minusOne'>
								<c:param name='id' value='${product.id }'/>
								</c:url>"
								class="btn" type="button"> <i class="icon-minus"></i>
							</a> <a
								href="<c:url value='plusOne'>
								<c:param name='id' value='${product.id }'/>
								</c:url>"
								class="btn" type="button"> <i class="icon-plus"></i>
							</a> <a
								href="<c:url value='removeFromCart'>
								<c:param name='id' value='${product.id }'/>
								</c:url>"
								class="btn btn-danger" type="button"> <i
								class="icon-remove icon-white"></i>
							</a>
						</div>
					</td>
					<td>${product.description }</td>
					<td>${product.price }</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" style="text-align: right"><strong>TOTAL
				</strong></td>
				<td class="label label-important" style="display: block"><strong>
						$ ${total} </strong></td>
			</tr>

		</tbody>
	</table>
	<div class="pull right">
		<a href="continue" class="btn btn-success "><span
			class="glyphicon glyphicon-arrow-left"></span>&nbsp;Continue Shopping</a>
		<a href="payment"><span class="btn btn-primary pull-right"><i
				class="icon-shopping-cart icon-white"></i>&nbsp;&nbsp; Check Out
				&nbsp;&nbsp;</span> </a>
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