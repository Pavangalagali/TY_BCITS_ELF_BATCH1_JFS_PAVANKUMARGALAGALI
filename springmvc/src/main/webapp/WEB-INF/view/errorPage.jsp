<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>

<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red;"><%=errMsg %></h1>
</body>
</html>
<jsp:include page="footer.jsp"/>