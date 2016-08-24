<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

a:link, a:visited {
    background-color: #336699;
    color: white;
    padding: 14px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
   	
}
h1{
text-align: center;
color: #336699;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
</head>
<body>
<a href="<c:url value="/shop/products"/>">Continue Shopping</a>
<a href="<c:url value="/shop/viewcart"/>">View Cart</a>
<a href="<c:url value="/shop/logout"/>">Logout</a>
<h1>Your order has been placed</h1>
<h1>Grand Total Amount : <c:out value="Rs ${cart.getCartValue()}"></c:out></h1>
</body>
</html>