<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Store</title>
<script type="text/javascript" src="js/jquery_1.7.2.min.js">
	$(document).ready(function getAllStores() {
		$.ajax({
			url : 'store',
			type : "GET",
			success : function(data) {
				$("#stores").html(data);
			}
		});
	});
	$(document).ready(function update() {
		$.ajax({
			url : 'id',
			type : 'PUT',
			data : {
				id : "storeId",
				store : "storeForm".serialize()
			},
			success : function(response) {
				$("#result").html(response);
			},
			error : function(response) {
			},

		});

	});
	$(document).ready(function deleteStore() {
		$.ajax({
			url : 'id',
			type : 'DELETE',
			data : {
				id : "storeId",
				store : "storeForm".serialize()
			},
			success : function(response) {
				$("#result").html(response);
			},
			error : function(response) {
				alert(response);
			},

		});

	});
</script>
</head>
<body onload="getAllStores()">
	<form:form id="form" commandName="storeForm" action="/store/id"
		method="PUT">
		<div id="stores">
			<table>

				<c:forEach items="${stores}" var="store">
					<form:hidden id="storeId" path="storeId" value="${store.storeId }" />
					<form:input path="storeName" type="text"
						value="${store.storeName }" />
					<form:button type="submit" id="Update" value="Update"
						onclick="update()"></form:button>
					<form:button type="submit" id="delete" value="Delete"
						onclick="deleteStore()"></form:button>
					<div id="result"></div>
				</c:forEach>

			</table>
		</div>
	</form:form>
</body>
</html>