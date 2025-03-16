<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.charan.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of model attributes ::</h1>
	
	<%-- <%
		List<Distributer> distributers = (List<Distributer>) request.getAttribute("Dist");
	%>
	<table border="1">
		<tr>
			<th>Id<th>
			<th>Name<th>
			<th>Location<th>
			<th>Date<th>
		</tr>
		<%
		for(Distributer dist : distributers){
		%>
		<tr>
			<td><%=dist.getId()%><td>
			<td><%=dist.getName()%><td>
			<td><%=dist.getLocation()%><td>
			<td><%=dist.getDate()%><td>
		</tr>
		<% 
		}
		%>
	</table> --%>
	
	
	<c:choose>
		<c:when test="${!empty Dist}">
			<table border="1" align="center">
				<tr>
					<th>Id<th>
					<th>Name<th>
					<th>Location<th>
					<th>Date<th>
				</tr>
				<c:forEach var="dist" items="${Dist}">
				<tr>
					<td>${dist.id}<td>
					<td>${dist.name}<td>
					<td>${dist.location}<td>
					<td>${dist.date}<td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color:red">Data not found</h1>
		</c:otherwise>
	</c:choose>	

	<%-- pratice testing --%>
	<h1 style="color:red;">Dummy Testing</h1>
		<c:if test="${!empty Dist}">
			<p>Distributer : ${Dist}</p>
		</c:if>
	</body>
</html>