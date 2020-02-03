<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>


<jsp:include page="nav.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	
     <div  class="card col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 mt-5 mx-auto d-block">

    <h5 class="card-header info-color white-text text-center ">
        <strong>Enter Employee Details</strong>
    </h5>

    
    <div class="card-body px-lg-5 pt-0">

       
        <form class="text-center" style="color: #757575;" action="./grantAccess" method="post">


          <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label>Employee Id</label>
                        <input type="number" name="id" id="email" class="form-control" placeholder="Employee Id">
                    </div>

                    <div class="col mt-3">
                        <label class="">Full name</label>
                        <input type="text" name="name" id="" class="form-control" placeholder="Full name">
                    </div>
           </div><br>
           
               
               <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label>Designation</label>
                        <input type="text" name="role" id="" class="form-control" placeholder="Designation">
                    </div>

                    <div class="col mt-3">
                        <label class="">E-mail</label>
                        <input type="email" name="eMail" id="" class="form-control" placeholder="Email Id">
                    </div>
                </div><br> 
           
            
            <div class="md-form" style="text-align: left;">
                <label >Region</label>
                <input type="text"  name="region" class="form-control" placeholder="Region" >
            </div>
            <!-- Password -->
            <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label>Password</label>
                        <input type="password" name="password" id="" class="form-control" placeholder="Password">
                    </div>

                    <div class="col mt-3">
                        <label class="">Confirm Password</label>
                        <input type="password" name="pwd" id="" class="form-control" placeholder="Confirm Password">
                    </div>
                </div><br> 
            <button type="submit" class="btn btn-primary c mx-auto d-block mt-2 " >Submit</button>
        </form>
    </div>

</div>
 <script src="${js}/jquery-3.2.1.min.js"></script> 
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>