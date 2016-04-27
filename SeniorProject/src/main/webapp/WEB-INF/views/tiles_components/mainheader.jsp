<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="POST" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<script>
		function logOut() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<div class="head">
	<h1>${title}</h1><img src="resources/html/images/icon.png" width="60px"><br><br>
	<a>Welcome ${user.firstName} ${user.lastName}!</a>
    <div class="menu">
		<div class="menu_limit">
					<div id="menu_item"><a href="#">About Us</a></div>
					<div id="menu_item"><a href="#">Contact Us</a></div>
					<div id="menu_item"><a href="#">Help</a></div>
					<div id="menu_item"><a href="#">Profile</a></div>
                    <div id="menu_item"><a href="javascript:logOut()">Logout</a></div>
		</div>
	</div>
</div>