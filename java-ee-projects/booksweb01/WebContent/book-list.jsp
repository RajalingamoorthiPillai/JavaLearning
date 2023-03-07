<%@page import="in.conceptarchitect.bookmanagement.Book"%>
<%@page import="java.util.List"%>
<%@page import="in.conceptarchitect.bookmanagement.DbManagerBookService"%>
<%@page import="in.conceptarchitect.jdbc.DbManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Favorite Books</title>
</head>
<body>

<h1>Recommended Books</h1>

<%
	List<Book> books=null;

	try{
		String url="jdbc:mysql://localhost/booksdb";
		String userName="root";
		String password="@DM1n."; 
		Class.forName("com.mysql.jdbc.Driver");
		DbManager dbManager=new DbManager(url, userName, password);
		DbManagerBookService bookManager=new DbManagerBookService(dbManager);
		
		books= bookManager.getAllBooks();
		
	}catch(ClassNotFoundException ex){
		
	}
%>

<h2>Total Books : <%= books.size() %></h2>
<ul>
<% for(Book book : books){ %>	

<li>I Loved  <%=book.getTitle() %> </li>

<%} %>
</ul>


</body>
</html>