<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean infoBean = (EmployeeInfoBean) request.getAttribute("employeeInfoBean");
    	String errMsg = (String) request.getAttribute("errMsg");
    %>
    
    <jsp:include page="header.jsp" /><br><br>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
</head>
<body>
<fieldset>
		<legend>Search Employee</legend>
		<form action="./search">
		<label>Employee Id :</label>
		<input type="text" name="empId" required>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Search" >		
		</form>
	</fieldset>
</body>
</html>

<br><br>
<% if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg%></h2>
	<% } %>
	<% if(infoBean != null){ %>
	<table>
	<table border="1" style='width: 80%'>
			<thead style="background-color: blue; color: white;">
			<tr style="height: 35px">
				<th> Employee Id</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>Email ID</th>
				<th>Mobile Number</th>
				<th>DOB</th>
				<th>DOJ</th>
				<th>Blood Group</th>
				<th>Dept Id</th>
				<th>Manager Id</th>
				
			</tr>
			</thead>
			<tbody>
			<tr>
					<td><%= infoBean.getEmpId()%></td>
					<td><%= infoBean.getName()%></td>
					<td><%= infoBean.getSalary()%></td>
					<td><%= infoBean.getDesignation()%></td>
					<td><%= infoBean.getMaildId()%></td>
					<td><%= infoBean.getMobileNum()%></td>			
					<td><%= infoBean.getBirthDate()%></td>
					<td><%= infoBean.getJoiningDate()%></td>
				    <td><%= infoBean.getBloodGroup()%></td>
				   	<td><%= infoBean.getDeptId()%></td>
				    <td><%= infoBean.getMgrId()%></td>
			</tr>
			</tbody>
			</table>
	<% } %>
	<br><br>
	
 <jsp:include page="footer.jsp"></jsp:include>