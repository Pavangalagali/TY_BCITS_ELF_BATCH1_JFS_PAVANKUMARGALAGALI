<%@page import="com.bcits.empwebapp.bean.PrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% PrimaryInfo primaryInfo = (PrimaryInfo)session.getAttribute("primaryInfo"); %>
     <jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1 style="color: navy;">Welcome <%= primaryInfo.getName() %>	</h1>
</body>
</html>