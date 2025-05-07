var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

//print number
let number = parseInt(lines[0]);
console.log("NUMBER = " + number);

//print salary
let salary = parseFloat(lines[1] * lines[2]);
console.log("SALARY = U$ " + salary.toFixed(2));