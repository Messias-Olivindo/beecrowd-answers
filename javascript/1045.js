var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var numbArray = lines

    //Tirar elementos vazios
    .filter(str => str.trim() !== '')

    //Separar a string em elementos separados
    .flatMap(str => str.split(' '))

    //Transformar as strings em números
    .map(str => Number(str))

    //Ordernar do maior para o menor
    .sort((a, b) => b-a);


//Verificação de triângulo

//Não é triangulo
if (numbArray[0] >= (numbArray[1] + numbArray[2])) {
    console.log("NAO FORMA TRIANGULO");
}
else {
//triangulo retangulo
    if (Math.pow(numbArray[0], 2) === (Math.pow(numbArray[1], 2) + Math.pow(numbArray[2], 2))) {
        console.log("TRIANGULO RETANGULO");
    }
    //triangulo obtusangulo
    else if (Math.pow(numbArray[0], 2) > (Math.pow(numbArray[1], 2) + Math.pow(numbArray[2], 2))) {
        console.log('TRIANGULO OBTUSANGULO');
    }
    //triangulo ACUTANGULO
    else if (Math.pow(numbArray[0], 2) < (Math.pow(numbArray[1], 2) + Math.pow(numbArray[2], 2))) {
        console.log('TRIANGULO ACUTANGULO');
    }
    //TRIANGULO equilatero
    if ((numbArray[0] === numbArray[1]) && (numbArray[1] === numbArray[2])) {
        console.log("TRIANGULO EQUILATERO");
    }
    //TRIANGULO ISOSCELES
    else if ((numbArray[0] === numbArray[1]) || (numbArray[1] === numbArray[2]) || (numbArray[0] === numbArray[2])) {
        console.log("TRIANGULO ISOSCELES");
    }
}