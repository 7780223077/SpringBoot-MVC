<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Model Attributes are : </h1>
	<%-- <p>Arrays : ${Arrays}</p> --%>
	<p>Arrays : <%=Arrays.toString((String[])request.getAttribute("Arrays")) %></p>
	<p>List   : ${List}</p>
	<p>Set    : ${Set}</p>
	<p>Map    : ${Map}</p>
	
	
	<h1>Model Attributes Using Tags  are: </h1>
	<p>Arrays : 
		<c:forEach var="array" items="${Arrays}">
			${array}, 
		</c:forEach>
	</p>
	<p>List   : 
		<c:forEach var="list" items="${List}">	
			${list},
		</c:forEach>
	</p>
	<p>Set    : 
		<c:forEach var="set" items="${Set}">	
			${set},
		</c:forEach>
	</p>
	<p>Map    : 
		<c:forEach var="map" items="${Map}">
			${map},
		</c:forEach>
    </p>
</body>
</html>