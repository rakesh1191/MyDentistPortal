<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"></script>
<!--  jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<title>Take Appointment</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+7D" });
  } );
  </script>

<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>


</head>

<body>

<div class="bootstrap-iso">
 <div class="container-fluid">

<form:form modelAttribute="appointments" role="form">
  <div align="center">

   

    <!-- Form code begins -->
	<div  class="form-group">
      <label for="doctorId">   Doctor's Name :</label>
         <select id="doctorId" name="doctorId" class="form-control" style="width: 200px">
								                <option>Select Doctor</option>
												<c:forEach items="${doctors}" var="d">	
												<c:if test="${doctorid eq d.doctorId}">
												<option value="${d.doctorId}" selected>${d.doctorName}</option>
												</c:if>
												<option value="${d.doctorId}">${d.doctorName}</option>												
												</c:forEach>
												
		 </select>
	</div>
	
	<div  class="form-group">
      <label for="appointmentDate">   Appointment Date :</label>
      
      
      
         <p><input type="text" id="datepicker" name="appointmentDate" value="${appointmentDate}"></p>
      
      
      
	</div>
    <div class="form-group">
		<input type="hidden" value="${userid}" name="userid"/>
		<input type="hidden" value="${doctorid}" name="doctorid"/>
		<c:if test="${slots==null}">
        	<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info" >
      	</c:if>
      </div>
     <!-- Form code ends --> 
   
      </div>    
</form:form>
<c:if test="${slots ne null}">
<form:form>
<div align="center">
<div class="row">
<input type="hidden" value="${doctorid}" name="doctorid"/>
<label for="appointmentDate">   Appointment Time :</label>
   <select id="appointmentTime" name="appointmentTime" class="form-control" style="width: 200px">
								                <option>Select slot</option>
												<c:forEach items="${slots}" var="s">												
												<option value="${s}">${s}</option>
												</c:forEach>
	</select>
	<br><input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info">
</div>
<div><br/>
<a href="/myDentist/appointment/appointment.html?userid=${userid}" class="btn-primary btn-sm active" role="button">Take Different Time Slot</a>
</div>
</div>
</form:form>
</c:if>

  </div>    
 </div>

</body>
</html>