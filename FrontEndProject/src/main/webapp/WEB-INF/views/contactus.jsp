<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<spring:url value="/resources/css/contact.css" var="style"/> <link rel="stylesheet" href="${style}">
<title>${pageinfo}-Ecommerce Cart</title>
</head>
<body>
<%@include file="/WEB-INF/views/Header.jsp" %>
<div class="container">

<div class="form-sec">
  <h4>Contact form</h4>
  
 <form name="qryform" id="qryform" method="post" action="mail.php" onsubmit="return(validate());" novalidate="novalidate">
    <div class="form-group">
      <label>Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    <div class="form-group">
      <label>Email:</label>
      <input type="email" class="form-control" id="name" placeholder="Enter Email" name="email">
    </div>
    
    <div class="form-group">
      <label>Phone No.:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone no." name="phone">
    </div>
	<div class="form-group">
      <label>Subject:</label>
      <input type="text" class="form-control" id="name" placeholder="Subject" name="subject">
    </div>
	 
	<div class="form-group">
      <label>Issues/query:</label>
      <textarea name="issues" class="form-control" id="iq" placeholder="Enter your Issues/query"></textarea>
    </div>
	
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  </div>


</div>
</body>
</html>