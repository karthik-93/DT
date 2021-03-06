<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Product Details</title>
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
</head>
<body>
<%@include file="header.jsp"%>

	<div class="container">
		<h2>Product List</h2>
		<table class="table" colspan="4">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Product Description</th>
					<th>Product Image</th>
					<th class="col-md-8">Action</th>
				</tr>
			</thead>
		
		

			<tbody>
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td>${product.productDesc}</td>
					<td><spring:url value="/resources/img/${product.productId}.jpg"
					var="imgs" /><img style="min-height:70px; width:50%;" src="${imgs}" class="img-responsive"  />
					</td>
					 
					<td class="col-md-8"><a href="editProd?Id=${product.productId}"
						class="btn btn-primary" role="button"> Edit </a>
					 <a href="deletepro?Id=${product.productId}"
						class="btn btn-primary" role="button"> Delete </a>
					</td>
			</tbody>

			




		</table>
	</div>
	
</body>
</html>