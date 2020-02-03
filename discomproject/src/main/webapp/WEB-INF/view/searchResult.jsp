<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
    <% List<MonthlyConsumption> consumption = (List<MonthlyConsumption>) request.getAttribute("consumptions"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Insert title here</title>
</head>
<body>
       <div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
			<form  action="./curentBillPage">
			<input type="text" name="rrNumber" value="<%=consumption.get(0).getConsumptionPk().getRrNumber()%>">
				<button type="button" class="btn btn-primary btn-lg btn-block">Generate Bill</button>
			</form>
	  </div>
<% if(consumption != null){ %>
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
			<% for(MonthlyConsumption consumed : consumption ){ %>
			<tr>
					<td><%= consumed.getConsumptionPk().getRrNumber() %></td>
					<td><%= consumed.getTakenOn()%></td>
					<td><%= consumed.getTotalUnits() %></td>
			</tr>
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