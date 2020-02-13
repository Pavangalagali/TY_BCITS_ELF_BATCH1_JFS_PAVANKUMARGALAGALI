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

       
        <form id="formData" class="text-center" style="color: #757575;" onsubmit="verify(); return false"   method="post">


          <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label for="empId">Employee Id</label>
                        <input type="number" name="id" id="empId" class="form-control" placeholder="Employee Id">
                         <span id="employeeId" style="color:orange ;"></span>
                    </div>

                    <div class="col mt-3">
                        <label for="fname">Full name</label>
                        <input type="text" name="name" id="fname" class="form-control" placeholder="Full name">
                          <span id="fullname" style="color:orange ;"></span>
                    </div>
           </div><br>
           
               
               <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label for="role">Designation</label>
                        <input type="text" name="role" id="role" class="form-control" placeholder="Designation">
                        <span id="designation" style="color:orange ;"></span>
                    </div>

                    <div class="col mt-3">
                        <label for="email">E-mail</label>
                        <input type="email" name="eMail" id="email" class="form-control" placeholder="Email Id">
                        <span id="emailid" style="color: orange;"></span>
                    </div>
                </div><br> 
           
            
             <div class="form-row" >

                        <div class="form-group col-md-6 " style="text-align: left">
                            <label >Region</label>
                            <select name="region"  class="form-control" required="required">
                                <option selected disabled>Choose...</optionselected> 
                                <option value="Banglore South">Banglore South</option>
                                <option value="Banglore North">Banglore North</option>
                            </select>
                        </div>
                        </div>
                        <br>
            
            <!-- Password -->
            <div class="row " style="text-align: left;">
                    <div class="col mt-3">
                        <label for="psw">Password</label>
                        <input type="password" name="password" id="psw" class="form-control" placeholder="Password">
                         <span id="password" style="color: orange;"></span>
                    </div>

                    <div class="col mt-3">
                        <label for="cpsw">Confirm Password</label>
                        <input type="password" name="pwd" id="cpsw" class="form-control" placeholder="Confirm Password">
                       <span id="confirmpassword" style="color: orange;"></span>
                    </div>
                </div><br> 
            <button type="submit" formaction="./grantAccess" class="btn btn-primary c mx-auto d-block mt-2 " >Submit</button>
        </form>
    </div>

</div>
 <script src="${js}/jquery-3.2.1.min.js"></script> 
   <script src="${js}/grantPage.js"></script>
    <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</body>
</html>