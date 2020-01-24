<%@page import="com.bcits.springmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% UserBean userBean = (UserBean) request.getAttribute("userBean");
    	String name = (String) request.getAttribute("name");
    %>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
		User  ID : <%= userBean.getEmpId() %> <br>
		Password : <%= userBean.getPassword() %><br>
		Name     : <%= name %><br>
</body>
</html>