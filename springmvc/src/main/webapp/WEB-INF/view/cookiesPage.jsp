<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie</title>
</head>
<body>
	<a href="./createCookie"> Click Here </a> to create cookie.
	<br>
	<a href="./readCookie"> Click Here </a> to Read cookie.
	<br>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h2>
		<%=msg%>
	</h2>
	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2>
		<%=errMsg%>
	</h2>
	<%
		}
	%>
</body>
</html>