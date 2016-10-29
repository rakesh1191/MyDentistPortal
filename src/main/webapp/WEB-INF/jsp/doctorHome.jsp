<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Home Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h1>Welcome to Home page</h1>
  <br><br>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse1"><h3>Profile</h3></a>
        </h5>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body"></div>
        <div class="panel-footer"><a href="doctorProfile.html?userid=${userid}">View/Edit Profile</a>
        </div>
      </div>
    </div>
  </div>
 
  <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse3"><h3>Make yourself available for Appointments</h3></a>
        </h5>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">Set your appointment schedule for the next one week</div>
        <div class="panel-footer"><a href="SetSchedule.html?userid=${userId}">setSchedule</a></div>
      </div>
    </div>
 
  <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse3"><h3>View Patient Info</h3></a>
        </h5>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">Want to check out patient's medical information?</div>
        <div class="panel-footer">Here's the link for it.</div>
      </div>
    </div>
    
</div>
<form action="logout" method="post">
<input name="_csrf" type="hidden" value="${_csrf.token}"/>
<div class="container">
  <input type="submit" class="btn btn-lg btn-info collapsed" value="Logout" >
</div>
</form>
</body>
</html>