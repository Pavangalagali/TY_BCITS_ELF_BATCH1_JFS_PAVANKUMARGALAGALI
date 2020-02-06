<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% 
    String msg = (String) request.getAttribute("msg");
	String errMsg =(String) request.getAttribute("errMsg");
 %>    
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Enter Employee Details</legend>
		<form action="./register" method="post">
		<table>
			<tr>
				<td>Employee Id</td>
				<td>:</td>
				<td><input type="number" name="empId" required="required"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required="required"/>  </td>
			</tr>
			<tr>
				<td>Role</td>
				<td>:</td>
				<td><input type="radio" name="role" value="ROLE_USER"/>User  </td>
			</tr>
			<tr>
				<td><input type="radio" name="role" value="ROLE_ADMIN"/>Admin  </td>
			</tr>
			
			<tr>
				<td>Name</td>
				<td>:</td>
				<td><input type="text" name="name" /></td>
			</tr>

		</table>
		<input type="submit" value="Register" >		
		</form>
	</fieldset>
	<div align="center">
	<% if(msg != null && !msg.isEmpty()){ %>
		<h2 style="color: green;font-family: cursive;"><%=msg %></h2>
	<% } %>
	
	
		<% if(errMsg != null && !errMsg.isEmpty()){ %>
		<h2 style="color: green;font-family: cursive;"><%=errMsg %></h2>
	   <% } %>
	</div>
	
</body>
</html>