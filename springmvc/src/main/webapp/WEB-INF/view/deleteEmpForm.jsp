<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errMsg = (String) request.getAttribute("errMsg");
    String msg = (String) request.getAttribute("msg");
    %>
    <jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<fieldset>
		<legend>Employee Delete</legend>
		<form action="./delete" >
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="text" name="empId"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Delete"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<% if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg%></h2>
	<% } %>
	<% if (msg != null && !msg.isEmpty()) { %>
	<h2 style="color: red;"><%=msg%></h2>
	<% } %>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>