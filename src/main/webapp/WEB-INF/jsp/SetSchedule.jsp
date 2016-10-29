<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Weekly Schedule</title>
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
<form:form modelAttribute="setdate" role="form">
  <div class="row">

   <div class="col-md-6 col-sm-6 col-xs-12">

    <!-- Form code begins -->
    
    <p>Date: <input type="text" id="datepicker" name="availableDate"></p>
  
    <div class="form-group">
		<input type="hidden" value="${userid}" name="userid"/>
        <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
      </div>
     <!-- Form code ends --> 

    </div>
      </div>   
</form:form>

<form:form>
  <input type="checkbox" name="slot" value="slot910">9-10<br>
  <input type="checkbox" name="slot" value="slot1011"> 10-11<br>
  <input type="checkbox" name="slot" value="slot1112"> 11-12<br>
  <input type="checkbox" name="slot" value="slot121"> 12-1<br>
  <input type="checkbox" name="slot" value="slot12"> 1-2<br>
  <input type="checkbox" name="slot" value="slot23"> 2-3<br>
  <input type="checkbox" name="slot" value="slot34"> 3-4<br>
  <input type="checkbox" name="slot" value="slot45"> 4-5<br>
  <input type="submit" value="Submit">
</form:form>
  </div>    
 </div>

</body>
</html>