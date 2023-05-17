<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration User Page</title>
</head>
<body>
	<div style = "text-align: center;">
		<h2>Utente Validation Example</h2>
		
		<form:form action="/spring-rest-interno23/validation" method="POST" modelAttribute="user">
			<label for="nome">Nome:</label>
			<form:input path="nome" id="nome"/><br>
			<form:errors path="nome" style="color:red"></form:errors><br>
			
			<label for="email">Email:</label>
			<form:input path="email" id="email"/><br>
			<form:errors path="email" style="color:red"></form:errors><br>
			
			<label for="numFigli">Numero Figli:</label>
			<form:input path="numFigli" id="numFigli" type="number" min="0" value="0"/><br>
			<form:errors path="numFigli" style="color:red"></form:errors><br>
			
			<label for="reddito">Reddito:</label>
			<form:input path="reddito" id="reddito" type="number" min="0" value="0" step="0.01" placeholder="0.0"/><br>
			<form:errors path="reddito" style="color:red"></form:errors><br>
			
			<input type="submit" value="...save!">
			
		</form:form>
	</div>
</body>
</html>