<%@page import="model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>

<% 
	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				
	if(cart_list != null) {	
		request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link href="${pageContext.request.contextPath}/css/mystyle1.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/footer1.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                <div class="col-sm-12">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-6 border-center">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${pinfor.src}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-6">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${pinfor.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency">$</span><span class="num">${pinfor.price}</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>
                                                    ${pinfor.description}
                                                </p></dd>
                                        </dl>

                                        <hr>
<!--                                         <div class="row"> -->
<!--                                             <div class="col-sm-6"> -->
<!--                                                 <dl class="param param-inline"> -->
<!--                                                     <dt>Quantity: </dt> -->
<!--                                                     <dd> -->
<!--                                                         <select class="form-control form-control-sm" style="width:70px;" name="item-quantity"> -->
<!--                                                             <option> 1 </option> -->
<!--                                                             <option> 2 </option> -->
<!--                                                             <option> 3 </option> -->
<!--                                                         </select> -->
<!--                                                     </dd> -->
<!--                                                 </dl>  item-property .// -->
<!--                                             </div> col.// -->

<!--                                         </div> row.// -->
                                        <hr>                                       
                                        <a href="add-to-cart?id=${pinfor.id}" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>
       <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>