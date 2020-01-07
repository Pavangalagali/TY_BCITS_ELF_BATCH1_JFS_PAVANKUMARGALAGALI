function validateForm() {
    var loginForm = document.forms['loginForm']
    var mailId = loginForm['userEmail'].value;
    var pwd = loginForm['userPassword'].value;

    console.log('User Mail = ', mailId);
    console.log('password = ', pwd);
    console.log(loginForm);

    if (mailId.trim().length > 6) {
        document.getElementById('emailErr').style.display='none'
         loginForm['userEmail'].style.borderColor=''
        console.log('user mail is valid');
    } else {
        document.getElementById('emailErr').style.display='block'
         loginForm['userEmail'].style.borderColor='red'
        console.log('user mail is invalid');
    }
    if (pwd.trim().length > 5) {
        console.log('password is valid');
    } else {
        console.log('password is invalid');
    }

}