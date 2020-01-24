<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String empId = request.getParameter("empId"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<h1 style="color: purple;">Employee Id <%= empId %> Details</h1>
	<h3 style="color: green;">Name = Sai</h3><br>
	<h3 style="color: orange;">Designation = Accountant</h3><br>
	<h3 style="color: grey;">Mobile - 9900990099</h3>
</body>
</html>