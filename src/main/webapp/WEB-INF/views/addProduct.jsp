<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<div class="container">
	<form:form modelAttribute="product" class="form-horizontal"
		action="addit" enctype="multipart/form-data">

		<legend>Add new product</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">Product
				Name</label>
			<div class="col-lg-10">
				<form:input id="name" path="name" type="text"
					class="form:input-large" />

			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="description">Desciption</label>
			<div class="col-lg-10">
				<form:input id="description" path="description" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="price">Price</label>
			<div class="col-lg-10">
				<form:input id="price" path="price" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="category">Category</label>
			<div class="col-lg-10">
				<form:select multiple="single" path="category.id" id="category.id" cssClass="dropDownSelect-small" tabindex="3" onchange="changeState()">
    			<form:options items="${categories}" itemValue="id" itemLabel="name"/>
				</form:select>
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-lg-2" for="productImage">
				Image </label>
			<div class="col-lg-10">
				<form:input id="productImage" path="productImage" type="file"
					class="form:input-large" />
			</div>
		</div>



		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Register" />
			</div>
		</div>

	</form:form>

</div>