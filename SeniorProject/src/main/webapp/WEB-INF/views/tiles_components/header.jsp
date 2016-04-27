<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	<h3>${welcome}</h3>
	<div class="menu">
		<div class="menu_limit">
			<c:forEach items="${urlMap}" var="url">
				<div id="menu_item"><a href=${url.value}>${url.key}</a></div>
			</c:forEach>
		</div>
	</div>
</div>