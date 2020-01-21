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
		<a href="generateBill.jsp"> Generate Bill</a>
		<a> this month bill collected</a>
		<a href="./logout"> logout</a>
</body>
</html>
<% if(msg != null  && !msg.isEmpty()){ %>
		<h1 style='color: maroon;'> <%= msg %></h1>
	<%} %>