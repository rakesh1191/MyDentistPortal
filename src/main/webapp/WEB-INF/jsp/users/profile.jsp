<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
  <h1>Welcome</h1>
  <br><br>
   <security:authorize access="hasAnyRole('DOCTOR')">
<div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse1"><h3>Profile</h3></a>
        </h5>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body"></div>
        <div class="panel-footer"><a href="/myDentist/users/doctorProfile.html?userid=${userid}">View/Edit Profile</a>
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
        <div class="panel-footer"><a href="/myDentist/users/SetSchedule.html?userid=${userid}">setSchedule</a></div>
      </div>
    </div>
 
<div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse4"><h3>View All Appointments</h3></a>
        </h5>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">Check All your appointments here</div>
        <div class="panel-footer">
        	<table border="1">
        <tr>
        <th>Appointment ID</th><th>Appointment Date</th><th>Appointment Time</th>
        <th>PatientID</th>
        <th>Patient Name</th>
        <th>Operations</th>
        </tr>
  		<c:forEach items="${appointments}" var="apt">
        <c:if test="${apt.doctorId.doctorId eq doctorid}" >
        <tr>
        <td>${apt.appointmentId}</td>
		<td>${apt.appointmentDate}</td>
		<td>${apt.appointmentTime}</td>
		<td>${apt.userId.userId}</td>	
        <td>${apt.userId.username}</td>
		<td><a href="/myDentist/users/GenerateReport.html?userid=${apt.userId.userId}&doctorid=${doctorid}&user=${userid}">Create/View Report</a></td>

		</tr>        
        </c:if>
        </c:forEach>
  	    </table>
        </div>
      </div>
  </div>
    </security:authorize>
        <security:authorize access="hasAnyRole('USER')">
          <div class="panel-group">
  <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse2"><h4>Manage your Appointments</h4></a>
        </h5>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        Haven't schedule your appointment! Here's your chance to do it!
        <a href="/myDentist/appointment/appointment.html?userid=${userid}">Appointment</a>
        <br><br>
  		View All my Appointments
  	    </div>
        <div class="panel-footer"></div>
      	<table class="table table-striped">
        <thead>
        <tr>
        <th>Appointment ID</th>
        <th>Appointment Date</th>
        <th>Appointment Time</th>
        <th>Doctor ID</th>
  		<th>Doctor Name</th>  
        <th>Operations</th>
        </tr></thead>
  		<c:forEach items="${appointments}" var="apt">
        <c:if test="${apt.userId.userId eq userid}" >
        <tbody>
        <tr>
        <td>${apt.appointmentId}</td>
        <td>${apt.appointmentDate}</td>
        <td>${apt.appointmentTime}</td>
        <td>${apt.doctorId.doctorId}</td>
        <td>${apt.doctorId.doctorName}</td>
        <td><a href="/myDentist/users/rescheduleAppointment.html?id=${apt.appointmentId}&doctorid=${apt.doctorId.doctorId}&&appointmentDate=${apt.appointmentDate}">Edit My appointment</a></td>
        </tr>  
        </tbody>      
        </c:if>
        </c:forEach>
  	    </table>
      </div>
    </div>
  
<div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse3"><h4>Update My Info!</h4></a>
        </h5>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        <table class="table table-striped">
        <tbody>
        <tr>
        <th>${users.userId}</th>
        <th>${users.username}</th>
        <th>${users.userEmail}</th>
        <th>${users.userAddress}</th>
        <th>${users.userContact}</th>
        </tr>
        </tbody>
        </table>
        </div>
        <div class="panel-footer"><a href="/myDentist/editPatient.html?userid=${userid}">Edit Profile Here</a></div>
      </div>
    </div>

  
  <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse4"><h4>View Reports</h4></a>
        </h5>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">Haven't gone through the reports? Go through it then!</div>
        <div class="panel-footer">Want to check the Lab reports?</div>
      </div>
  </div>
  <div class="panel panel-default">
      <div class="panel-heading">
        <h5 class="panel-title">
          <a data-toggle="collapse" href="#collapse5"><h4>Payments</h4></a>
        </h5>
      </div>
      <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">Pay your all th bills here!</div>
        <div class="panel-footer">Here's the link for paying the bills.</div>
      </div>
    </div>
</div>
    </security:authorize>
    <security:authorize access="hasAnyRole('ADMIN')">
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
          <a data-toggle="collapse" href="#collapse3"><h4>Enable/Disable Users</h4></a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
         <table border="1">
        	<tr><th>User ID</th><th>User Email</th><th>Type</th><th></th></tr>
        	<c:forEach items="${alluser}" var="usr">
        	<tr>
        	<td>${usr.userId}</td>
        	<td>${usr.userEmail}</td>
        	<td>${usr.userType}</td>
        	<td><a href="/myDentist/users/editUser.html?userid=${usr.userId}">Enable/Disable User</a></td>
        	</tr>        
        	</c:forEach>
        </table>
      </div>
    </div>
    

    </security:authorize>
    
    
</div>

<form action="logout" method="post">

<div class="container">
  <a href="<c:url value='/logout'/>" class="btn btn-info" role="button">Logout</a>
</div>
</form>

</body>
</html>