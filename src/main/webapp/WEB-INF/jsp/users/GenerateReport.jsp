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
<%@ include file="/WEB-INF/header.jsp" %>
<div class="container">
    <div class="row" >
        <form:form modelAttribute="report">
            <div class="col-sm-10" >
                <div class="well well-sm" align="center"><strong>Doctor Registration Form</strong></div>
                <div class="form-group">
                   <table>
                   	<tr>
                   		<td><label for="diseaseType">Disease Type : </label></td>
                   		<td><form:input path="diseaseType"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="allergies">Allergies : </label></td>
                   		<td><form:input path="allergies"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="labResult">labResult : </label></td>
                   		<td><form:input path="labResult"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="immunizations">Immunizations : </label></td>
                   		<td><form:input path="Immunizations"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="medicines">Medicines : </label></td>
                   		<td><form:input path="medicines"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="doctorComments">doctorComments : </label></td>
                   		<td><form:input path="doctorComments"/></td>
                   	</tr>
                   	<tr>
                   		<td><label for="billingInfo">Billing Information : </label></td>
                   		<td><form:input path="billingInfo"/></td>
                   	</tr>
                   </table>
             
                <input type="hidden" name="Patientid" id="Patientid" value="${Patientid}">
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info">
            </div></div>
        </form:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>