var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var number = lines.

//transformar em número
map( (str) =>{
    if (isNaN(Number(str))){
        return str;
    }
    else{
        return Number(str);
    }

});

console.log("TOTAL = R$ " + (number[1] + number[2] * 0.15).toFixed(2));