<%@page import="com.bcits.discomproject.beans.EmployeeMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url var="js" value="/resources/javascript"></spring:url>
   <%  String msg = (String) request.getAttribute("msg"); %>
   <% List<EmployeeMaster> masters =(List<EmployeeMaster>) request.getAttribute("employees"); %>
   
<jsp:include page="nav.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>home</title>
</head>
<body>
      
    <div class="card-body col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12" style="margin-top: 200px;margin-left: 460px;">
        <%if (msg != null && !msg.isEmpty()) { %>
	   <h2 style="color: blue;"> <%=msg%></h2>
	   <% } %>	
        
        <h1 style="color: blue;font-style: oblique;">Welcome  Admin</h1>
  <a href="./empGrant">  <button type="button" class="btn btn-dark btn-lg " style="margin-top: 30px;"><i class="fa fa-male"></i>Grant  Employee Access </button></a>
  <a href="./revoke"> <button type="button" class="btn btn-info btn-lg " style="margin-top: 30px;"><i class="fa fa-male"></i> Revoke Access</button></a>
    </div>
    
    	<% if(masters != null){ %>
		       <div class=" col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mt-3">
		       <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Employee Deatils</h4></legend>
              <table class="table table-sm table-dark mt-2">
                    <tr >
                <thead>
                 
                     <th scope="col">ID</th>
                         <th scope="col">Name</th>
                         <th scope="col">Designation</th>
                         <th scope="col">Region</th>
                         <th scope="col"></th>                        
                   </tr>
                   
             </thead>
		    <tbody>
		    <% for(EmployeeMaster master : masters){ %>
		      <form action="./revokeEmployee" method="get">   	
		      <input name ="id" type="number"
		      value="<%=master.getId() %>"  hidden="true"/>	
		       	<tr>
					<td><%=master.getId()%></td>
					<td><%=master.getName()%></td>
					<td><%=master.getRole() %></td>
					<td><%=master.getRegion()%></td>
					<td>
			  	<button type="submit"  class="btn btn-info btn-lg">Revoke</button>
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