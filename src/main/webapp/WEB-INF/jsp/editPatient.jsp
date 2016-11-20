
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<div class="container">
	<div class="row">
		<form:form modelAttribute="user">
			<div class="col-sm-10">
				<div class="well well-sm" align="center">
					<strong>Update Information</strong>
				</div>
				<table class="table table-bordered">
					<tr>
						<td><label for="userContact"
							style="font-size: 20px; color: black; align:center;">Contact</label></td>
						<td><form:input path="userContact"
								style="width:300px; font-size:20px;" /></td>
					</tr>
					<tr>
						<td><label for="userEmail"
							style="font-size: 20px; color: black; align:center;">Email</label></td>
						<td><form:input path="userEmail"
								style="width:300px; font-size:20px;" /></td>
					</tr>
					<tr>
						<td><label for="userAddress"
							style="font-size: 20px; color: black; align:center;">Address</label></td>
						<td><form:input path="userAddress"
								style="width:300px; font-size:20px;" /></td>
					</tr>
				</table>
				<br> <input type="submit" name="submit" id="submit"
					value="Submit" class="btn btn-info">
			</div>
		</form:form>
	</div>
</div>
<br>
<br>
