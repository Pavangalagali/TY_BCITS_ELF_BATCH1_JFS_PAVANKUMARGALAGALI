<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <spring:url  var="css" value="/resources/css"></spring:url>
    <spring:url  var="js" value="/resources/javascript"></spring:url>
    <spring:url  var="images" value="/resources/images"></spring:url>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="${css}/signup.css">
    
 
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark " style="height: 70px;">
        <div class="container">
          
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item ">
                <a class="nav-link" style="font-size:larger" href="./consumerLogin">Login  </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    
    <div class="container">
      <%if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: white;"> <%=errMsg%></h2>
	<% } %>
        <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5 mx-auto d-block ">
            <form  onsubmit="goToLogin()" action="./userSignup" method="post">
              
                <div class="row ">
                    <div class="col mt-3">
                        <label>Firstname</label>
                        <input type="text"  id="fname" name="firstName" class="form-control " placeholder="First name">
                    </div>

                    <div class="col mt-3">
                        <label class="">Lastname</label>
                        <input type="text" name=lastName id="lastName" class="form-control" placeholder="Last name">
                    </div>
                </div><br>
                <div>
                    <label class="">Meter Number/RR Number</label>
                    <input type="text"  name="rrNumber"  id="mNumber" class="form-control" placeholder="Meter Number/RR Number">
                </div><br>
                <div class="row ">
                    <div class="col mt-3">
                        <label>Email</label>
                        <input type="email" name="eMail" id="email" class="form-control" placeholder="Email">
                    </div>

                    <div class="col mt-3">
                        <label class="">Phone Number</label>
                        <input type="tel" name="phoneNumber" id="pNumber" class="form-control" placeholder="Phone Number">
                    </div>
                </div><br>

                    <label class="">Address</label>
                    <input type="text" name="houseNo" class="form-control " placeholder="House Number">
                    <input type="text" name="address1"class="form-control mt-3" placeholder="Address Line 1">
                    <input type="text" name="address2" class="form-control mt-3" placeholder="Address Line 1">
                    <br>
                    <div class="form-row">

                        <div class="form-group col-md-6">
                            <label for="inputRegion">Region</label>
                            <select name="region" id="inputRegion" class="form-control">
                                <option selected disabled>Choose...</optionselected> 
                                <option value="south">Banglore South</option>
                                <option value="north">Banglore North</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputConsumer">Type Of Consumer</label>
                            <select  name="consumerType"   id="inputConsumer" class="form-control">
                                <option selected disabled>Choose...</option>
                                <option value="residential">Residential consumers</option>
                                <option value="commercial">Commercial consumers</option>
                                <option value="industries">Industries</option>
                            </select>
                        </div>
                    </div><br>
                
                <div class="row">
                    <div class="col mt-3">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" placeholder="Password">

                    </div>

                    <div class="col mt-3">
                        <label class="">Confirm Password</label>
                        <input type="password"  name="confirmPwd" class="form-control" placeholder="Confirm Password">
                    </div>
                </div><br>
               
                <button type="submit" class="btn btn-primary c mx-auto d-block mt-2 " >Sign In</button> 
    
            </form>
        </div>
    </div>
    <script src="${js}/jquery-3.2.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>

