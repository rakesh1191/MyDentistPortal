<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br><br>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Please sign in</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form action="login" method="post">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Enter Username" name="username" type="text" id="username" required>
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="EnterPassword" name="password" id="password" type="password" required>
			    		</div>
						<input type="hidden" name="_csrf" value="${_csrf.token}">
						<input class="btn btn-lg btn-success btn-block" type="submit" name="login" value="Login">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
			<a href="PatientRegistration.html">New Patient ? Sign-up here</a>
		</div>
	</div>
</div>
<br><br>
