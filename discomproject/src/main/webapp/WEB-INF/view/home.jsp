<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url var="js" value="/resources/javascript"></spring:url>
   <%  String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>home</title>
</head>
<body>
      
    <div class="card-body col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12" style="margin-top: 200px;margin-left: 460px;">
        <%if (msg != null && !msg.isEmpty()) { %>
	   <h2 style="color: blue;"> <%=msg%></h2>
	   <% } %>	
        
        <h1 >Welcome To Discom Online Service</h1>
  <a href="./employeeLogin">  <button type="button" class="btn btn-dark btn-lg " style="margin-top: 30px;"><i class="fa fa-male"></i> Employee Login</button></a>
  <a href="./consumerLogin"> <button type="button" class="btn btn-info btn-lg " style="margin-top: 30px;"><i class="fa fa-male"></i> Consumer Login</button></a>
    </div>
    <script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>