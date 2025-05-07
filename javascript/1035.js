var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

//remove string vazia
var numbArray = lines.filter(
    str => str.trim() !== ''
    )
//separa a string em um único array
.flatMap(
    str => str.split(' ')
    )
//tranformar em números
.map(
    str => Number(str)
    );
    

//Condição para ser aceito
if ((numbArray[1] > numbArray[2]) && 
    (numbArray[3] > numbArray[0]) && 
    ((numbArray[2] + numbArray[3]) > (numbArray[0] + numbArray[1])) && 
    (numbArray[2] > 0) && 
    (numbArray[3] > 0) && 
    ((numbArray[0] % 2) === 0) ) 
{
    console.log("Valores aceitos");
}
else{
    console.log("Valores nao aceitos");
}