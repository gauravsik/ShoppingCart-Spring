<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <spring:url value="/resources/style.css" var="style" ></spring:url>
<link href="${style}" rel="stylesheet" />  --%>
<style type="text/css">
a:link, a:visited {
    background-color: #336699;
    color: white;
    padding: 14px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
</head>
<body>
<h1>This is the Index page!</h1>
<a href=login>Login Page</a>
<a href=products>View Products</a>
<a href=viewcart>View Cart</a>
</body>
</html>
