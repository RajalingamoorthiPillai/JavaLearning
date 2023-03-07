<%@page import="in.conceptarchitect.bookmanagement.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Recommended Books</title>
</head>
<body>
	<h1>Our Recommended Books</h1>	
	<%
		List<Book> books=(List<Book>) request.getAttribute("books");
	%>
	
	<p>Total Books: <%=books.size() %>
	
	<% for(Book book:books){ %>
		<p><%=book.getTitle() %>
	<%} %>	


</body>
</html>