<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
<br><br>