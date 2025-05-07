var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var R = parseFloat(lines);

console.log("A="+ (3.14159 * R * R).toFixed(4));