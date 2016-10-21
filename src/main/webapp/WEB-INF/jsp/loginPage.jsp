<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
	<link rel="stylesheet" type="text/CSS" href="CSS/style.css">
  </head>
  <body>
    <div class="login">
	<h1>Login</h1>
	<form:form modelAttribute="loginPage" role="form">
	Username : <spring:bind path="username"><input type="text" name="username" id="username" required/></spring:bind><br><br>
	Password : <spring:bind path="userPassword"><input type="password" name="userPassword" id="userPassword" required/></spring:bind><br><br>
	<button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
	<center><br><br>
	<a href="PatientRegistration.html">New Patient ? Sign-up here</a>
 </form:form>
</div>
  </body>
</html>
