<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <spring:url  var="css" value="/resources/css"></spring:url>
    <spring:url  var="js" value="/resources/javascript"></spring:url>
    <spring:url  var="images" value="/resources/images"></spring:url>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${css}/util.css">
	<link rel="stylesheet" type="text/css" href="${css}/main.css">
</head>

<body>
	
	<div class="limiter">
	<%if (msg != null && !msg.isEmpty()) { %>
	<h2 style="color: red;"> <%=msg%></h2>
	<% } %>
	<%if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"> <%=errMsg%></h2>
	<% } %>
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(${images}/now.jpg);">
					<span class="login100-form-title-1">
						Log In
					</span>
				</div>
				<form class="login100-form validate-form" action="./empLogin" method="post">
					<div class="wrap-input100 validate-input m-b-26" >
						<span class="label-input100">Employee Id :</span>
						<input class="input100" type="text" name="id" placeholder="Enter Employee Id">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" >
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="password" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>	

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="${js}/jquery-3.2.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
<%if (msg != null && !msg.isEmpty()) { %>
	<h2 style="color: red;"> <%=msg%></h2>
	<% } %>

