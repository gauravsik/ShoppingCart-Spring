<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
</head>
<body>
	<h1>Shopping Cart</h1>
	<a href="<c:url value="/login"/>">Login</a>
	<a href="<c:url value="/shop/products"/>">View Products</a>
	<a href="<c:url value="/shop/logout"/>">Logout</a>
</body>
</html>
