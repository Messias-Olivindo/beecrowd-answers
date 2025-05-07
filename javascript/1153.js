var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var numb = Number(lines[0]);

var fat = 1;

for (let i = numb; i > 0; i --){
    fat = fat * i;
}

console.log(fat);
