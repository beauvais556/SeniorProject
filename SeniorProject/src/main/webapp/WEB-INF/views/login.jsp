<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="wrap">

	<div class="Login">

		<div class="Login-head">
			<h3>Enter Login Information</h3>
		</div>

		<c:if test="${not empty message}">
			<div class="error">${message}</div>
		</c:if>

		<c:if test="${not empty logoutSuccess}">
			<div class="logoutSuccess">${logoutSuccess}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST' style='text-align: center;'>

			<div class="login_box">
				<input type="text" name="username" Placeholder="User name">
			</div>
			<div class="login_box">
				<input type="password" name="password" Placeholder="Password">
			</div>

			<div class="clear"></div>

			<div class="checkbox-grid">
				<div class="inline-group green">
					<div class="clear"></div>
				</div>
			</div>


			<div class="submit-button" style="margin-top: 10px;">
				<input name="submit" type="submit" value="LOGIN">
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</div>

</div>