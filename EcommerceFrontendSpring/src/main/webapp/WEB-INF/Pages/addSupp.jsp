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
<%@include file="header.jsp"%>
<%@include file="Admintask.jsp"%>

<div class="container">
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
    <a href="supTab?Id=${supplier.supplierId}"
						class="btn btn-primary" role="button"> SHOW LIST </a>
</form:form>
  </div>


</body>
</html>