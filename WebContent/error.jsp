<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Error Page</title>
</head>
<body>
<h1 align="center">Error Page</h1>

<c:if test="${requestScope.message!=null }">
		<font color="red" size="3"> <c:out value="${requestScope.message }" />
		</font>
	</c:if>
</body>
</html>