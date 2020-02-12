function check() {

	var employeeId = document.getElementById("empId").value;
	var psw = document.getElementById("psw").value;

	var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;

	var empIdValid = false;
	var pswValid = false;

	// id validation
	if (employeeId == "") {
		document.getElementById("employeeId").innerHTML = "*Please fill ID  field";
		return false;
	} else if (format.test(employeeId)) {
		document.getElementById("employeeId").innerHTML = "*Should Not contains character";
		return false;
	} else {
		document.getElementById("employeeId").style.display = 'none';
		empIdValid = true;
	}

	// Password Validation

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

	if (empIdValid && pswValid) {

		form.method = 'POST';
		document.body.appendChild(form);
		form.submit();
		return true;

	}
}