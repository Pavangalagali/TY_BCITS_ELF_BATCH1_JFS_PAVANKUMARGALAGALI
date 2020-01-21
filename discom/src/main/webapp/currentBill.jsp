<%@page import="com.bcits.discom.bean.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% CurrentBill currentBill = (CurrentBill) request.getAttribute("currentBill"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% if(currentBill != null){ %>
		<table border="1" style="width: 100%">
		<thead>
			<tr style='background-color: lightgrey ;color: black;'>
				<th>RR Number</th>
				<th>Readings Taken On</th>
				<th>Intial Units</th>
				<th>Final Units</th>
				<th>Total Units</th>
				<th>Amount</th>
				<th>Due Date</th>
			</tr>
			</thead>
			<tbody>
			<tr>
					<td><%=currentBill.getRrNumber() %></td>
					<td><%=currentBill.getReadingsTakenOn() %></td>
					<td><%=currentBill.getInitialUnits() %></td>
					<td><%= currentBill.getFinalUnits() %></td>
					<td><%= currentBill.getUnitsConsumed()%></td>
					<td><%= currentBill.getAmount() %></td>
					<td><%= currentBill.getDueDate() %></td>						
			</tr>
			</tbody>
		</table>
		<% }else{ %>
		<h1>No current Bill found
		</h1>
		<% } %>
</body>
</html>