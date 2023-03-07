<%@page import="in.conceptarchitect.bookmanagement.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Recommended Books</title>
</head>
<body>
	<h1>Our Recommended Books</h1>	
	
	<ul>
		
		<c:forEach var="book"  items="${books}" >
			<li>${book.title}</li>
		</c:forEach>	
	</ul>	


</body>
</html>