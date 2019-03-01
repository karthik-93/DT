<%@ page language="java" contentType="text/html"%>
<html>
<head>
<title>Cart</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
	<table class="table table-condensed">
		<tr class="danger">
			<td colspan="6"><center>Your Order</center></td>
		</tr>
		<tr>
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>SubTotal</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${cartItemList}" var="cartItem">
			<form action="<c:url value="/updateCartItem/${cartItem.cartId}"/>"
				method="get">
				<tr class="table table-bordered">
					<td>${cartItem.productId}</td>
					<td>${cartItem.productName}</td>
					<td><input type="text" value="${cartItem.quantity}"
						name="quantity"></td>
					<td>${cartItem.price}</td>
					<td>${cartItem.price * cartItem.quantity}</td>
					<td><input type="submit" value="UPDATE" class="btn-success" />
						<a href="<c:url value="/deleteCartItem/${cartItem.cartId}"/>"
						class="btn btn-danger">DELETE</a></td>
				</tr>
			</form>
		</c:forEach>
		<tr class="warning">
			<td colspan="4">Total Purchase Amount</td>
			<td colspan="2">${grandTotal}</td>
		</tr>
		<tr class="info">
			<td colspan="3">
				<center>
					<a href="<c:url value="/home"/>" class="btn btn-success">Continue
						Shopping</a>
				</center>
			</td>
			<td colspan="3"><center>
					<a href="<c:url value="/checkout"/>" class="btn btn-success">Checkout</a>
				</center></td>
		</tr>
	</table>
</div>
</body>
</html>