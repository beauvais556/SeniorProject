<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
	<LINK REL="SHORTCUT ICON" HREF="resources/html/images/icon.png">
	<link href="resources/html/css/style.css" rel='stylesheet' type='text/css' />
	<link href="resources/html/css/layout.css" rel='stylesheet' type='text/css' />
	<link href="resources/html/css/template.css" rel='stylesheet' type='text/css' />
	<link href="resources/html/css/tables.css" rel='stylesheet' type='text/css' />
</head>

<body>
	<c:set var="user" scope="session" value="${user}"/>
    <c:set var="title" scope="session" value="${title}"/>
    <c:set var="welcome" scope="session" value="${welcome}"/>

    <div class="main">
		<div class="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		
		<div id="menu">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		
		<div id="body">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		
		<div id="footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>  
</html>