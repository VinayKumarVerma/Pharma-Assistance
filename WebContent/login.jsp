 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${requestScope.message!=null }">
		<font color="red" size="3"> <c:out value="${requestScope.message }" />
		</font>
	</c:if>
<form name="log" method="post" action="./LoginController">
<table>
<tr><td><b>UserName</b></td><td><input type="text" name="userName" autofocus required /></td></tr>
<tr><td><b>Password</b></td><td><input type="password" name="password" autofocus required /></td></tr>
<tr><td><input type="submit" value="Login"></input></td>
	<td><input type="reset" value="Clear"/></td>
</tr>
</table>
</form>
</body>
</html>