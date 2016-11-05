<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
 <div id="collapse3" class="panel-collapse collapse">
        <form:form>
         <table border="1">
        	<tr><th>User ID</th><th>User Email</th><th>Type</th><th></th></tr>
        	
        	<tr>
        	<td>${alluser.userId}</td>
        	<td>${alluser.userEmail}</td>
        	<td>${alluser.userType}</td>
        	<td>
        	<c:if test="${alluser.enabled eq true}">
        	<input type="submit" name="Disable" value="Disable">
        	</c:if>
        	<c:if test="${alluser.enabled eq false}">
        	<input type="submit" name="Enable" value="Enable">
        	<input type="hidden" value="${userid}" id="userid" name="userid">
        	</c:if>
        	</td>
        	
        	</tr>        
        	
        </table>
        </form:form>
      </div>
</body>
</html>