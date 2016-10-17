<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Page</title>
</head>
<body bgcolor="lightgreen">
	<%--  <%
	String message="";
	if(request.getAttribute("message")!=null){
		message=request.getAttribute("message").toString();
	}
%>	<%=message %> --%>

<c:if test="${requestScope.message!=null }">
		<font color="red" size="3"> <c:out value="${message }" />
		</font>
	</c:if>
	<form name="f1" method="post" action="./RetrieveBatchController">

<pre>

			 		<input type="submit" value="Display Batch Details" />
</pre>

	</form>
</body>
</html>