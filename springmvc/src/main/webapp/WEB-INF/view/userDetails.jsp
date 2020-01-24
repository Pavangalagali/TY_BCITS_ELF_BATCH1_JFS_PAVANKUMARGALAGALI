<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% int empId = (Integer) request.getAttribute("empId");
    	String password = (String) request.getAttribute("pwd");
    %>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
		User  ID : <%=empId %> <br>
		Password : <%=password %>
</body>
</html>