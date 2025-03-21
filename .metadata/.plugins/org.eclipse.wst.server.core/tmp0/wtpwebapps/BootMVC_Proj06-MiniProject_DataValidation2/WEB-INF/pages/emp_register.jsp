<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/register.css" >
<script type="text/javascript" src="js/validate.js">
</script>
<title>Registration</title>
</head>
<body>
	<h1>Employee Registration Form</h1>
	<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
		<p class="red">
			<frm:errors path="*"/>
		</p>
		<table>
			<tr>
				<td>Employee Name :</td>
				<td><frm:input path="empName"/></td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="empName"/>
					<span id="empNameErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Designation: </td>
				<td><frm:input path="designation"/>	</td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="designation"/>
					<span id="designationErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee MGR: </td>
				<td><frm:input path="mgr"/></td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="mgr"/>
					<span id="mgrErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee HireDate: </td>
				<td><frm:input path="hireDate"/></td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="hireDate"/>
					<span id="hireDateErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Salary: </td>
				<td><frm:input path="sal"/></td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="sal"/>
					<span id="salErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Department No: </td>
				<td><frm:input path="deptNo"/></td>
				<td class="td-noborder">
					<frm:errors cssClass="red" path="deptNo"/>
					<span id="deptNoErr"></span>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="Reset" value="RESET"></td>
			</tr>
			<frm:hidden id="vflag" path="vflag"/>
		</table>
	</frm:form>
</body>
</html>