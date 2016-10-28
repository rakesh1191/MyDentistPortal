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
  <h1>Welcome to Home Page</h1>
  <br><br>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1"><h4>Add Doctor</h4></a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">Want to add new Doctor? Add it then</div>
        <div class="panel-footer"><a href="doctorRegistration.html">Add New Doctor</a>
        </div>
      </div>
    </div>
  </div>
  
  <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse2"><h4>View All Appointment Records</h4></a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">Appointment records</div>
        <div class="panel-footer">
        <table border="1">
        	<tr><th>Appointment ID</th><th>Patient ID</th><th>Doctor ID</th><th>Appointment Date</th><th>Appointment Time</th></tr>
        	<c:forEach items="${appointments}" var="apt">
        	<tr>
        	<td>${apt.appointmentId}</td>
        	<td>${apt.userId.userId}</td>
        	<td>${apt.doctorId.doctorId}</td>
        	<td>${apt.appointmentDate}</td>
        	<td>${apt.appointmentTime}</td>
        	</tr>        
        	</c:forEach>
        </table>
        </div>
      </div>
    </div>
  
  <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse3"><h4>View Patient Info</h4></a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">---</div>
        <div class="panel-footer">---</div>
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