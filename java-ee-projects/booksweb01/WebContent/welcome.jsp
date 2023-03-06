<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book's Web App</title>
</head>
<body>
	<h1>Welcome to Book's Web Server</h1>
	<p>Today is <%= new Date() %> </p>
	<%for(int i=0;i<10;i++){ %>
		<p><%="Hello World " %></p>
	<%} %>

</body>
</html>