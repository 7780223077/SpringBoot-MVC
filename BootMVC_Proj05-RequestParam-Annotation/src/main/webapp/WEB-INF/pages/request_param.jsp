<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Request Params Data through Model Attributes: </h1>
	<p>employee No : ${empNo}</p>
	<p>Designation : ${desig}</p>
	<br>
	<h1>Request Params Data throgh implicit param object : </h1>
	<p>employee No : ${param.empNo}</p>
	<p>Designation : ${param.desig}</p>
</body>
</html>