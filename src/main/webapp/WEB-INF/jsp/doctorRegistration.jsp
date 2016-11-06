<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="row" >
        <form:form modelAttribute="user">
            <div class="col-sm-10" >
                <div class="well well-sm" align="center"><strong>Doctor Registration Form</strong></div>
                <div class="form-group">
                    <label for="UserName">Username</label>
                        <spring:bind path="username"><input type="text" class="form-control" name="username" id="username" placeholder="Enter username" required>
                    	</spring:bind>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <spring:bind path="password"><input type="password" class="form-control" name="password" id="password" placeholder="Enter password" required>
             
                    </spring:bind>
                </div>
                <div class="form-group">
                    <label for="userType">Type</label>
                    <spring:bind path="userType"><input type="text" class="form-control" name="userType" id="userType" value="doctor" disabled>
                    </spring:bind>
                </div>
                <div class="form-group">
                    <label for="userEmail">Enter Email ID</label>
                        <spring:bind path="userEmail"><input type="text" class="form-control" id="userEmail" name="userEmail" placeholder="Enter Email" required>
                		</spring:bind>
                </div>
                <div class="form-group">
                    <label for="userAddress">Enter Address</label>
                    <spring:bind path="userAddress"><input type="text" class="form-control" name="userAddress" id="userAddress" placeholder="Enter address" required>
                    </spring:bind>
                </div>
                <div class="form-group">
                    <label for="dateOfBirth">Enter Date of Birth</label>
                    <spring:bind path="dateOfBirth"><input type="text" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Enter date of birth" required>
                    </spring:bind>
                </div>
                <div class="form-group">
                    <label for="userContact">Enter Contact</label>
                    <spring:bind path="userContact"><input type="text" class="form-control" name="userContact" id="userContact" placeholder="Enter Contact" required/>
                    </spring:bind>
                </div>
                <input type="submit" name="submit" id="submit" value="adminHome" class="btn btn-info pull-right">
            </div>
        </form:form>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>