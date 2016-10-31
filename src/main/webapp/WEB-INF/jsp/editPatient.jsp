<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" >
        <form:form modelAttribute="user">
            <div class="col-sm-10" >
                <div class="well well-sm" align="center"><strong>Update Information</strong></div>
                <div class="form-group">
                    <label for="userContact">Contact</label>
                    <form:input path="userContact"/>
                       
                </div>
                <div class="form-group">
                    <label for="userEmail">Email</label>
                    <form:input path="userEmail"/>
                    
             
                </div>
                <div class="form-group">
                    <label for="userAddress">Address</label>
                    <form:input path="userAddress"/>
                   
                </div>
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info">	
            </div>
        </form:form>
    </div>
</div>
</body>
</html>