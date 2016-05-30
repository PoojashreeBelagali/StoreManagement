<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD STORE</title>
</head>
<body>
	<form:form commandName="store" action="store" method="POST">
		<table>
			<tr>
				<td>Store Name:</td>
				<td><form:input path="storeName" /></td>
				<td><form:errors path="storeName" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Store Name:</td>
				<td><form:input path="distance" /></td>
				<td><form:errors path="distance" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Select City</td>
				<td><form:select path="city">
						<form:option value="-1">Select City: </form:option>
						<c:forEach items="${cities}" var="city">
							<form:option value="${city.ityName}">${city.cityName}</form:option>
						</c:forEach>

					</form:select></td>
				<td><form:errors path="city" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><input type="submit" value='Add Store>'></td>
			</tr>
		</table>
	</form:form>
</body>
</html>