<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="container">

	<table>
             <tr>
                 <td><h3>Product List</h3></td>
                 <td>
                     <div style="padding-left: 20px; padding-top:10px;">
                      <form action="/cs490/product/add">
					<input type="submit" id="btnAdd" class="btn btn-mini btn-success" value="Add Product" />
				</form>
                     </div>
                 </td>
             </tr>
         </table>
	<table id="example" class="table table-hove" cellspacing="0" width="75%">
	<thead>
           <tr>
               <th>Name</th>
               <th>Description</th>
               <th>Price</th>
               <th>Category</th>
               <th>Action</th>
           </tr>
     		</thead>
     		

     		<tbody>
      		<c:forEach items="${products}" var = "product">
          	<tr>

               <td><img src="pic?pid=${product.id}" style="width:100px;height:100px"/></td>
               <td>${product.name}</td>
               <td>${product.description}</td>
               <td>${product.price}</td>
               <td>${product.category.name}</td>
               <td>
               	<button onclick="location.href = 'edit?pid=${product.id}';" id="btnEdit" class="btn btn-mini" >
               		Edit
               	</button>
               	<button onclick="location.href = 'delete?pid=${product.id}';" id="btnDelete" class="btn btn-mini btn-danger" >
               		Delete
               	</button>
               </td>
          	</tr>
          	</c:forEach>
     		</tbody>
     		
</table>
</div>

