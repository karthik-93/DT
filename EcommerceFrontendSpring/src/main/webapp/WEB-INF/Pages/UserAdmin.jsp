
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Register</title>

<!-- Bootstrap core CSS -->

<!--Pulling Awesome Font -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style"/><link rel="stylesheet" href="${style}">
  <style>



.container{
	background: rgba(255,255,255,0.5); 
}
</style> 
</head>
<body>
<%@include file="header.jsp"%>

<div class="container" >
	
		<form:form modelAttribute="usr" action="saveUsr"
			enctype="multipart/form-data" method="POST">
					
				

				<div class="form-group">
      <label for="text">User Name:</label>
					<form:input type="text" class="form-control" path="username" value="${usr.username}" />
				</div>
				<div class="form-group">
      <label for="text">Password:</label>
					<form:input type="password" class="form-control" path="password" value="${usr.password}" />
				</div>
				<div class="form-group">
      <label for="text">Email ID:</label>
					<form:input type="text" class="form-control" path="emailId" value="${usr.emailId}" />
				</div>
				<div class="form-group">
      <label for="text">Address:</label>
					<form:input type="text" class="form-control" path="customerAddr" value="${usr.customerAddr}" />
				</div>

			
			<br>
			<br>
			<br>
			<input type="submit" class="btn btn-primary" class="btn btn-primary" value="Sign Up">
			
				
<a href="login"
						class="btn btn-primary" role="button"> Login </a>	
				

		</form:form>
</div>
	

</body>
</html>