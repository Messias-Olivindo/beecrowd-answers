var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var number = lines.map( str => Number(str));

console.log("DIFERENCA = "+ (number[0] * number[1] - number[2] * number[3]));