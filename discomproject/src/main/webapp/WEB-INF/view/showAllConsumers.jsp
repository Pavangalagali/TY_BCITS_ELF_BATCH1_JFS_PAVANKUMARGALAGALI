<%@page import="com.bcits.discomproject.beans.EmployeeMaster"%>
<%@page import="com.bcits.discomproject.beans.CurrentBill"%>
<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomproject.beans.ConsumerMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>

<%   String msg = (String) request.getAttribute("msg"); 
List<ConsumerMaster> consumers = (List<ConsumerMaster>) request.getAttribute("consumers"); %>

<jsp:include page="nav.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(consumers != null){ %>
		       <div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
		       <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Consumer Deatils</h4></legend>
              <table class="table table-sm table-dark mt-2">
                    <tr >
                <thead>
                 
                     <th scope="col">rrNumber</th>
                         <th scope="col">Name</th>
                         <th scope="col">Region</th>
                         <th scope="col">Type of Consumer</th>
                         <th scope="col"></th>                        
                   </tr>
                   
             </thead>
		    <tbody>
		    <% for(ConsumerMaster consumer : consumers){ %>
		      <form action="./curentBillPage" method="get">   	
		      <input name ="rrNumber" type="text"
		      value="<%=consumer.getRrNumber()%>" hidden="true" />	
		       	<tr>
					<td><%=consumer.getRrNumber()%></td>
					<td><%=consumer.getFirstName()+" "+ consumer.getLastName()%></td>
					<td><%=consumer.getRegion() %></td>
					<td><%=consumer.getConsumerType()%></td>
					<td>
			  	<button type="submit"  class="btn btn-info btn-lg">Generate</button>
			  </td>
			  </tr>
		</form>
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