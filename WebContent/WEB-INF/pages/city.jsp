<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery_1.7.2.min.js">
$(document).ready(
		$('#id_getcity').click(function() {
    	$.ajax({
        	url : "city",
        	type: "GET",
        	  	
        	dataType : "json",
        	 success: function (data) {
                 $.each(data.cities,function(i,data)
                 {
                  var div_data="<option value="+data.cityName+">"+data.zipCode+"</option>";
                 alert(div_data);
                 $(div_data).appendTo('#ch_city'); 
                 });}
    	});
    })
);

</script>
</head>
<body>

	<form:form>
		<div id="div_source1">
			<select id="ch_city">
				<option value="select"></option>
			</select>
		</div>
<input type="button" id="id_getcity" name="Get Cities" value="Get All Cities">
	</form:form>
</body>
</html>