<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
		h1{
			color: red;
			text-align: center;
		}
	</style>
<title>500 error</title>
</head>
<body>
	<h1>There is some problem in executing this page</h1>
	<table>
		<tr>
			<th>status</th>
			<td>${status}</td>
		</tr>
		<tr>
			<th>timestamp</th>
			<td>${timestamp}</td>
		</tr>
		<tr>
			<th>error</th>
			<td>${error}</td>
		</tr>
		<tr>
			<th>path</th>
			<td>${path}</td>
		</tr>
	</table>
</body>
</html>