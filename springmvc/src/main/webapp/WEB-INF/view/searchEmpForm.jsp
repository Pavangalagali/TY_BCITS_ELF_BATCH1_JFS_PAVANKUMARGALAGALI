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
	<tr style='background-color: lightgrey;color: blue;height: 30px'>
				<th style="font-size: 20px">ID</th>
				<th style="font-size: 20px">Name </th>
				<th style="font-size: 20px">Designation</th>
				<th style="font-size: 20px">Salary</th>
				<th style="font-size: 20px">Mobile</th>
				<th style="font-size: 20px">Email</th>
			</tr>
			<tr style='height: 30px'>
				<td style="font-size: 15px"><%=infoBean.getEmpId() %></td>
				<td style="font-size: 15px"><%=infoBean.getName() %></td>
				<td style="font-size: 15px"><%=infoBean.getDesignation() %></td>
				<td style="font-size: 15px"><%=infoBean.getSalary() %></td>
				<td style="font-size: 15px"><%=infoBean.getMobileNum() %></td>
				<td style="font-size: 15px"><%=infoBean.getMaildId() %></td>
			</tr>			
		</table>	
	<% } %>
	<br><br>
	
 <jsp:include page="footer.jsp"></jsp:include>