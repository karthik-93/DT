<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User-Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
label {
	display: inline-block;
	width: 150px;
}
</style>
</head>
<body>
	<%@include file="navigate.jsp"%>
	
<form name='loginForm' action="<c:url value='j_spring_security_check'/>" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="usernam" id='username'></td>
					</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name="password" id="password" /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>
		
        

</body>
</html>