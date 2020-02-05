<%@page import="com.bcits.discomproject.beans.SupportRequest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>
<% String msg = (String) request.getAttribute("msg"); 
   List<SupportRequest> reqs =(List<SupportRequest>) request.getAttribute("support");
    %>
<jsp:include page="consumerHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Tokens<title>
</head>
<body>
	  <%if (msg != null && !msg.isEmpty()) { %>
	   <h2 style="color: blue;"> <%=msg%></h2>
	   <% } %>	
	   
	   
		<% if(reqs != null && !reqs.isEmpty()){ %>
		<div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Support Request</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid;">
            <thead>
              <tr >
                <th scope="col">Support</th>
                <th scope="col">Response</th>
              </tr>
            </thead>
		
			<% for(SupportRequest req : reqs ){ %>
			<tbody>			
			<tr >
					<td style="width: 30%;"><%=req.getSupportPk().getSupport() %></td>
					<td style="width: 40%"><%=req.getResponse()%></td>
			</tr>
			</tbody>
			<% } %>		
		</table>
		</div>
		<%} %>


<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>