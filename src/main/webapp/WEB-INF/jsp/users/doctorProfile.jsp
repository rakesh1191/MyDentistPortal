<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<br>
<br>
<div class="container">
	<div class="row">
		<form:form modelAttribute="doctors">
			<div class="col-sm-10">
				<div class="well well-sm" align="center">
					<strong>Doctor Registration Form</strong>
				</div>
				<div class="form-group">
					<label for="doctorName">Doctor Name</label>
					<spring:bind path="doctorName">
						<input type="text" class="form-control" name="doctorName"
							id="doctorName" placeholder="Enter name" required>
					</spring:bind>
				</div>
				<div class="form-group">
					<label for="designation">Designation</label>
					<spring:bind path="designation">
						<input type="text" class="form-control" name="designation"
							id="designation" placeholder="Enter designation" required>

					</spring:bind>
				</div>
				<div class="form-group">
					<label for="specialization">specialization</label>
					<spring:bind path="specialization">
						<input type="text" class="form-control" name="specialization"
							placeholder="Enter specialization" id="specialization" required>
					</spring:bind>
				</div>

				<input type="submit" name="submit" id="submit" value="Submit"
					class="btn btn-info">
			</div>
		</form:form>
	</div>
</div>
<br>
<br>
