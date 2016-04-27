<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@page session="false"%>

<div class="wrap">
	<div class="Login">
		<div class="Login-head">
			<h3>Submit a Request</h3>
		</div>

		<form:form method="POST" action="request" style="text-align:center;">

			<div class="register_box">
				<form:input type="text" placeholder="First Name" path="firstName" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Last Name" path="lastName" />
			</div>
			<div class="login_box">
				<form:input type="text" placeholder="Address" path="address" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Phone" path="phone" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Email" path="email" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Employer" path="employer" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Salary" path="salary" />
			</div>
			<div class="login_box">
				<form:input type="text" placeholder="Requested Amount"
					path="requestedAmt" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Date of Birth" path="dob" />
			</div>
			<div class="register_box">
				<form:input type="text" placeholder="Social Security Number"
					path="ssn" />
			</div>

			<div class="Remember-me" style="margin-top: 10px;">
				<div class="p-container">
					<input type="checkbox" name="checkbox"><i></i> I agree to
					the Terms and Conditions
					<div class="clear"></div>
				</div>

				<div class="submit-button" style="margin-top: 5px;">
					<input type="submit" value=" Submit Request" />
				</div>
				<div class="clear"></div>
			</div>

		</form:form>
	</div>
</div>