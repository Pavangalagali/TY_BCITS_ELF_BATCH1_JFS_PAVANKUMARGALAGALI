<%@page import="java.util.List"%>
<%@page import="com.bcits.empwebapp.bean.PrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<PrimaryInfo> employeeInfos =(List<PrimaryInfo>) request.getAttribute("empList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<% if(employeeInfos != null){ %>
			<table border="1" style='width: 80%'>
			<thead style="background-color: blue; color: white;">
			<tr style="height: 35px">
				<th> Employee Id</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>DOB</th>
				<th>DOJ</th>
				<th>Mobile Number</th>
			</tr>
			</thead>
			<tbody>
			<% for(PrimaryInfo primaryInfo: employeeInfos){ %>
			<tr>
					<td><%= primaryInfo.getEmpId()%></td>
					<td><%= primaryInfo.getName()%></td>
					<td><%= primaryInfo.getSalary()%></td>
					<td><%= primaryInfo.getDesignation()%></td>
					<td><%= primaryInfo.getBirthDate()%></td>
					<td><%= primaryInfo.getJoiningDate()%></td>
					<td><%= primaryInfo.getMobileNum()%></td>
								
			</tr>
			<% } %>
			</tbody>
			</table>
			<%} else{ %>
			
			<h1 style="color: red;">NO employee Details Found</h1>
			
			<% } %>
</body>
</html>