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
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style"/><link rel="stylesheet" href="${style}">
<style>
body{
background-image: url("https://images.unsplash.com/photo-1512436991641-6745cdb1723f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
}


.container{
	background: rgba(255,255,255,0.5); 
}
</style>
</head>
<body>


	<div class="container" >
	
		<form:form modelAttribute="product" action="saveProd"
			enctype="multipart/form-data" method="POST">
					
				

				<div class="form-group">
      <label for="text">Product Name:</label>
					<form:input type="text" class="form-control" path="productName" value="${product.productName}" />
				</div>
				<div class="form-group">
      <label for="text">Product Description:</label>
					<form:input type="text" class="form-control" path="productDesc" value="${product.productDesc}" />
				</div>
				<div class="form-group">
      <label for="text">Product Price:</label>
					<form:input type="text" class="form-control" path="price" value="${product.price}" />
				</div>
				<div class="form-group">
      <label for="text">Product Stock:</label>
					<form:input type="text" class="form-control" path="stock" value="${product.stock}" />
				</div>

			<div>
				<label for="img" class="col-sm-2 control-label">Upload
					Image:</label>
				<div class="col-sm-8">
					<form:input path="pimage" value="${product.pimage}" type="file"
						cssClass="form-control" />
				</div>
			</div>
			<br>
			<br>
			<br>
			<input type="submit" class="btn btn-primary" class="btn btn-primary" value="SUBMIT">
			
			
<a href="backadmin"
						class="btn btn-primary" role="button"> Back to Admin Page </a>					

		</form:form>
</div>
</body>
</html>