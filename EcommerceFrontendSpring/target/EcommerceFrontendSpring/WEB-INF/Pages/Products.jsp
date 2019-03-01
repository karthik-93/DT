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
<style>

</style>
</head>
<body>
<div class="row" style="margin-top:25px">

	<c:forEach var="product" items="${pList}" varStatus="status">

	<div class="col-sm-4 col-md-4 ">
		<div class="thumbnail" >
			
			
			<spring:url value="/resources/img/${product.productId}.jpg"
					var="imgs" />
				<img style="height:250px; width: 250px;" src="${imgs}"/>
			
			<div class="caption">
				<h4>
					<strong>${product.price}</strong>
				</h4>
				<h4>
					<strong>${product.productName}</strong>
				</h4>
				<p>
					<a href="productDetails?Id=${product.productId}"
						class="btn btn-primary" role="button"> VIEW DETAILS </a>
				</p>

			</div>
			
		</div>
		</div>

	</c:forEach>
	</div>
	
</body>
</html>