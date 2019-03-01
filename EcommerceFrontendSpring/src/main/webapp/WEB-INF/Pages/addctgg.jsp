<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style"/><link rel="stylesheet" href="${style}">
<style>
body{
background-image: url("http://www.sonicinfosystem.com/wp-content/uploads/2016/10/Untitled-design-1.png");
}

.container{
background: rgba(255,255,255,0.8); 
}
</style>
</head>
<body>





<div class="container" style="margin-top: 75px">
<form:form modelAttribute="category" action="saveCat" method="POST">

  <div class="form-group">
      <label for="text">Category Name:</label>
    <form:input type="text" class="form-control" path="categoryName" value="${category.categoryName}"/> 
    </div>
  <div class="form-group">
      <label for="text">Category Description:</label>
   <form:input type="text" class="form-control" path="categoryDesc" value="${category.categoryDesc}"/> 
    </div>
    
   
    <input type="submit" class="btn btn-primary" value="SUBMIT">
     
	
				<a href="backadmin"
						class="btn btn-primary" role="button"> Back to Admin Page </a>					
				
</form:form>
  </div>

</body>
</html>
