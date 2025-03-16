<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
<style type="text/css">
	*{
	text-align: center;
	}
</style>
</head>
<body>
	<h1>Employee Edit form</h1>
	<frm:form modelAttribute="emp">
		<table border="1" align="center">
			<tr>
				<td>Employee Id :</td>
				<td><frm:input path="empId" readonly="true"/></td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td><frm:input path="empName"/></td>
			</tr>
			<tr>
				<td>Employee Designation: </td>
				<td><frm:input path="designation"/></td>
			</tr>
			<tr>
				<td>Employee MGR: </td>
				<td><frm:input path="mgr"/></td>
			</tr>
			<tr>
				<td>Employee HireDate: </td>
				<td><frm:input path="hireDate"/></td>
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
				<td rowspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>