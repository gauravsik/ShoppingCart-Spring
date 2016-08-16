<%@page import="com.bitwise.shop.models.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="products" uri="/WEB-INF/CustomTags/custom.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <spring:url value="/resources/style.css" var="style" ></spring:url>
<link href="${style}" rel="stylesheet" /> --%>
<style type="text/css">
table {
    border-collapse: collapse;
    border: 1px solid black;
    width: 50%;
    margin: 10px 50px 50px 300px;
}

td {
	
    height: 20px;
    vertical-align: bottom;
}
th, td {
    padding: 15px;
    text-align: left;
    border: 1px solid black;
    color: navy;
   font-weight: bold;
}
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
<title>ViewCart</title>
</head>
<body>
	<h1>Confirm!</h1>
	<a href="<c:url value="/products"/>">Products</a>
	<a href="<c:url value="/logout"/>">Logout</a>
	<table>
	<tr>
	<td>Product ID</td>
	<td>Product Name</td>
	<td>Quantity</td>
	<td>Total</td>
	<td>Product Supplier</td>
	</tr>
	<c:forEach items="${cart.getOrderdItems()}" var="item">
	<tr>
		<td><c:out value="${item.getPID()}"></c:out></td>
		<td><c:out value="${item.getProdName()}"></c:out></td>
		<td><c:out value="${item.getQuantity() }"></c:out> </td>
		<td><c:out value="${item.getTotalAmount()}"></c:out></td>
		<td><c:out value="${item.getSupplier()}"></c:out></td>
	</tr>
	</c:forEach>
	</table>
	<h1>Grand Total Amount : <c:out value="Rs ${cart.getCartValue()}"></c:out></h1>
</body>
</html>