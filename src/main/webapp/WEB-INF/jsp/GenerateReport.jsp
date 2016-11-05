<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Report</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row" >
        <form:form modelAttribute="report">
            <div class="col-sm-10" >
                <div class="well well-sm" align="center"><strong>Doctor Registration Form</strong></div>
                <div class="form-group">
                    <label for="diseaseType">Disease Type : </label>
                    <form:input path="diseaseType"/>
                       
                </div>
                <div class="form-group">
                    <label for="allergies">Allergies : </label>
                    <form:input path="allergies"/>
                    
             
                </div>
                <div class="form-group">
                    <label for="labResult">labResult : </label>
                    <form:input path="labResult"/>
                   
                </div>
                <div class="form-group">
                    <label for="immunizations">Immunizations : </label>
                    <form:input path="Immunizations"/>
                   
                </div>
                 <div class="form-group">
                    <label for="medicines">Medicines : </label>
                     <form:input path="medicines"/>
                   
                </div>
                 <div class="form-group">
                    <label for="doctorComments">doctorComments : </label>
                     <form:input path="doctorComments"/>
                  
                </div>
                 <div class="form-group">
                    <label for="billingInfo">Billing Information : </label>
                     <form:input path="billingInfo"/>
                </div>
                <input type="hidden" name="Patientid" id="Patientid" value="${Patientid}">
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>