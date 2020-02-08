<%@page import="com.bcits.discomproject.beans.BillHistory"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.service.BillCollected"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url var="css" value="/resources/css"></spring:url>
   <spring:url var="js" value="/resources/javascript"></spring:url>
    <% 
    		
  			List<BillHistory> histories = (List<BillHistory>)  request.getAttribute("collected");
  			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    %>
    
<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Collection</title>
</head>
<body>

     <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5"style="margin-left: 140px">

     <div id="page-content-wrapper bill">
     <div>
     <br>
     
     <% if(histories != null && !histories.isEmpty()){ %>
     <input class="form-control" id="myInput" type="text" placeholder="Search Month"/>
		
		<legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Bill Collection</h4></legend>
     <br>
        <table class="table table-bordered  table-sm table-dark mt-2">
            <thead>
              <tr >
                <th scope="col" style="color:teal;font-size:x-large;text-align: center;">RR Number</th>
                <th scope="col" style="color:teal;font-size:x-large;text-align: center;">Region</th>
                <th scope="col" style="color:teal;font-size:x-large;text-align: center;">Bill </th>
                <th scope="col"style="color:teal;font-size:x-large;text-align: center;">Date </th>
              </tr>
            </thead>
		<tbody id="myTable" >
			<% for(BillHistory billHistory : histories ){ %>
			<tr>
			
					<td style="padding-left: 50px"> <%=billHistory.getBillHistoryPk().getRrNumber() %></td>
					<td style="padding-left: 50px"> <%=billHistory.getRegion() %></td>
					<td style="padding-left: 50px"> <%=billHistory.getBill()%></td>
					<% String date = dateFormat.format(billHistory.getBillHistoryPk().getDate()); %>
					<td style="padding-left: 50px"> <%=date%></td>
			</tr>
					<% }%>
			</tbody>
			</table>
			
     <%} %>
     
	</div>
     </div>
     </div>
      

<script src="${js}/collectedBills.js"></script>
<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>