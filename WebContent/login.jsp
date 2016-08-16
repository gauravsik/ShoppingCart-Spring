<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login To Continue</h2>

	<form:form commandName="user" method="POST" action="login">
		<table>
			<tr>
				<td><span class="red-text text-darken-2"> 
				<c:if test="${ not empty error }">Invalid Credentials</c:if>
				</span>
				</td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username"/></td>
				<td><form:errors cssClass="red-text text-darken-1" path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors cssClass="red-text text-darken-1" path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input class="btn blue" type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>