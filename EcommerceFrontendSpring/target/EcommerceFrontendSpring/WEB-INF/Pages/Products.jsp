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
<style >
.thumbnail {
    max-height:250px;
    max-width:100%;
}


</style>
</head>
<body>

	<c:forEach var="product" items="${pList}" varStatus="status">

		<div class="col-sm-4 col-md-4 ">
		<!-- <div class="row display-flex"> -->
			<div class="thumbnail">


				<spring:url value="/resources/img/${product.productId}.jpg"
					var="imgs" />
				<img style="min-height:100px; width:50%;" src="${imgs}" class="img-responsive"  />
			</div>

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
</body>
</html>