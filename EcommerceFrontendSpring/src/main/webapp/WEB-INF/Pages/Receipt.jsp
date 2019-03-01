<%@ page language="java" contentType="text/html"%>

<%@include file="header.jsp" %>
<div class="container">
<table class="table table-bordered" align="center">
<tr class="danger">
<td colspan="5"><center>Receipt</center></td>
</tr>
<tr class="info">
<td>ORDER ID</td>
<td>ORD000${order.orderID}</td>
<td>Date</td>
<td colspan="2">${order.orderDate}</td> 
</tr>
<tr class="warning">
<td colspan="5"><h3>Order Items </h3>
</td>
</tr>
<tr>
<td>Product ID</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>SubTotal</td>

</tr>

<c:forEach items="${cartItemList}" var="cartItem">

<tr class="info">
<td>${cartItem.productId}</td>
<td>${cartItem.productName}</td>
<td>${cartItem.quantity}</td>
<td>${cartItem.price}</td>
<td>${cartItem.price * cartItem.quantity}</td>
</tr>

</c:forEach>
<tr class="warning">
<td colspan="4">Total Purchase Amount</td>
<td colspan="1">${grandTotal}/-</td> 
</tr>


	<tr class="warning">
<td colspan="5"><h3>Shipping Address</h3></td>

</tr>

<tr class="info">
<td>
	Address 
</td>
<td colspan="4">
	${addr} 

</td>




</table>
</div>