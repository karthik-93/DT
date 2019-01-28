<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Add Category" method="POST">
		<table>
			<tr>
				<td>Category Name</td>
				<td><input typr="text" name="catName" /></td>
			</tr>
			<tr>
				<td>Category Description</td>
				<td><input type="text" name="catDesc" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<center><input type="submit" value="SUBMIT"/></center>
			</tr>
				
		</table>

	</form>
</body>
</html>