<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#ConfirmPassword").onchange(function(){
	
		var first = document.getElementById("#password").value;
		var second = document.getElementById("#ConfirmPassword").value;
		alert("hiiiiiiiii");
		if(first == second){
		document.getElementById("#submit").disabled=false;
		}else{
		document.getElementById("#submit").disabled=true;   
		}
	}
)};
</script>
</head>
<body>
<div align="center">
<div>Previous Password : <input type="text" name="previousPassword"></div>
<div>Enter New Password : <input type="text" name="password" id="password"></div>
<div>Enter Password Again : <input type="text" id="ConfirmPassword" ></div>
<div><a id="alert"></a></div>
<form action="changePassword.html" method="post">
<br/><input type="submit" name="submit" id="submit" disabled>
</form> 
</div>
</body>
</html>