<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.beans.SupportRequest"%>
<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
    <% List<MonthlyConsumption> consumption = (List<MonthlyConsumption>) request.getAttribute("consumptions");
       String rrNumber = (String) request.getAttribute("rrNumber");
       List<SupportRequest> reqs = (List<SupportRequest>) request.getAttribute("support");
       String msg = (String) request.getAttribute("msg");
		SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");	    
    %>
<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Employee Management</title>
</head>
<body>
      
	  <%if (errMsg != null && !errMsg.isEmpty()) { %>
	   <h2 style="color: red; text-align: centre;"> <%=errMsg%></h2>
	   <% } %>	
	   <%if (msg != null && !msg.isEmpty()) { %>
	   <h2 style="color: blue;"> <%=msg%></h2>
	   <% } %>
	  
<% if(consumption != null){ %>
 <div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
			<form  action="./curentBillPage">
			<input type="text" name="rrNumber" value="<%=rrNumber%>" hidden="true">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Generate Bill</button>
			</form>
	  </div>
		<div class=" col-9 col-sm-9 col-md-9 col-lg-9 col-xl-9 mt-3" style="margin-left: 250px">
		<legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Monthly Consumption</h4></legend>
        <table class="table table-sm  table-bordered table-dark mt-2">
            <thead>
              <tr >
                <th scope="col">RR Number</th>
                <th scope="col">Statement On</th>
                <th scope="col">Previous Units</th>
                <th scope="col">Total Units</th>
                <th scope="col"></th>
              </tr>
            </thead>
		<tbody>
			<% for(MonthlyConsumption consumed : consumption ){    %>
			<form action="./UpdateDueBill" method="post">
			<tr >
				<input type="text" name="rrNumber"  value="<%=consumed.getConsumptionPk().getRrNumber() %>" hidden="true" />
		 		<input type="datetime" name="date" value="<%=consumed.getConsumptionPk().getDate()%>" hidden="true">
		  		
					<td style="width: 25%"><%= consumed.getConsumptionPk().getRrNumber() %></td>
					<% String date = dateFormat.format(consumed.getTakenOn()); %>
					<td style="width: 25%"><%=date %></td>
					<td style="width: 25%"><%=consumed.getFinalUnits() %></td>
					<td style="width: 25%"><%= consumed.getTotalUnits() %></td>
					<% if(consumed.getStatus().equals("not paid")){ %>
						<td style="width: 25%"> <input type="submit"  class="btn btn-primary" value="Received" /> </td>
					<%} %>
			</tr>
			</form>
			<% } %>
		</tbody>
			</table>
			</div>
		<%} %>
		
		<% if(reqs != null){ %>
		<div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Support Request</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid;">
            <thead>
              <tr >
              <th scope="col">Date</th>
                <th scope="col">Support</th>
                <th scope="col">Response</th>
                <th/>
               
             
              </tr>
            </thead>
		<tbody>
			<% for(SupportRequest req : reqs ){ %>
			<form action="./generateResponse" method="post">   	
		      <input  type="text" name="support" value="<%=req.getSupportPk().getSupport()%>" hidden="true"/>
		      <input  type="text" name ="rrNumber"
		      value="<%=rrNumber%>" hidden="true" />	
			<tr >
			        <% String date = dateFormat.format(req.getDate()); %>
			        <td style="width: 40%"><%=date%></td>
					<td style="width: 30%;"><%= req.getSupportPk().getSupport() %></td>
					<td style="width: 40%"><%=req.getResponse()%></td>
				    <td><textarea name="response" rows="5" cols="40" required="required"></textarea><br>
					<button type="submit"  class="btn btn-dark  ">Submit</button></td>
		
			</tr>
			</form>
			<% } %>
			</tbody>
			</table>
		 </div>
		<%} %>


<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>