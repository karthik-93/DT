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
body{
background-image: url("https://images.unsplash.com/photo-1512436991641-6745cdb1723f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
}


.container{
	background: rgba(255,255,255,0.9); 
}


</style>
</head>
<body>
<%@include file="header.jsp"%>
<h2 style="color: #4262AE;" align="center">Product List</h2>
<a href="backadmin" class="btn btn-primary btn-lg" role="button"> Back </a>
 <a href="AddPro" class="btn btn-primary btn-lg pull-right" role="button" align="right"> Add New </a>
	<div class="container">
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Product Description</th>
					<th>Product Image</th>
					<th class="col-sm-3">Action</th>
				</tr>
			</thead>
		
			<c:forEach var="product" items="${pList}" varStatus="status">
		

			<tbody>
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.productDesc}</td>
					<td><spring:url value="/resources/img/${product.productId}.jpg"
					var="imgs" /><img style="min-height:70px; width:50%;" src="${imgs}" class="img-responsive"  />
					</td>
					<td><a href="editProd?Id=${product.productId}"
						class="btn btn-primary" role="button"> Edit </a>&nbsp
					  <a href="deletepro?Id=${product.productId}"
						class="btn btn-primary" role="button"> Delete </a>
					</td>
			</tbody>

			</c:forEach>	
			




		</table>
	</div>
</body>
</html>