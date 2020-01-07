var pelement = document.createElement('p')


function showAlert() {
    alert('Hi welcome to BCITS')
}

function myElement() {
    pelement.textContent = ' This  Is JavaScript Class'
    pelement.style.fontSize = '40px';
    pelement.style.color = 'green'
    document.body.appendChild(pelement);
}
function displayElement() {

    var dispElement = document.getElementById('disp')
    var button = document.getElementById('hide')
    if (dispElement.style.display === '' || dispElement.style.display === 'none') {
        dispElement.style.display = 'block'
        button.textContent = 'click to hide element'
    }else{
        dispElement.style.display = 'none'
        button.textContent = 'click to show element'
    }
}
function mouseOver(){
    var pTag = document.getElementById("ptag")
    pTag.style.fontSize = '50px'
    pTag.style.color ='red'
    pTag.style.backgroundColor='yellow'
}
function mouseOut(){
    var pTag = document.getElementById("ptag")
    pTag.style.fontSize = '18px'
    pTag.style.color ='black'
    pTag.style.backgroundColor='white'
}
function showData(){
    console.log('working...!');
    
}
function showDetails(){
    console.log("onkey down executed")
}
var showElement = document.getElementById('show')
var input;
function getInputValue() {
     input =document.getElementById('secondInput')
    console.log(input.value)
    
    showElement.textContent = input.value
}


