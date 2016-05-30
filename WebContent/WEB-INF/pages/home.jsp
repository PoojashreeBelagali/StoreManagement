<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<a href='<jsp:forward page="city.jsp"></jsp:forward>'>Get All
		Cities</a>
	<a href='<jsp:forward page="add_store.jsp"></jsp:forward>'>Add
		Store</a>
	<a href='<jsp:forward page="update_store.jsp"></jsp:forward>'>Update
		Store </a>
	<a href='<jsp:forward page="delete_store.jsp"></jsp:forward>'>Delete
		Store </a>
	<a href='<jsp:forward page="find_store.jsp"></jsp:forward>'>Find
		Store </a>

</body>
</html>