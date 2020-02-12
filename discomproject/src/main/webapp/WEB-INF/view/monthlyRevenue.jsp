<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomproject.service.BillCollected"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url var="css" value="/resources/css"></spring:url>
   <spring:url var="js" value="/resources/javascript"></spring:url>
	<% 
       List<Object[]> totalCollected = (List<Object[]>) request.getAttribute("paid");
       List<Object[]> totalPending = (List<Object[]>) request.getAttribute("pending");
     %>

<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Monthly Revenue</title>
</head>
<body style="background-color:#ffefcc"	>
	
	<div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Monthly Revenue</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid;">
            <thead>
              <tr >    
               
                <th scope="col">Date</th>    
                <th scope="col">Estimation</th> 
                <th scope="col" style="color: #009900">Collected Amount</th> 
                <th scope="col">Pending</th> 
              </tr>
            </thead>
		<tbody>
		<% double estimation = 0.0;
		
		for( int i=0 ;i<totalCollected.size();i++) {
			Object[] collected = totalCollected.get(i);
		      for( int j=0 ;j<totalPending.size();j++) {
			      Object[] pending = totalPending.get(j);
	 			if(pending[1].equals(collected[1])){
	 				estimation = (double)collected[0]+(double)pending[0];
	 				%>
	 				<tr >
	 				  <td ><%=collected[1]%></td>
	 				  <td ><%=estimation %></td>
	 				  <td ><%=collected[0]%></td>
	 				  <td ><%=pending[0] %></td>
	 				</tr> 
	 			<%}    
		 }
	  } 
   
		
		 Object[] collected = null;
		
		 for( int i=0 ;i<totalCollected.size();i++)   {
		boolean isPresent = false; 
			  collected = totalCollected.get(i);	
			  Object[] pending=null;
			for( int j=0 ; j <totalPending.size();j++){
				pending  = totalPending.get(j);
	 			if(pending[1].equals(collected[1])){
	 				isPresent = true;
					break;
	 			}	
	 			
		 }
			if(!isPresent){	%>
			<tr >
		       <td><%=collected[1] %></td>
		       <td><%=collected[0] %></td>
		       <td><%=collected[0] %></td>
			   <td><%=0.0 %></td>
		</tr> 
		<%}    
		      		
		}
		 
		for( int i=0 ;i<totalPending.size();i++) {
			Object[] pending = totalPending.get(i);
			collected = null;
        boolean isPresent = false;
		      for( int j=0 ; j<totalCollected.size();j++) {
		    	  collected  = totalCollected.get(j);
	 			
		    	  if(collected[1].equals(pending[1])){
		    		  isPresent = true;
					break;
	 			}
	 			
		 }
		      if(!isPresent){	%>
				<tr >
			       <td><%=pending[1] %></td>
			       <td><%=pending[0] %></td>
			       <td><%=0.0%></td>
				   <td><%=pending[0] %></td>
			</tr> 
			<%} 		      	
		}
	%>
			</tbody>
			</table>
		 </div>
	
    


<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>