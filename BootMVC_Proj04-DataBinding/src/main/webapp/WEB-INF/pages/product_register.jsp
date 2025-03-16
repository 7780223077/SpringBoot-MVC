<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Product Registration form</h2>
	<frm:form modelAttribute="prod">
		<table align="center">
			<tr>
				<td>Name : </td>
				<td><frm:input path="name"/></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><frm:input path="description"/></td>
			</tr>
			<tr>
				<td>Specifications : </td>
				<td><frm:input path="specifications"/></td>
			</tr>
			<tr>
				<td>Features : </td>
				<td><frm:input path="features"/></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><frm:input path="price"/></td>
			</tr>
			<tr>
				<td>Manufacturer : </td>
				<td><frm:input path="manufacturer"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="reset" value=reset></td>
			</tr>
		</table>
	</frm:form>
	
	<!-- <form action="/register" method="POST">
		<table align="center">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Specifications</td>
				<td><input type="text" name="specifications"></td>
			</tr>
			<tr>
				<td>Features</td>
				<td><input type="text" name="features"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Manufacturer</td>
				<td><input type="text" name="manufacturer" value="Apple"></td>
			</tr> 
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form> -->
</body>
</html>