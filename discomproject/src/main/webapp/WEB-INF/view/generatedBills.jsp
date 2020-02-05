<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.beans.CurrentBill"%>
<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomproject.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>

<% List<CurrentBill> currentBills = (List<CurrentBill>) request.getAttribute("currentBill");
   String msg = (String) request.getAttribute("msg"); 
   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   %>

<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Generated Bills</title>
</head>
<body>
	

    <%  if(currentBills != null) { %>
		<div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5"style="margin-left: 140px">
		<legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Generated Bills</h4></legend>
        <table class="table table-sm table-dark mt-2">
            <thead>
              <tr >
                <th scope="col">RR Number</th>
                <th scope="col">Statement On</th>
                <th scope="col">Total Units</th>
                <th scope="col">Bill </th>
                <th scope="col">Due Date </th>
              </tr>
            </thead>
		<tbody>
			<% for(CurrentBill currentBill : currentBills ){ %>
			<tr>
					<td><%=currentBill.getRrNumber()  %></td>
					<% String date = dateFormat.format(currentBill.getReadingsTakenOn()); %>
					<td><%=date %></td>
					<td><%=currentBill.getUnitsConsumed()  %></td>
					<td><%=currentBill.getAmount() %></td>
					<% String date2 = dateFormat.format(currentBill.getDueDate()); %>
					<td><%=date2 %></td>
			</tr>
			<% } %>
			</tbody>
			</table>
			</div>
		<%} %>
		<%if (msg != null && !msg.isEmpty()) { %>
		<div class="card-body col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12" style="margin-top: 200px;margin-left: 460px;">   
	    <h2 style="color: orange;"> <%=msg%></h2> 
	   </div>
	  <% } %>	
</body>
</html>