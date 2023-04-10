<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<form action="logCustomer" method="post">
	<h1>Welcome to Login page</h1>
	<label for="tbEmailLog">Email:</label>
	<input type="email" name="tbEmailLog" id="tbEmailLog" value=" <%= request.getParameter("tbEmailLog")%> " />
	<br>
	
	<label for="tbPassLog">Password:</label>
	<input type="password" name="tbPassLog" id="tbPassLog" value="<%= request.getParameter("tbPassLog")%>">
	
	<br>
	
	<input type="submit" value="Login">
	</form>
</body>
</html>