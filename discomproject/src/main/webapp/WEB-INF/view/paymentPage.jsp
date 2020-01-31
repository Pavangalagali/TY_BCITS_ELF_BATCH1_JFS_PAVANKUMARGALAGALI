<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/javascript"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Payment</title>
</head>

<body>
    <div class="container">
        <div class="  col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 ">
        <div class="  row ">
            <div class="col-sm-6  mx-auto d-block " style="margin-top: 110px;">
                <div class="alert alert-info" role="alert">
                    <p>Please enter your card details below.</p>
                </div>
                <hr />
              
                <div class="form-group">
                    <label class="control-label" for="username">Card Holder's Name</label>

                    <div class="controls">
                        <input type="text" id="username" name="username" placeholder="Mr/Ms XYZ" class="form-control" disabled>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label" for="card_number">Card Number</label>

                    <div class="controls">
                        <input type="text" id="card_number" name="card_number" placeholder="xxxx-xxxx-xxxx" class="form-control" disabled>
                    </div>
                </div>
                <hr />
   
                <div class="form-group">
                    <label class="control-label" for="expiry_month">Card Expiry Date</label>

                    <div class="row">
                        <div class="col-sm-4">
                            <select class="form-control" name="expiry_month" id="expiry_month" >
                                <option>----</option>
                                <option value="01">Jan (01)</option>
                                <option value="02">Feb (02)</option>
                                <option value="03">Mar (03)</option>
                                <option value="04">Apr (04)</option>
                                <option value="05">May (05)</option>
                                <option value="06">June (06)</option>
                                <option value="07">July (07)</option>
                                <option value="08">Aug (08)</option>
                                <option value="09">Sep (09)</option>
                                <option value="10">Oct (10)</option>
                                <option value="11">Nov (11)</option>
                                <option value="12">Dec (12)</option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control" name="expiry_year">
                                <option value="">-----</option>
                                <option value="13">2013</option>
                                <option value="14">2014</option>
                                <option value="15">2015</option>
                                <option value="16">2016</option>
                                <option value="17">2017</option>
                                <option value="18">2018</option>
                                <option value="19">2019</option>
                                <option value="20">2020</option>
                                <option value="21">2021</option>
                                <option value="22">2022</option>
                                <option value="23">2023</option>
                            </select>
                        </div>
                    </div>
                </div>
                <hr />
                <div class="row">
                    <div class="col-sm-3">
                        <!-- CVV -->
                        <div class="form-group">
                            <label class="control-label" for="password_confirm">Card CVV</label>


                            <input type="password" id="password_confirm" name="password_confirm" placeholder="xxx"
                                class="form-control" disabled  >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3">
                        <div class="form-group">
                           <a href="./paymentDone"> <button class="btn btn-success">Pay Now</button></a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
    </div>
    <script src="${js}/jquery-3.2.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>

</html>