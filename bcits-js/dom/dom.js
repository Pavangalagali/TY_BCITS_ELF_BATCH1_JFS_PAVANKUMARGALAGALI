var element = document.getElementById('demo')
console.log(element);
console.log(element.textContent);
element.textContent = 'this is awesome'

var helement = document.createElement('h2');
helement.textContent = ' Hi'
document.body.appendChild(helement)
helement.style.fontSize='40px'
helement.style.color='red'