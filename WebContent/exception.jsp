<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false" %>
<html>
<head>
<title>Exception/Error</title>
</head>
<body>
	<c:out value="${exceptionMsg}"></c:out>
	<a href="<c:url value="/shop/products"/>">Products</a>
</body>
</html>