<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<spring:url value="/resources/css/wired.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/home.css" var="style"/><link rel="stylesheet" href="${style}">
<spring:url value="/resources/css/HomePage.css" var="style"/><link rel="stylesheet" href="${style}">

<style>
body{
background-image:url("https://as1.ftcdn.net/jpg/01/57/34/62/500_F_157346244_A6Oml9kXsQdK3WaVVg91UnzheU0YeFpe.jpg");
  background-repeat: no-repeat;
 background-size: 100%;
}
.container {
  position: relative;
  width: 100%;
}

.image {
  display: block;
  width: 250px;
  height: 200px;
  
}

.overlay {
  position:absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 275px;
  height: 210px;
  opacity: 0;
  transition: .5s ease;
  background-color: #708090;
}

.container:hover .overlay {
  opacity:0.92;
}


.text {
  color:yellow;
  background-color: #708090;
  font-size: 20px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  text-align: center;
}
.dropdown-menu{
background-color:#2F4F4F;
width: 100px;
height: 80px;
}
.dropdown-item{
color:white;
font-size: small;
width: 100px;
}
h2{
font-family: sans-serif;
font-style: italic;
font-style: bold;
color: #676A78;
font-size: 30px;
}

</style>

</head>
<body>
<div class ="container">
<div class="row" style="margin-top:100px">
<div class="col-md-4 col-sm-4 col-xs-4">
  <img src="https://www.hitechos.com/wp-content/uploads/2017/03/ecommerce-data-entry-company-a-product-management-specialist-for-online-retailers.jpg" alt="Avatar" class="image">
  <div class="overlay">
    <div class="text">
  <button type="button" class="btn btn-primary dropdown-toggle btn-lg" data-toggle="dropdown" >
    Manage Products
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="AddPro">Add Products</a>
    <a class="dropdown-item" href="showallpro">List Products</a>
  </div>
</div>
</div>
<h2>Manage Products</h2>

</div>
 

<div class="col-md-4 col-sm-4 col-xs-4">
  <img src="data:image/png;base64,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" alt="Avatar" class="image">
  <div class="overlay">
    <div class="text">
  <button type="button" class="btn btn-primary dropdown-toggle btn-lg" data-toggle="dropdown">
    Manage Supplier
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="AddSupp">Add Supplier</a>
    <a class="dropdown-item" href="showallsup">List Supplier</a>
  </div>
</div></div>
  <h2>Manage Supplier</h2>
  
  </div>

<div class="col-md-4 col-sm-4 col-xs-4">
  <img src="https://wiredimpact.com/wp-content/uploads/2012/02/better-blog-categories.jpg" alt="Avatar" class="image">
  <div class="overlay">
    <div class="text">
  <button type="button" class="btn btn-primary dropdown-toggle btn-lg" data-toggle="dropdown">
    Manage Category
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="addctg">Add Category</a>
    <a class="dropdown-item" href="showallcat">List Category</a>
  </div>
</div>
</div>

<h2>Manage Category</h2>
</div>
  </div>

 </div>

</body>
</html>
