var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var number = lines.map( str => Number(str));

console.log("MEDIA = "+ (((number[0] * 3.5) + (number[1] * 7.5))/11).toFixed(5));

