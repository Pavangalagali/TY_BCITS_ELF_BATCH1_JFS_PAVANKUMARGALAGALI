<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.beans.SupportRequest"%>
<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>    
    <%
    List<SupportRequest> reqs = (List<SupportRequest>) request.getAttribute("support");
	SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy");	    
	%>
    <jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% if(reqs != null){ %>
		<div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Support Request</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid;">
            <thead>
              <tr >
                <th scope="col">RR-Number</th>
                <th scope="col">Date</th>
                <th scope="col">Support</th>
                <th scope="col">Response</th>
                <th/>
               
             
              </tr>
            </thead>
		<tbody>
			<% for(SupportRequest req : reqs ){ %>
			<form action="./generateSupport" method="post">   	
			<tr >
		      <input  type="text" name="support" value="<%=req.getSupportPk().getSupport()%>" hidden="true"/>
		      <input  type="text" name ="rrNumber"
		             value="<%=req.getSupportPk().getRrNumber()%>" hidden="true" />	
			        <td style="width: 20%"><%=req.getSupportPk().getRrNumber()%></td>
			         <% String date = dateFormat.format(req.getDate()); %>
			        <td style="width: 10%"><%=date%></td>
					<td style="width: 30%"><%= req.getSupportPk().getSupport() %></td>
					<td style="width: 30%"><%=req.getResponse()%></td>
				    <td style="width: 30%"><textarea name="response" rows="5" cols="40" required="required"></textarea><br>
					<button type="submit"  class="btn btn-dark">Submit</button></td>		
			<span id="resp" style="color: red;"></span>
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