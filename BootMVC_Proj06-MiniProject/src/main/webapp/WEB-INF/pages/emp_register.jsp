<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
	<style>
		*{
			text-align: center;
		}
	</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Registration Form</h1>
	<frm:form modelAttribute="emp">
		<table border="1" align="center">
			<tr>
				<td>Employee Name :</td>
				<td><frm:input path="empName"/></td>
			</tr>
			<tr>
				<td>Employee Designation: </td>
				<td><frm:input path="designation"/></td>
			</tr>
			<tr>
				<td>Employee Salary: </td>
				<td><frm:input path="sal"/></td>
			</tr>
			<tr>
				<td>Employee Department No: </td>
				<td><frm:input path="deptNo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="Reset" value="RESET"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>