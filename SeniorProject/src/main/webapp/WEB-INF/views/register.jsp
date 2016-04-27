<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false"%>

		<div class="wrap">
			<div class="Login">
				<div class="Login-head">
					<h3>Register</h3>
				</div>

				<form:form method="POST" action="register"  style="text-align:center;">

				<div class="register_box">
					<form:input type="text" placeholder="User Id" path="userId" />
				</div>
				<div class="register_box">
					<form:input type="text" placeholder="First Name" path="firstName" />
				</div>
				<div class="register_box">
					<form:input type="text" placeholder="Email" path="email" />
				</div>
				<div class="register_box">
					<form:input type="password" placeholder="Password" path="password" />
				</div>

			<div class="Remember-me">
				<div class="submit-button" style="margin-top: 10px;">
					<input type="submit" value="Register" />
				</div>
				<div class="clear"></div>
			</div>

		</form:form>
	</div>
</div>