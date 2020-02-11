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
<spring:url var="images" value="/resources/images"></spring:url>
<%
	ConsumerMaster consumer = (ConsumerMaster) session.getAttribute("consumerInfo");
	List<MonthlyConsumption> consumptions = (List<MonthlyConsumption>) request.getAttribute("mc");
	List<MonthlyConsumption> bills = (List<MonthlyConsumption>) request.getAttribute("bill");
	CurrentBill currentBill = (CurrentBill) request.getAttribute("currentBill");
    String msg = (String) request.getAttribute("msg");
    
    SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
%>

<jsp:include page="consumerHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${css}/home.css">
<title>home</title>
</head>

<body style="background-image: url('${images}/conHome.jpg');">
	<%if (msg != null && !msg.isEmpty()) { %>
	   <h2 style="color: blue;"> <%=msg%></h2>
	   <% } %>	

	<div class="container">
		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3 ">
			<div class="card text-center" style="background-image: url('${images}/conHome.jpg');">
				<div class="card-header bg-info " style="height: 70px;">
					<h4 style="color: rgb(195, 221, 221);">Welcome to Discom
						Consumer Portal</h4>
				</div>
				<div class="card-body">
					<table>
						<tr style="color: white">
							<td>
								<h5 style="text-align: left;">Full Name</h5>
							</td>
							<td>
								<h5 style="text-align: left;">:</h5>
							</td>
							<td>
								<h5 style="text-align: left;">
									<%=consumer.getFirstName() + " " + consumer.getLastName()%>
								</h5>
							</td>
						</tr>
						<tr style="color: white">
							<td>
								<h5 style="text-align: left;">RR-Number</h5>
							</td>
							<td>
								<h5 style="text-align: left;">:</h5>
							</td>
							<td>
								<h5 style="text-align: left;"><%=consumer.getRrNumber()%></h5>
							</td>
						</tr>
						<tr style="color: white">
							<td>
								<h5 style="text-align: left;">Region</h5>
							</td>
							<td>
								<h5 style="text-align: left;">:</h5>
							</td>
							<td>
								<h5 style="text-align: left;"><%=consumer.getRegion()%></h5>
							</td>
						</tr>
						<tr style="color: white">
							<td>
								<h5 style="text-align: left;">Consumer-Type</h5>
							</td>
							<td>
								<h5 style="text-align: left;">:</h5>
							</td>
							<td>
								<h5 style="text-align: left;"><%=consumer.getConsumerType()%></h5>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>


		<div class="card-body">
		
				<% if(currentBill != null){ %>
		       <div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
		       <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Current Bill</h4></legend>
              <table class="table table-sm table-dark mt-2">
                <thead>
                    <tr >
                         <th scope="col">RR Number</th>
                         <th scope="col">Initial Reading</th>
                         <th scope="col">Final Reading</th>
                         <th scope="col">Taken On</th>
                         <th scope="col">Units Consumed</th>
                         <th scope="col">Bill</th>
                         <th scope="col">Due Date</th>
                   </tr>
             </thead>
		    <tbody>
		       	<tr>
					<td><%=currentBill.getRrNumber() %></td>
					<td><%=currentBill.getInitialUnits()%></td>
					<td><%=currentBill.getFinalUnits() %></td>
					<% String date=  dateFormat.format(currentBill.getReadingsTakenOn()); %>
					<td><%=date%></td>
					<td><%=currentBill.getUnitsConsumed()%></td>
					<td><%=currentBill.getAmount() %></td>
					<% String date2=  dateFormat.format(currentBill.getDueDate()); %>
					<td><%=date2%></td>
			  </tr>
		</tbody>		
		</table>
		<form action="./payment" method="get">
			<button type="submit"  class="btn btn-info btn-lg">Pay Now</button>
		</form>
		</div>
		<%} %>
		</div>


		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
			<a href="./monthlyConsumption">
				<button type="button" class="btn btn-dark btn-lg btn-block">Monthly
					Consumption</button>
			</a>
		</div>
		
			<% if(consumptions != null){ %>
		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
		<legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Monthly Consumption</h4></legend>
        <table class="table table-sm table-dark mt-2">
            <thead>
              <tr >
                <th scope="col">RR Number</th>
                <th scope="col">Statement On</th>
                <th scope="col">Total Units</th>
              </tr>
            </thead>
		<tbody>
			<% for(MonthlyConsumption consumed : consumptions ){ %>
			<tr>
					<td><%= consumed.getConsumptionPk().getRrNumber() %></td>
					<%
					String date=  dateFormat.format(consumed.getTakenOn()); %>
					<td><%= date%></td>
					<td><%= consumed.getTotalUnits() %></td>
			</tr>
			<% } %>
			</tbody>
			</table>
			</div>
		<%} %>
		


		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
			<a href="./billHistory">
				<button type="button" class="btn btn-primary btn-lg btn-block">Bill
					History</button>
			</a>
			
		<% if(bills != null){ %>
		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
		<legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Bill History</h4></legend>
        <table class="table table-sm table-primary mt-2">
            <thead>
              <tr >
                <th scope="col">RR Number</th>
                <th scope="col">Statement Date</th>
                <th scope="col">Paid On</th>
                <th scope="col">Total Units</th>
                <th scope="col">Bill</th>
                <th scope="col">Status</th>
              </tr>
            </thead>
		<tbody>
			<% for(MonthlyConsumption bill : bills ){ %>
			<tr>
					<td><%= bill.getConsumptionPk().getRrNumber() %></td>
			        <% 	String date=  dateFormat.format(bill.getTakenOn()); %>
					<td><%= date%></td>
					<% 	String date2=  dateFormat.format(bill.getConsumptionPk().getDate()); %>
					<td><%= date2%></td>

					<td><%= bill.getTotalUnits() %></td>
					<td><%= bill.getBill() %>
					<% if(bill.getStatus().equals("paid")){ %>
					<td style="color: green; font-weight: bold;font-size: large;"><%= bill.getStatus()%></td>
					<% }else { %>
					<td style="color: red;"><%= bill.getStatus()%></td>
					<% } %>
			</tr>
			<% } %>
			</tbody>
			
			</table>
			</div>
		<%} %>
	
			
			
		</div>
		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
			<a href="./currentBill">
				<button type="button" class="btn btn-info btn-lg btn-block">Current
					Bill</button>
			</a>
		</div>
		
	
				
		

		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-5">
			<h1 style="font-size: larger;color: aqua;">Leave Message</h1>
			<form action="./sendSupport" method="post">
				<textarea name="support" id="" cols="150" rows="8"
					placeholder="max 250 character"></textarea>
					<input type="text" name="response" value="" hidden="true">
				<button type="submit"   class="btn btn-primary btn-lg">Submit</button>
			</form>
			
		</div><br>
		<div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-5">
		<form action="./getSupport" >
		<input type="text" name="rrNumber" value="<%=consumer.getRrNumber()%>" hidden="true">
		 <button type="submit"   class="btn btn-dark btn-lg">Responses</button>
	   </form>
		</div>
		<br>
	</div>
	<script src="${js}/jquery-3.2.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>