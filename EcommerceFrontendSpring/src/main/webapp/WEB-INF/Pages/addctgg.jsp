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
</head>
<body>

<%@include file="Admintask.jsp"%>
<%@include file="header.jsp"%>



<div class="container">
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
     <a href="catTab?Id=${category.categoryId}"
						class="btn btn-primary" role="button"> SHOW LIST </a>
	<a href="showallcat" class="btn btn-primary"
				role="button"> SHOW LIST Of All Categoriess</a>
</form:form>
  </div>

</body>
</html>
