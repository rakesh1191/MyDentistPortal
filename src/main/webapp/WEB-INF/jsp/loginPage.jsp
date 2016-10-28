<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/CSS" href="CSS/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form:form modelAttribute="loginPage" role="form" class="form-signin">
  <div class="container">
      <div class="container"><h2 class="form-signin-heading">Please login</h2></div>
      <br>
      <div class="col-sm-3">
      <input type="text" class="form-control" name="username" placeholder="Enter username" required/></div>
      <br><br><br>
      <div class="col-sm-3">
      <input type="password" class="form-control" name="userPassword" placeholder="Enter Password" required/></div>      
      <input type="hidden" name="_csrf" value="${_csrf.token}">
      <br><br><br>
      <div class="container">
    	<input type="submit" class="btn btn-lg btn-info collapsed" value="Login" >
	  </div>   
	  <br><br>
	<a href="PatientRegistration.html">New Patient ? Sign-up here</a>
  </div>
</form:form>
  </body>
</html>
