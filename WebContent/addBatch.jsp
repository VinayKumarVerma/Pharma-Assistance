<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title> Batch Addition Page</title>
</head>
<body bgcolor="lightgreen">
<header><h1>Pharma Assistant</h1></header>
<form name="reg" method="post" action="./AddBatchController">
<c:if test="${requestScope.message!=null }">
		<font color="red" size="3"> <c:out value="${requestScope.message }" />
		</font>
	</c:if>
<table border="1">
	<tr><td>Batch Code</td><td><input type="text"  title="It should be in the format &quot BTC-1234 &quot" name="batchCode" /></td></tr>
	<tr><td>Medicine Code</td><td><input type="text" name="medicineCode" pattern="(MC-30[0-9]{1}|MC-310)" title="It should be in the &quot MC-300 to MC-310 &quot format only" required /></td></tr>
	<tr><td>Weight</td><td><input type="number" name="weight" min =100 title="MINUMUM WEIGHT SHOULD BE 100"required /></td></tr>
	<tr><td>Price</td><td><input type="number" title="Medicine Price" name="price" required /></td></tr>
	<tr><td>Medicine Type Name</td>
	<td>
		<select id="medicineTypeName" name="medicineTypeName" required>
		<option>.....Select....</option>
		<option value="Capsules">Capsules</option>
		<option value="Syrups">Syrups</option>
		<option value="Tablets">Tablets</option>
		</select>
	</td>
	</tr>
	<tr><td>Refrigiration</td><td>True<input type="radio" name="refrigiration" value="true" />
	False<input type="radio" name="refrigiration" value="false" checked /></td></tr>
	<tr><td><input type="submit" value="ADD" /></td>
		<td><input type="reset" value="Clear" /></td>
</tr>
</table>
</form>
</body>
</html>