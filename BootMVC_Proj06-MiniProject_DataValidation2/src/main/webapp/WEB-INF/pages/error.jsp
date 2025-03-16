<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<style>
		h1{
			color: red;
			text-align: center;
		}
	</style>
<head>
<meta charset="ISO-8859-1">
<title>error page</title>
</head>
<body>
	<h1>Some Internal Problem in Server</h1>
	<hr>
	<table>
		<tr>
			<th>Status</th>
			<td>${status}</td>
		</tr>
		<tr>
			<th>Timestamp</th>
			<td>${timestamp}</td>
		</tr>
		<tr>
			<th>Message</th>
			<td>${message}</td>
		</tr>
		<tr>
			<th>Error</th>
			<td>${error}</td>
		</tr>
		<tr>
			<th>Path</th>
			<td>${path}</td>
		</tr>
		<tr>
			<th>Trace</th>
			<td>${trace}</td>
		</tr>
	</table>
</body>
</html>