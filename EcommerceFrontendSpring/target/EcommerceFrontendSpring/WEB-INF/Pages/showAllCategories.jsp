<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style" />
<link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style" />
<link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style" />
<link rel="stylesheet" href="${style}">
<style>
body
{
background-image: url("http://www.sonicinfosystem.com/wp-content/uploads/2016/10/Untitled-design-1.png");
}

.container{
background: rgba(255,255,255,0.9); 
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
<h2 align="center" >Category List</h2>
<a href="backadmin" class="btn btn-primary btn-lg" role="button"> Back </a>
 <a href="AddSupp" class="btn btn-primary btn-lg pull-right" role="button" align="right"> Add New </a>
	<div class="container">
		
		<table class="table">
			<thead>
				<tr>
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Action</th>
				</tr>
			</thead>
		
			<c:forEach var="category" items="${cList}" varStatus="status">
		

			<tbody>
				<tr>
					<td>${category.categoryId}</td>
					<td>${category.categoryName}</td>
					<td>${category.categoryDesc}</td>
					<td><a href="editcat?Id=${category.categoryId}"
						class="btn btn-primary" role="button"> Edit </a>
					  <a href="deletecat?Id=${category.categoryId}"
						class="btn btn-primary" role="button"> Delete </a>
					</td>
			</tbody>

			</c:forEach>	
			




		</table>
	</div>
</body>
</html>