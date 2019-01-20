<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="product" method="POST">
		<table align="center">
			<tr>
				<td><center><h3>Products</h3></center></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="proName" value="${product.productName}"/></td>
				<td>Product Description</td>
				<td><input type="text" name="proDesc" value="${product.productDesc}"/></td> 
			</tr>
		</table>

	</form>
</body>
</html>