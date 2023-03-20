<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
  <a class="navbar-brand" href="#">Smart Phone Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About Us</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
     	<% 	String user = (String)session.getAttribute("user");
    		if(user == null){
    	%>
    		
    		<a class="btn btn-dark" href="/ASM2/login?action=login" role="button">Login</a>

    	<%
    		} else {
    	%>
    		<a class="nav-link disabled" href="">${user}</a>
    		<a class="btn btn-dark" href="/ASM2/logout?action=logout" role="button">Logout</a>
       		
    	<%	
    		}
    	%>
    </form>
  </div>
</nav>