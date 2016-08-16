<%@page import="com.bitwise.shop.models.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="products" uri="/WEB-INF/CustomTags/custom.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<a href="<c:url value="/viewcart"/>">ViewCart</a>
	<table>
		<tr>
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Product Price</td>
			<td>Product Supplier</td>
			<td>Product Stock</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${cart.getProductsList()}" var="item">
			<tr>
				<td><c:out value="${item.getPID()}"></c:out></td>
				<td><c:out value="${item.getProdName()}"></c:out></td>
				<td><c:out value="${item.getProdPrice()}"></c:out></td>
				<td><c:out value="${item.getSupplier()}"></c:out></td>
				<td><c:out value="${item.getStock()}"></c:out></td>
				<td><a href='/ShoppingCart/add?productId=${item.getPID()}'>ADD</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>