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
<style type="text/css">
body{
background-image: url("https://web.palfinger.com/extranet/-/media/Global/Background%20Images/Corporate%20Site/palfinger_loadercrane1.jpg?la=en");
}

.container{
background: rgba(255,255,255,0.5); 
}
</style>
</head>
<body>

<div class="container" style="margin-top: 70px">
<form:form modelAttribute="supplier" action="savesupp" method="POST">
  <div class="form-group">
   
				<div class="form-group">
   Supplier name:   <form:input type="text" class="form-control" path="supplierName" value="${supplier.supplierName}"/> 
    
    </div>
				<div class="form-group">
   Supplier Address:   <form:input type="text" class="form-control" path="supplierAddr" value="${supplier.supplierAddr}"/> 
    </div>
    
    </div>
    <input type="submit" class="btn btn-primary" value="SUBMIT">
    
	<a href="backadmin"
						class="btn btn-primary" role="button"> Back to Admin Page </a>					
</form:form>
  </div>


</body>
</html>