<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Store</title>
<script type="text/javascript" src="js/jquery_1.7.2.min.js">
$(document).ready(
		$('#id_getcity').on('load',  function() {
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
                 var stores = data.stores;
                 $(stores).appendTo('#ch_store');
                 });},
    	   error : function(data){
    		   alert(data);
    	   },
    	});
    })
);
$(document).ready(
		$('#"ch_store"').on('change',  function() {
    	$.ajax({
        	url : "store",
        	type: "GET",
        	 data : "storeId", 	
        	dataType : "json",
        	 success: function (data) {
               var distance = data.distance;
               $(distance).appendTo('#result');
    		},
    		error: function (data) {
    			alert(data);
    		},
    	});
    })
);
</script>
</head>
<body onload="">
<div id="div_source1">
<table align="center">

				<tr>
					<td>City:</td>
					<td><select id="ch_city">
						<option value="select"></option>

					</select></td>
				</tr>
				<tr>
				<td>Stores:</td>
				<td><select id="ch_store">
						<option id="storeId" value="select"></option>

					</select></td>
					
				</tr>
				
			</table>
			Distance is:
			<div id="result"></div>
		</div>
		
</body>
</html>