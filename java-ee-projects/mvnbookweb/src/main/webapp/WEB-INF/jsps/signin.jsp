<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign In</title>
</head>
<body>
<h1>User Sign In</h1>

<p style="color:red">${error }</p>

<form method="post" >
	<label for="email">Email</label>
	<input type="text" placeholder="login email" name="email"/>
	
	<label for="password">Password</label>
	<input type="password" placehold="password" name="password"/>
	
	<input type="submit"/>
</form>

</body>
</html>