function verify() {
	
	var employeeId = document.getElementById("empId").value;
	var fname = document.getElementById("fname").value;
	var designation = document.getElementById("role").value;
	var email = document.getElementById("email").value;
	var psw = document.getElementById("psw").value;
	var cpsw = document.getElementById("cpsw").value;
	
	var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?0-9]+/;
	var format2 = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;
	
	var fnameValid = false;
	var empIdValid = false;
	var roleValid = false;
	var emailValid = false;
	var pswValid = false;
	var cpswValid = false;
	
	
	// name validation
	if (fname == "") {
        document.getElementById("fullname").innerHTML = " *Please fill the Full name field";
        return false;
    } else if ((fname.length < 3) || (fname.length > 30)) {
        document.getElementById("fullname").innerHTML = "*Length must be between 3 and 30";
        return false;
    } else if (format.test(fname)) {
        document.getElementById("fullname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("fullname").style.display = 'none';
        fnameValid = true;
    }
	
	//id validation
	if (employeeId == "") {
        document.getElementById("employeeId").innerHTML = "*Please fill ID  field";
        return false;
    } else if (format2.test(employeeId)) {
        document.getElementById("employeeId").innerHTML = "*Should Not contains character";
        return false;
    } else {
        document.getElementById("employeeId").style.display = 'none';
        empIdValid = true;
    }
	
	//designation validation
	if (designation == "") {
        document.getElementById("designation").innerHTML = " *Please fill the designation field";
        return false;
    } else if ((designation.length < 3) || (designation.length > 30)) {
        document.getElementById("designation").innerHTML = "*Length must be between 3 and 30";
        return false;
    } else if (format.test(designation)) {
        document.getElementById("fullname").innerHTML = "*Name Should Not contains Special character & Number";
        return false;
    } else {
        document.getElementById("designation").style.display = 'none';
        roleValid = true;
    }
	
	//email validation
	if (email == "") {
        document.getElementById("emailid").innerHTML = " *Please fill Email field";
        return false;
    } else if (email.length < 6) {
        document.getElementById("emailid").innerHTML = "*Please Enter proper email Id";
        return false;
    } else {
        document.getElementById("emailid").style.display = 'none';
        emailValid = true;
    }
	
	 //Password Validation

    if (psw == "") {
        document.getElementById("password").innerHTML = "*Please fill Password field";
        return false;
    } else if (psw.length < 4) {
        document.getElementById("password").innerHTML = "*Should contains more than 4 character";
        return false;
    } else {
        document.getElementById("password").style.display = 'none';
        pswValid = true;
    }
    //confirm password.

    if (cpsw == "") {
        document.getElementById("confirmpassword").innerHTML = "*Please fill field";
        return false;
    } else if (psw != cpsw) {
        document.getElementById("confirmpassword").innerHTML = "*Password is not matched";
        return false;
    } else {
        document.getElementById("confirmpassword").style.display = 'none';
        cpswValid = true;
    }
    
    if (fnameValid &&  empIdValid && roleValid && emailValid && pswValid &&  cpswValid ) {
    	
    	form.method = 'POST';
		document.body.appendChild(form);
		form.submit();
		return true;

	}
   
}