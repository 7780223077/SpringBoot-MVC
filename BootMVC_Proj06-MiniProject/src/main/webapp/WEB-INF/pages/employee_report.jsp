<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		th,td {
			color: pink;
    	}
    .links{
    	text-align: center;
    }
	</style>
<meta charset="UTF-8">
<title>Employees Report</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Employees Report</h1>
	<c:choose>
		<c:when test="${!empty emp}">
			<table border="1" align="center" bgcolor="green">
				<tr>
					<th> Id</th>
					<th> Name</th>
					<th> Designation</th>
					<th> Salary</th>
					<th> DeptNo</th>
					<th colspan="2">Operations</th>
				</tr>
				<c:forEach  var="e" items="${emp}">
					<tr>
					<td> ${e.empId}</td>
					<td> ${e.empName}</td>
					<td> ${e.designation}</td>
					<td> ${e.sal}</td>
					<td> ${e.deptNo}</td>
					<td><a href="edit?id=${e.empId}">edit</a></td>
					<td><a href="delete?id=${e.empId}" onclick="return confirm('Do you want to delete')" >delete</a></td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p style="color: red; text-align: center;">Employees data not Found</p>
		</c:otherwise>
	</c:choose>
	<div class="links">
		<c:if test="${!empty addResult}">
			<p>${addResult}</p>
		</c:if>
		<p><a href="add_emp"><img alt="" src="images/add_emp.png" width="30px" height="30px">AddEmployee</a></p>
		<p><a href="./"><img src="images/home.png" width="30px" height="30px">Home</a>
	</div>
</body>
</html>