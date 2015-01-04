<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<table>
	<tr>
	    <td><h3>Edit Existing Product</h3></td>
	    <td>
	        </td>
	    </tr>
</table>
<div class="container">
	<springForm:form method="POST" commandName="product" action="update?pid=${product.id}">		
	<fieldset>
		<legend>Product details</legend>
		<table>
			<tr>
				<td style="width:130px">Product Name:</td>
				<td><springForm:input path="name" /></td>
				<td><springForm:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><springForm:input path="description" /></td>
				<td><springForm:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><springForm:input path="price" /></td>
				<td><springForm:errors path="price" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Category:</td>
				<td><springForm:input path="category.id" /></td>
				<td><springForm:errors path="category.id" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" class="btn btn-primary" value="Save Product"></td>
			</tr>
		</table>
		</fieldset>
	</springForm:form>
</div>
