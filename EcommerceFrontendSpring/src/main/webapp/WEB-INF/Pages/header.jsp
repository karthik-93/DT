
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title> Ecommerce Store </title>

<meta name=viewport content="width=device-width , intial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div style="bg-color:red">
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
           <div class="navbar-header"> 
               <a class="navbar-brand" href="#"></a>
           </div>

      <c:if test="${!sessionScope.loggedIn}">
           <ul class="nav navbar-nav"> 
             <li> <a href="<c:url value="/home" />"> HOME </a></li>
             <li> <a href="<c:url value="/login" />"> LOGIN  </a></li>
             <li> <a href="<c:url value="/register" />"> REGISTER </a></li>
             <li> <a href="<c:url value="/aboutus" />"> ABOUT US </a></li>
             <li> <a href="<c:url value="/contactus" />"> Contact US </a></li>
             <li> <a href="<c:url value="#" />"> Ecommerce-Store </a></li>
             </ul>
           </c:if>
           <c:if test="${sessionScope.loggedIn}">
           		<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
           			<ul class=" nav navbar-nav">
             			<li> <a href="<c:url value="/product" />"> MANAGE PRODUCT </a></li>
            			 <li> <a href="<c:url value="/category" />"> MANAGE CATEGORY </a></li>
             			<li> <a href="<c:url value="/productDisplay" />"> PRODUCT CATALOG </a></li>
             			<li> <a href="<c:url value="/cart" />"> CART </a></li>
           					</ul>
           						</c:if>
           		<c:if test="${sessionScope.role=='ROLE_USER'}">
           			<ul class="nav navbar-nav">
           			<li> <a href="<c:url value="/home" />"> Home </a></li>
             			<li> <a href="<c:url value="/productDisplay" />"> PRODUCT CATALOG </a></li>
           					  			<li> <a href="<c:url value="/cart" />"> CART </a></li>
           					</ul>
           						</c:if>
           </c:if>						
           
         </div> 
         <c:if test="${sessionScope.loggedIn}">
<div class="nav navbar-nav navbar-right">

<font color="white" face="calibri" size="2">Welcome: ${sessionScope.username}</font>
<a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a> 
</div>
</c:if>
     </nav>         
 </div> 
  

</div>
</body>

</html>