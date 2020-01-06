console.log("----------------functions--------------------");


function add(a, b) {
    var c = a + b;
    return c;
}
var sum = add(10, 20);
console.log('Sum is ', sum);

//   Arrow function
var addM = (a,b) => a+b;
var s = addM(10,30);
console.log(`sum = ${s}`);

var sqr = a=> a*a;
var n = sqr(4)
console.log(`square of 4 id ${n}`);
console.log(`square of 10 id ${10*10}`);

console.log("----------------operators--------------------");
var n1 = 10;
var n2 = '10';
if (n1 === n2) {
    console.log("equal");

} else {
    console.log("not equal");

}


var nums = [10, 12, 14];
console.log(typeof nums);
console.log(typeof null);
console.log(typeof 10);
console.log(typeof true);
console.log(typeof 'hello');
console.log(typeof undefined);


var isAry = Array.isArray(nums)
if (isAry === true) {
    console.log('nums is an array');
} else {
    console.log('nums is not an array');
}

console.log(Array.isArray(sum))
