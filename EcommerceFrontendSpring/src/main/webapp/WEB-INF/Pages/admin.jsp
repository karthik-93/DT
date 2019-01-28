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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
		
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Admin start your task<span class="pull-right label label-default">:)</span></h1>
    </div>
    <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary" data-toggle="tab">Product</a></li>
                            <li><a href="#tab1category" data-toggle="tab">Category</a></li>
                                                   </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
 <form:form modelAttribute="prod" cssClass="form-horizontal" action="saveProduct" method="POST">
  
  
    <div class="form-group">
    <label class="control-label col-sm-2" for="productName"><h4 style="color:Black;" ><strong>ProductName</strong></h4></label>
    <div class="col-sm-8">
      <form:input class="form-control" path="productName" value="${prod.productName}"/>
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="prodesc"><h4 style="color:Black;" ><strong>Description</strong></h4></label>
    <div class="col-sm-8">
      <form:input class="form-control" path="productDesc" value="${prod.productDesc}"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="price"><h4 style="color:black;"><strong>Price:</strong></h4></label>
    <div class="col-sm-8"> 
   
      <form:input type="number" class="form-control" id ="price" path="price" min="400" max="5000" value="${prod.price }"/>
    </div>
  </div>
     
  
   
    <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-warning" data-toggle="modal" data-target=".bs-example-modal-lg"><strong style="color:Black;">SUBMIT</strong></button>
         <button type="submit" class="btn btn-warning" ><strong style="color:Black;">BACK</strong></button>
    </div>
  </div>
    
</form:form>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    
      <div class="modal-body">
     
      <h1 style="color:black">"${success}"</h1>
     
      </div>
    </div>
  </div>
</div>
</div>
  
   </div>
                        
                    </div>
                </div>
            </div>
         


</body>
</html>