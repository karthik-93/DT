<%@ page language="java" contentType="text/html" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
  <title>${pageinfo}-Ecommerce Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
  <%@include file="/WEB-INF/views/Header.jsp" %>
  
    

      <div class="container-fluid">
         
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
      
          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item active">
<img src='<c:url value="/images/car01.jpg"/>'/>          
 <div class="carousel-caption">
                  <h3>Shirt With Checked</h3>
                  <p>Brown Shirt</p>  
              </div>
            </div>
      
            <div class="item">
            <spring:url value="/resources/images/shirtssmall2.jpg" var="imgs" /><img style="width:250px";alt="image02" src="${imgs}"/>
              <div class="carousel-caption">
                    <h3>Shirt With Checked</h3>
                    <p>Blue Shirt</p>  
                </div>
            </div>
          
            <div class="item">
            <spring:url value="../resources/images/car03.jpg" var="imgs" /><img style=" width:100%;height: 350px !important;" alt="image03" src="${imgs}"/>
            
              <div class="carousel-caption">
                    <h3>Shirt With Checked</h3>
                    <p>Grey Shirt</p>  
                </div>
            </div>
          </div>
      
          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
      <c:forEach var="product" items="${pList}" varStatus="status">
   <div class = "col-sm-4 col-md-4 ">
      <div class = "thumbnail">
       
          <spring:url value="/resources/images/${product.productId}.jpg" var="imgs" /><img height="150vh" max-width="90%" src="${imgs}"/>
      </div>
      
      <div class = "caption">
         <h4><strong>${product.productName}</strong></h4>
          <h4><strong>${product.price}</strong></h4>

   
         <p>
           <!--   <a href ="prodETAIL?Id=${product.productId}"  class = "btn btn-primary" role = "button">
               VIEW DETAILS
            </a> -->
           
         </p>
         
      </div>
   </div>
   </c:forEach>


          
                
                
        
           
      

</body>
</html>