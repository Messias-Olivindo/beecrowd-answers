var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

//Função para calcularmdc
function calcularMdc(a, b) {
    while (b) {
        var temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

var csTestes = Number(lines[0]);
let tempNumb;

for (let i = 1; i < csTestes + 1; i++) {
    tempNumb = lines[i]
        .split(' ')
        .map(str => Number(str));

    console.log(calcularMdc(tempNumb[0], tempNumb[1]));
}
