<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
 <style>
 label{
        display: inline-block ;
        width:150px;
    }
    </style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row centered-form">
			
				<div class="panel panel-default">
					<div class="panel-heading">Register New User</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<label for="name">First Name:</label>
									<input type="text" placeholder="Firstname">
								</div>
							</div>	
							<br>
							<div class="row">	
								<div class="col-xs-12 col-sm-12 col-md-12">
								<label for="name">Last Name:</label>
									<input type="text" placeholder="Lastname">
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
								<label for="name">Email Address:</label>
								<input type="email" placeholder="Email Address">
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<label for="name">Password</label>
									<input type="password" placeholder="Password">
								</div>
							</div>
							</br>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<label for="name">Confirm Password:</label>
									<input type="password" placeholder="Confirm Password">
								</div>
							</div>
							</br>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<input type="submit" value="Register">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>