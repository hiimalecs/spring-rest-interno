<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%-- <c:url value="/js/code.js"/> --%>
<%-- <c:url value="/style/skeleton.css"/> --%>
<script type="text/javascript" src="<c:url value="/js/code.js"/>"></script>
<link href="<c:url value="/style/skeleton.css"/>" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Test Ajax Integration</title>
</head>
<body>
	<div class="container">
		<h2>Test Ajax in Spring!</h2>
		
		<button onclick="getAllUser()">Get All</button>
		
		<section id="all-res"></section>
	</div>
</body>
</html>