<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url var="css" value="/resources/css"></spring:url>
   <spring:url var="js" value="/resources/javascript"></spring:url>
    
<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Monthly Revenue</title>
</head>
<body>
		
	



<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>