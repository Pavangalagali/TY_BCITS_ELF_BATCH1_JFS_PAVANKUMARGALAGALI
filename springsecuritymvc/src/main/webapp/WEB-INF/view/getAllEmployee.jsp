<%@page import="com.bcits.springsecuritymvc.beans.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<EmployeeInfo> employeeInfos = (List<EmployeeInfo>) request.getAttribute("employees"); %>
    
     <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   	<fieldset>
	<legend>Employee Details</legend>		
 <div >
   <% if(employeeInfos != null && !employeeInfos.isEmpty()){ %>
		<table>
		<thead >
			<tr>
				<td>Employee Id</td>
				<td>Name</td>
				<td>Role</td>
				<td>Password</td>
			</tr>
		</thead>
		<tbody>
		<% for(EmployeeInfo info : employeeInfos){ %>
			<tr>
				<td><%=info.getEmpId() %></td>
				<td><%=info.getName() %></td>
				<td><%=info.getRole() %></td>
				<td><%=info.getPassword() %></td>
			</tr>
       <%} %>
       </tbody>
		</table>
   <%} else { %>
   <h2 style="color: red">No Records to display</h2>
   <%} %>
   </div>
	</fieldset>
</body>
</html>