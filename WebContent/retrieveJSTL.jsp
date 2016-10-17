<%@page import="com.sonata.pharma.vo.BatchVO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve batch</title>
</head>
<body background="n.jpg">

<h1>PHARMA ASSISTANCE</h1>
            <h2>Retrieve batch</h2>
            <table border=1>
            <tr>
			<th>BatchCode</th>
			<th>MedicineCode</th>
			<th>MedicineName</th>
			<th>MedicinetypeCode</th>
			<th>MedicineTypeName</th>
			<th>CareLevel</th>	
			<th>Weight</th>
			<th>Price</th>
			<th>ShippingCharge</th>
			<th>TotlalAmount</th>
		</tr>
   <c:forEach items="${requestScope.batchList}" var="batchVo">
		<tr>
			<td><c:out value="${batchVo.batchCode}" /></td>
			<td><c:out value="${batchVo.medicineCode}" /></td>
			<td><c:out value="${batchVo.medicineName}" /></td>
			<td><c:out value="${batchVo.medicineTypeCode}" /></td>
			<td><c:out value="${batchVo.medicineTypeName}" /></td>
			<td><c:out value="${batchVo.careLevel}" /></td>
			<td><c:out value="${batchVo.weight}" /></td>
			<td><c:out value="${batchVo.price}" /></td>
			<td><c:out value="${batchVo.shippingCharge}" /></td>
			<td><c:out value="${batchVo.totalCost}" /></td>
		</tr>
</c:forEach>
	</table>
</body>
</html>