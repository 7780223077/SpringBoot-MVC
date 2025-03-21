<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
<link rel="stylesheet" href="css/emp_edit.css"> 
<script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
	<h1>Employee Edit form</h1>
	<frm:form modelAttribute="emp" onsubmit="return doValidation(this)">
		<%-- <frm:errors path="*" cssClass="red"></frm:errors> --%>
		<table border="1" align="center">
			<tr>
				<td>Employee Id :</td>
				<td>
					<frm:input path="empId" readonly="true"/>
					<frm:errors path="empId" cssClass="red"/>
				</td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td>
					<frm:input path="empName"/>
					<frm:errors path="empName" cssClass="red"/>
					<span class="red" id="empNameErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Designation: </td>
				<td>
					<frm:input path="designation"/>
					<frm:errors path="designation" cssClass="red"/>
					<span id="designationErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee MGR: </td>
				<td>
					<frm:input path="mgr"/>
					<frm:errors path="mgr" cssClass="red"/>
					<span class="red" id="mgrErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee HireDate: </td>
				<td>
					<frm:input path="hireDate"/>
					<frm:errors path="hireDate" cssClass="red"/>
					<span class="red" id="hireDateErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Salary: </td>
				<td>
					<frm:input path="sal"/>
					<frm:errors path="sal" cssClass="red"/>
				 <span class="red" id="salErr"></span></td>
			</tr>
			<tr>
				<td>Employee Department No: </td>
				<td>
					<frm:input path="deptNo"/>
					<frm:errors path="deptNo" cssClass="red"/>
				<span class="red" id="deptNoErr"></span></td>
			</tr>
			<tr>
				<td rowspan="2"><input type="submit" value="Update"></td>
			</tr>
		</table>
		<frm:hidden id="vflag" path="vflag"/>
	</frm:form>
</body>
</html>