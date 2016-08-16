<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Exception/Error</title>
</head>
<body>
	<h2>Out Of Stock</h2>
	<c:out value="${exceptionMsg}"></c:out>
	<a href="<c:url value="/products"/>">Products</a>
</body>
</html>