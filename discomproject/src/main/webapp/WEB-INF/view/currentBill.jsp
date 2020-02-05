<%@page import="java.util.List"%>
<%@page import="com.bcits.discomproject.beans.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>
 
 <%  Double initReading=0.0;
 	String msg = (String) request.getAttribute("msg"); 
     String errMsg = (String) request.getAttribute("errMsg"); 
     List<MonthlyConsumption> consumption = (List<MonthlyConsumption>) request.getAttribute("consumptions");
     if(consumption != null){ 
    	for(MonthlyConsumption month :consumption){    		
    		if(month.getPreviousUnits()!=null){
    		initReading = month.getFinalUnits();	
    		}
    	}
    } %>
    <% String rrNumber = (String) request.getAttribute("rrNumber"); %>
<jsp:include page="employeeHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/home.css">
<title>Insert title here</title>
</head>
<body style="color: silver;">
<div  class="card col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 mt-5 mx-auto d-block">

    <h5 class="card-header info-color white-text text-center ">
        <strong>Enter Details</strong>
    </h5>

    <div class="card-body px-lg-5 pt-0">
	<%if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: orange;"> <%=errMsg%></h2>
	<% } %>
       
        <form class="text-center" style="color: #757575;" action="./generateBill" method="post">


          <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label>RR-Number</label>
                        <label>:<%=rrNumber %></label>
                        <input type="text" name="rrNumber" value="<%=rrNumber %>"class="form-control" hidden="true">
                    </div>                
           </div><br>
               
               <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label class="">Initial Readings</label>
                          <label>:<%=initReading %></label>
                        <input type="number" name="initialUnits" id="" class="form-control" value="<%=initReading %>" hidden="true">
                    </div>
                    <div class="col mt-3">
                        <label>Final Reading</label>
                        <input type="number" name="finalUnits" id="" class="form-control" placeholder="Enter Final Reading">
                    </div>
                </div><br> 
           
           <div class="row " style="text-align: left;">
                               <div class="col mt-3">
                        <label>Statement Date</label>
                        <input type="date" name="readingsTakenOn" id="" class="form-control" placeholder="statemented date">
                    </div>

                    <div class="col mt-3">
                        <label >Due Date</label>
                      
                        <input type="date" name="dueDate" id="" class="form-control" placeholder="Due Date">
                    </div>
                </div><br> 
           
            <button type="submit" class="btn btn-primary c mx-auto d-block mt-2 ">Generate</button>
        </form>
    </div>

</div>

<script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>