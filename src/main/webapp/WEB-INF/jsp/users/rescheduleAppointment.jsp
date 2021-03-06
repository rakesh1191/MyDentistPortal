<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"></script>
<!--  jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : 0,
			maxDate : "+7D"
		});
	});
</script>
<div class="bootstrap-iso">
	<div class="container-fluid">
		<div class="row">
			<!-- ------------------------------------------------------------------------------------------------- -->

			<!-- ------------------------------------------------------------------------------------------------- -->
			<form:form modelAttribute="appointments">

				<div class="col-md-6 col-sm-6 col-xs-12">

					<!-- Form code begins -->

					<div class="form-group">
						<!-- Date input -->
						<label class="control-label" for="date"></label>
						<form:input path="appointmentId" type="hidden" />
					</div>



					<div class="form-group">
						<!-- Date input -->



						<label for="appointmentDate"> Previous Date :</label>
						<form:input path="appointmentDate" disabled="true" />
					</div>
					<div class="form-group">
						<label for="appointmentTime">Appointment Time :</label> <select
							id="appointmentTime" name="appointmentTime" class="form-control"
							style="width: 200px">
							<option>Select slot</option>
							<c:forEach items="${slots}" var="s">
								<option value="${s}">${s}</option>
							</c:forEach>
						</select>
					</div>
					<input type="hidden" name="userid" value="${userid.userId}" /> <input
						type="hidden" name="appid" value="${appointments.appointmentId}" />
					<div>
						&nbsp; <br /> <input type="hidden" name="doctorid" id="doctorid"
							value="${doctorid}"> <input
							class="btn btn-primary btn-lnk" type="Submit" value="Save">
					</div>

					<!-- Form code ends -->

				</div>

			</form:form>
		</div>
	</div>
</div>
<br>
<br>