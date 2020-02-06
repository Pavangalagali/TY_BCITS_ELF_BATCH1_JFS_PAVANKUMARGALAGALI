<%@page import="com.bcits.springsecuritymvc.beans.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <% EmployeeInfo info = (EmployeeInfo) request.getAttribute("employeeInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
	<fieldset>
	<legend>Search Employee</legend>
	<form action="./getEmployee">
		<table>
			<tr>
			<td>Employee ID</td>
			<td>:</td>
			<td><input type="number" name="empId" required="required"/></td>
			</tr>
		</table><input type="submit" value="Search" style="background-color:olive;color: white; ">
	</form>
	</fieldset>
   </div>
   <div align="center" style="margin-top: 150px">
   <% if(info != null){ %>
   	<fieldset>
	<legend>Employee Details</legend>		
		<table>
		<thead style="background-color: aqua;color: ">
			<tr>
				<td>Employee Id</td>
				<td>Name</td>
				<td>Role</td>
				<td>Password</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=info.getEmpId() %></td>
				<td><%=info.getName() %></td>
				<td><%=info.getRole() %></td>
				<td><%=info.getPassword() %></td>
			</tr>
       </tbody>
		</table>
	</fieldset>
   <%} else { %>
   <h2 style="font-style: oblique;">Employee Details Not Found!!!!!!!!</h2>
   <%} %>
   </div>

</body>
</html>