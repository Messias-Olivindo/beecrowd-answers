var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var number = lines.map( str => Number(str));

console.log("MEDIA = "+ (((number[0] * 2) + (number[1] * 3) + (number[2] * 5))/10).toFixed(1));
