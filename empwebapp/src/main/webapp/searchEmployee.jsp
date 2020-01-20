<%@page import="com.bcits.empwebapp.bean.PrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% HttpSession session2 = request.getSession(false);  %>   
    <% PrimaryInfo primaryInfo = (PrimaryInfo)request.getAttribute("empInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<% if(session2 != null){ %>
    	<jsp:include page="header.jsp"></jsp:include> 
    	<% PrimaryInfo info = (PrimaryInfo)session2.getAttribute("primaryInfo"); %>
    
    	<fieldset>
			<legend>Search Employee</legend>
			<form action="./getEmp">
			<label>Employee Id :</label>
			<input type="text" name="empId" required>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="Search" >		
			</form>
		</fieldset>

	
	<% if(primaryInfo != null){ %>	
		
		<h1 style="color: green;">Result Found</h1>
		Name = <%= primaryInfo.getName() %><br>
		Designation = <%= primaryInfo.getDesignation() %><br>
		Salary = <%= primaryInfo.getSalary() %><br>
		Email Id = <%= primaryInfo.getMaildId() %><br>
	<%}else{ %>
		<h1 style='color: red;'>Employee Id Not Found</h1>
	<% } %>
	<% }else{ %>
			
		<% request.setAttribute("msg", "please login again"); %>
		<jsp:forward page="loginForm.jsp"></jsp:forward>
		
	<% } %>
</body>
</html>