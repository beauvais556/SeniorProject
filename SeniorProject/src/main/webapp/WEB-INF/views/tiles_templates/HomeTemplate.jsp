<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<LINK REL="SHORTCUT ICON" HREF="resources/html/images/icon.png">
	<link href="resources/html/css/style.css" rel='stylesheet' type='text/css' />
	<link href="resources/html/css/layout.css" rel='stylesheet' type='text/css' />
</head>

<body>
	<c:set var="urlMap" value="${urlMap}"/>
	
	<div class="main">
		<!-- Header -->
		<tiles:insertAttribute name="header" />

		<!-- Body Page -->
		<tiles:insertAttribute name="body" />
	</div>
</body>

</html>