<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid" style="padding: 0">
	<div class="row-fluid">
		<div class="span2">
			<!--Sidebar content-->
			<ul class="nav nav-list">
				<li class="nav-header">Administrative</li>
				<li><a href="/cs490/admin/vendor/product">Manage my product</a></li>
				<li><a href="/cs490/admin/vendor/category">Product Category</a></li>
				<li class="nav-header">Reports</li>
				<li><a href="/cs490/admin/vendor/report">Generate reports</a></li>
			</ul>
		</div>
		<div class="span10">
			<!--Body content-->
			<div>
				<table>
					<tr>
						<td><h3>My Profile</h3></td>
						<td></td>
					</tr>
				</table>
				<table cellspacing="0" width="75%">
					<tbody>
						<tr>
							<td width="300px;">

								<div class="thumbnail">
									<c:if test="${vendor.image==null }">
										<img alt="300x200" data-src="holder.js/300x200"
										style="width: 300px; height: 200px;"
										src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAADICAYAAABS39xVAAAEsElEQVR4nO3bMVLjSABA0bn/UQgdOXLixKEP4DPoCjORqtqihakaWPZrXvASaCQZSr+6RevXsiy/AQp+/fQFAHyWYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYJ1MG9vb0/u9/t03P1+fxp3Op12j3k+n5/G3m63v77O0+n06fNvP9Pj8ZiOu16vT+Mul8uP/z34WoJ1EI/H492Nvbper09jb7fb7tjtcbdh2TvmV1znNkYfjd2G+HK5TMedz+cf/9vwdQTrIMYbdr3px5nROHaN0Hgzz2YlY9jWQIyzmL2Zzmevcz3mGKbx/OPY9WvrZxpnZOPPryEdZ5BfMSPk/0GwDmIWodkNP97I4yxlHTuGYI3DeMwxDmsIxrCNwRnjtoZkdp3jucbzz2Zz47nWYI7nmf1OLA2PQ7AObLYs2pshzUKw9yxoFoJx6fh4PJ7C9tHzqdU2WHszpFkwZ7FblnmEaROsAxqjtHcTb2cj2+XfbJm1ms2SxsBcLpen5ejeg//Zz67HnC1Hl2W+/Nubte19VroE64C2D6BnS7+vDtbsvJ9djo3jZ8tMwWIlWAc2zrTWm/47g7Us77cgvLrGvf/oCRYzgnVw25nOdwdrPP6r2dUYq+3SVbCYEayD28bjux66L8v7zagfPb96NRPz0J0ZwTqA8eYeZ0Oz/U3fsa1hNdtkOovFdtze55p9Jtsa/m2CdRCzAMw2aY5jX20cnT0D25uhjV+/3W7TPVjbca+WarONr7PZ1CzYNo4ek2AdxEev23z3qzl7e662e7M+Ot7sGryaw5ZgHcjsBv8vXn7e23O13V/16j3CvWhuv+/l53+XYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpAhWECGYAEZggVkCBaQIVhAhmABGYIFZAgWkCFYQIZgARmCBWQIFpDxB2bVxDz7FuNBAAAAAElFTkSuQmCC">

									</c:if>
									<c:if test="${vendor.image!=null }">
										<img alt="300x200" data-src="holder.js/300x200"
										style="width: 300px; height: 200px;"
										src="/cs490/admin/vendor/profile/picture">

									</c:if>
								</div>
							</td>
							<td valign="top" style="padding-left: 20px;">
								<table cellspacing="0" width="100%" class="mytbl">
									<tr>
										<td style="width: 130px">Company Name</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.vendorName}</td>
									</tr>
									<tr>
										<td style="width: 130px">Email</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.email}</td>
									</tr>
									<tr>
										<td style="width: 130px">Street</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.address.street}</td>
									</tr>
									<tr>
										<td style="width: 130px">City</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.address.city}</td>
									</tr>
									<tr>
										<td style="width: 130px">State</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.address.state}</td>
									</tr>
									<tr>
										<td style="width: 130px">Zip</td>
										<td style="width: 10px;">:</td>
										<td>${vendor.address.zip}</td>
									</tr>

								</table>
							</td>
						</tr>
					</tbody>

				</table>
				<div style="padding-top: 10px; padding-bottom: 10px;">
					<button
						onclick="location.href = '/cs490/admin/vendor/profile/edit';"
						id="btnEdit" class="btn btn-primary">Edit</button>
				</div>

			</div>
		</div>
	</div>
</div>


