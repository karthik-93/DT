<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>User Home</h3>


<div class = "row">
<c:forEach items="${productList}" var="product">

   <div class = "col-sm-4 col-md-3">
      <a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class = "thumbnail">
         <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="Generic placeholder thumbnail">
      </a>
      <p>${product.productName}</p>
      <p>Price : INR ${product.price}/-</p>
      <p>Stock : ${product.stock}</p>
   </div>

</c:forEach>
</div>

</body>
</html>