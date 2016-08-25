<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false" %>
<html>
<head>
<style type="text/css">
#nav{
margin-left: 450px;
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
<title>Exception/Error</title>
</head>

<body>
	<h1><c:out value="${exceptionMsg}"></c:out></h1>
	<a href="<c:url value="/shop/products"/>">Products</a>
</body>
</html>