<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
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
<title>Products</title>
</head>
<body>
<h1>Products</h1>
	
	<a href="<c:url value="/index"/>">Home</a>
	<a href="<c:url value="/shop/viewcart"/>">ViewCart</a>
	<table>
		<tr>
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Product Price</td>
			<td>Product Stock</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${shop.getProducts()}" var="item">
		
			<tr>
				<td><c:out value="${item.getPid()}"></c:out></td>
				<td><c:out value="${item.getPname()}"></c:out></td>
				<td><c:out value="${item.getPrice()}"></c:out></td>
				<td><c:out value="${item.getStock()}"></c:out></td>
				<td><a href='/OnlineShopping/shop/add?pid=${item.getPid()}'>ADD</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>