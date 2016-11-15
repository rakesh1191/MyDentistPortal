<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<form action="/myDentist/users/changePassword.html" method="post"  data-toggle="validator">
<div align="center"  style="height: 400px">
<br/>
		<div class="form-group">
		Previous Password : <input style="width: 400px;" type="password" class="form-control" placeholder="Enter previous Password" name="previousPassword"><br/>
		</div>
 	<div class="form-group">		
        <input type="password"  style="width: 400px;" data-minlength="6" class="form-control" name="inputPassword" id="inputPassword" placeholder="Password" required>
        <div class="help-block">Minimum of 6 characters</div>
      </div>
      <div class="form-group">
        <input type="password"  style="width: 400px;" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" data-match-error="Whoops, these don't match" placeholder="Confirm" required>
        <div class="help-block with-errors"></div>
      </div>
<br/><input type="submit" name="submit" id="submit">
<input type="hidden" name="userid" value="${userid}">
</div>
</form> 

</body>
<%@ include file="/WEB-INF/footer.jsp" %>
</html>