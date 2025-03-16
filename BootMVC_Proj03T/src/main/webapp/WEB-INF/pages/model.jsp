<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Model Attribute Data</h2>
	<c:if test="${!empty Dist1}">
		<p>${Dist1}</p>
	</c:if>
	<c:if test="${!empty Dist2}">
		<p>${Dist2}</p>
	</c:if>
</body>
</html>