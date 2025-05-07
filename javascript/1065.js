var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var numbArray = lines

//Removendo elementos vazios
.filter( str => str.trim() !== '')
//Transformar strings em números
.map( str => Number(str))

//Verificar se é par
var cont = 0;
for( let i = 0; i < numbArray.length; i++){
    if( numbArray[i] % 2 === 0){
        cont ++;
    }
}
console.log(cont + " valores pares");
