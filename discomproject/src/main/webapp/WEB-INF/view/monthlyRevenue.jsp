<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.service.BillCollected"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url var="css" value="/resources/css"></spring:url>
   <spring:url var="js" value="/resources/javascript"></spring:url>
    <% List<BillCollected> revenue = (List<BillCollected>) request.getAttribute("revenue"); 
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy"); %>
<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Monthly Revenue</title>
</head>
<body>
		<% if(revenue != null){ %>
	<div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Support Request</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid;">
            <thead>
              <tr >
      
                <th scope="col">Collected</th>
                <th scope="col">Amount</th>    
              </tr>
            </thead>
		<tbody>
		<% for(BillCollected bill : revenue){ %>
			<tr >
			
					<td style="width: 30%"><%= bill.getCollected() %></td>
					<% String date = dateFormat.format(bill.getDate()); %>
					<td style="width: 40%"><%=bill.getDate() %></td>
		    </tr>
		    <%} %>
			</tbody>
			</table>
		 </div>
	
     	<%} %>



<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>