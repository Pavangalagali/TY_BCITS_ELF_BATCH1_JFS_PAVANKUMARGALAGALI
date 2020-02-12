function validateReadings() {
	
	var initialReading = document.getElementById("init").value;
	var finalReading = document.getElementById("final").value;
	
	var format = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?a-zA-Z]+/;
	
	var finalValid = false;
	
	
	
	//id validation
	if (finalReading == "") {
        document.getElementById("finalUnits").innerHTML = "*Please fill this field";
        return false;
    } else if (format.test(finalReading)) {
        document.getElementById("finalUnits").innerHTML = "*Should not contain character";
        return false;
    } else if (finalReading < initialReading) {
        document.getElementById("finalUnits").innerHTML = "*Should be  more than initial Reading";
        return false;
    }else {
        document.getElementById("finalUnits").style.display = 'none';
        finalValid = true;
    }
	
	
    
    if (finalValid) {
    	
    	form.method = 'POST';
		document.body.appendChild(form);
		form.submit();
		return true;
	}
   
}