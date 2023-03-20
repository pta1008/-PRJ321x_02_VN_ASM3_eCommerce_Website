<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
<!-- 	<div class="leftcolumn"> -->
		
		<div class="card-group">
		<c:forEach items="${products}" var="o">
		<div class="col-12 col-md-6 col-lg-4">
		  	<div class="card">
			    <img src="${o.src}" class="card-img-top" alt="Card image cap">
			    <div class="card-body">
			      <h4 class="card-title show_txt"><a href="inforproduct?pid=${o.id}" title="View Product">${o.name}</a></h5>
			      <p class="card-text">${o.type}</p>
			      <p class="card-text">${o.description}</p>
			    </div>
			    <div class="card-footer">
			      	<div class="row">
						<div class="col">
							<p class="btn btn-danger btn-block">${o.price}$</p>
						</div>
						<div class="col">
							<a href="add-to-cart?id=${o.id}" class="btn btn-success btn-block">Add to cart</a>
						</div>
					</div>
			    </div>
		  	</div>
		  </div>
		  </c:forEach>
		  </div>
<!-- 	</div> -->
<!-- 	<div class="rightcolumn"> -->
<%-- 		<c:forEach items="${cartlist}" var="c"> --%>
		
<!-- 		  	<div class="card"> -->
			   
<!-- 			    <div class="card-body"> -->
<%-- 			      <h6 class="card-title show_txt"><a href="inforproduct?pid=${c.id}" title="View Product">${c.name}</a></h5> --%>
<%-- 			      <p class="card-text">${c.price}$</p>			       --%>
<!-- 			    </div> -->
<!-- 		  	</div> -->
		  
<%-- 		  </c:forEach> --%>

<!-- 		<div class="card"> -->
<!-- 			<h3>Popular products of banners</h3> -->
<!-- 			<div class="fakeimg"><p>image</p></div> -->
<!-- 			<div class="fakeimg"><p>image</p></div> -->
<!-- 			<div class="fakeimg"><p>image</p></div> -->
<!-- 		</div> -->
<!-- 	</div> -->
</div>	
	
