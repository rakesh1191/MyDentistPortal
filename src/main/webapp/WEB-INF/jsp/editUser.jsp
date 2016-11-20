
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<br>
<br>
<div id="collapse3" class="panel-collapse collapse">
	<form:form>
		<table border="1">
			<tr>
				<th>User ID</th>
				<th>User Email</th>
				<th>Type</th>
				<th></th>
			</tr>

			<tr>
				<td>${alluser.userId}</td>
				<td>${alluser.userEmail}</td>
				<td>${alluser.userType}</td>
				<td><c:if test="${alluser.enabled eq true}">
						<input type="submit" name="Disable" value="Disable">
					</c:if> <c:if test="${alluser.enabled eq false}">
						<input type="submit" name="Enable" value="Enable">
						<input type="hidden" value="${userid}" id="userid" name="userid">
					</c:if></td>

			</tr>

		</table>
	</form:form>
</div>

<br>
<br>