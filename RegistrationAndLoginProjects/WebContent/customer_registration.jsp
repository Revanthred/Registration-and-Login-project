<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>
	<h1>Customer registration page</h1>
	
	<form action="regCustomer" method="post">
		Name :<input type="text" name="tbName" id="tbName"/>
		<br>
		
		Email :<input type="email" name="tbemail" id="tbemail"/>
		<br>
		
		Mobile :<input type="tel" name="tbMbl" id="tbMbl"/>
		<br>
		
		Password :<input type="password" name="tbPassword" id="tbPassword"/>
		<br>
		
		
		State:
		<select name="ddlstates">
			<option value="">--Select--</option>
			
			<option value="Karnataka">KA</option>
			<option value="Andra">AP</option>
			<option value="Telangana">TS</option>
			<option value="UttarPradesh">UP</option>
			
		</select>
		<br>
		<input type="submit" value="Register">
	</form>
	
</body>
</html>