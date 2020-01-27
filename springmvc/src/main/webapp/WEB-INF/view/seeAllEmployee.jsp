<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<EmployeeInfoBean> infoBeans = (List<EmployeeInfoBean>) request.getAttribute("infoBeans");
	   String errMsg = (String) request.getAttribute("errMsg");
    %> 
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
    <% if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg%></h2>
	<% } %>
	<% if(infoBeans != null){ %>
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
			<% for(EmployeeInfoBean infoBean : infoBeans ){ %>
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
			<% } %>
			</tbody>
			</table>
	<% } %>

</body>
</html>
<br><br>

<jsp:include page="footer.jsp"></jsp:include>

