<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container"></div>
	<div class="row">
		<div class="col-2">
			<img alt="logo" src="${pageContext.request.contextPath}/images/logo1.PNG" class="img-thumbnail">
		</div>
		<div class="col-10">
		<form class="mt-5">
			 <div class="form-group row">
			 		<select class="browser-default custom-select col-sm-2">
						  <option value="" selected disabled hidden="true">Category</option>
						  <option value="1">One</option>
						  <option value="2">Two</option>
						  <option value="3">Three</option>
					</select>
					<div class="col-sm-8">
				      <input type="text"  class="form-control">
				    </div>
				    <div class="col-sm-2">
				      <button type="button" class="form-control btn btn-dark">Search</button>
				    </div>
			 </div>
		</form>    
  	</div>
</div>

<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Smart Phone Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About Us</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
    
    	<c:if test="${sessionScope.acc.role == 1}">
			<a class="nav-link disabled" href="">Manager Account: ${sessionScope.acc.username}</a>
			<a class="btn btn-dark" href="#">Product Management</a>
			<a class="btn btn-dark" href="logout" role="button">Logout</a>
		</c:if>					
		
		<c:if  test="${sessionScope.acc != null && sessionScope.acc.role != 1}">
			<a class="nav-link disabled" href="">Hello ${sessionScope.acc.username}</a>
			<a class="btn btn-dark" href="logout" role="button">Logout</a>
			
		</c:if>
			
		<c:if test="${sessionScope.acc == null}">
			<a class="btn btn-dark" href="${pageContext.request.contextPath}/jsp/login.jsp" role="button">Login</a>
			<a class="btn btn-dark" href="register.jsp" role="button">Register</a>
		</c:if>
    </form>
	<form action="search" method="get" class="form-inline my-2 my-lg-0">
		<div class="input-group input-group-sm">
			<input name="txt" value="${searched}" type="text" class="form-control"
				aria-label="Small" aria-describedby="inputGroup-sizing-sm"
				placeholder="Search...">
			<div class="input-group-append">
				<button type="submit" class="btn btn-secondary btn-number">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</div>
		<a class="btn btn-success btn-sm ml-3" href="inforcart"> <i
			class="fa fa-shopping-cart"></i> Cart <span
			class="badge badge-light">${cartlist.size()}</span>
		</a>
	</form>
  </div>
</nav>