<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg =(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login </h2>
  <form action="./empLogin" method="post">
    <input type="text" name="id" placeholder="Employee ID" />
    <input type="password" name="password" placeholder="password" />
    <button type="submit" >Login</button>
  </form>
 <% if(msg != null  && !msg.isEmpty()){ %>
		<h1 style='color: maroon;'> <%= msg %></h1>
	<%} %>
  
</body>
</html>