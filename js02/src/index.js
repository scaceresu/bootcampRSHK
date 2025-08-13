// we define the 3 states possible 
previous = 0;
current ='';
collectHistory =""
prevOperation = ""


// dados 

// Ejemplo de uso:
const urls = [
    '../static/images/dado1.png',
    '../static/images/dado2.png',
    '../static/images/dado3.png',
    '../static/images/dado4.png',
    '../static/images/dado5.png',
    '../static/images/dado6.png'
];

// get the HTML elements when DOM LOADED

document.addEventListener('DOMContentLoaded', e => {

    let res = document.getElementById("res");
    let history = document.getElementById("history");

    let previous = 0;
    let current = '';
    let prevOperation = '';
    let collectHistory = '';

    document.addEventListener("click", e => {
        const elementClicked = e.target;
        const action = elementClicked.dataset.action;

        if (!action) return; // Si no tiene data-action, ignoramos

        // Si es un número
        if (!isNaN(action) || action == ".") {
            current += action; // acumulamos números
            collectHistory += action;
            res.innerHTML = current;
            history.innerHTML = collectHistory;

        // Si es una operación
        } else if (action == "+" || action == "-" || action == "*" || action == "/") {
            if (prevOperation && current !== "") {
                // hacemos la operación pendiente
                switch(prevOperation) {
                    case "+": previous += Number(current); break;
                    case "-": previous -= Number(current); break;
                    case "*": previous *= Number(current); break;
                    case "/": previous /= Number(current); break;
                }
            } else if (current !== "") {
                previous = Number(current);
            }

            prevOperation = action;
            current = "";
            collectHistory += action;
            res.innerHTML = previous; // mostramos resultado parcial
            history.innerHTML = collectHistory;

        // Si es igual
        } else if (action == "=") {
            if (prevOperation && current !== "") {
                switch(prevOperation) {
                    case "+": previous += Number(current); break;
                    case "-": previous -= Number(current); break;
                    case "*": previous *= Number(current); break;
                    case "/": previous /= Number(current); break;
                }
                res.innerHTML = previous;
                collectHistory = previous;
                history.innerHTML = collectHistory;
                current = "";
                prevOperation = "";
            }
        }else if (action == "c"){
                collectHistory = "";
                history.innerHTML = "";
                res.innerHTML = "";
                prevOperation = "";
                previous = 0;
        }

    });

});



// Answer Questions 

let answerElement = document.getElementById('answerConsole');
let btnDices = document.getElementById('btnDices');

// We wait until the DOM its fully loaded
document.addEventListener('DOMContentLoaded', e => {
    
    answerElement.addEventListener('click', e =>{
        e.preventDefault();

        alert("Mira la consola para ver las respuestas");
        alert("Calcular la raiz de una ecuacion ax^2+bx+c=0");
        a = Number(prompt("Ingrese la constante a"));
        b = Number(prompt("Ingrese la constante b"));
        c = Number(prompt("Ingrese la constante c"));
        positiveSQRT(a,b,c);
        negativeSQRT(a,b,c);

        id = prompt("Ingresar el id del elemento");
        texto = prompt("Ingresar el texto que tendra el elemento");
        addInner(id, texto);
        showRandomNumber();
    })

    btnDices.addEventListener('click', e => {
        e.preventDefault();
        showFiveDices(urls);
    })


})


function positiveSQRT(a,b,c){ 
    res = (-b + Math.sqrt(b**2 - 4*a*c))/2*a;
    console.log("La raiz cuadrada + es: ", res);
    
}

function negativeSQRT(a,b,c){
    res = (-b - Math.sqrt(b**2 - 4*a*c))/2*a;
    console.log("La raiz cuadrada - es: ", res);
   
}

function addInner(id, texto ){
    let divToAdd = document.getElementById("addedId");
    divToAdd.innerHTML += `<p id="${id}"> ${texto}</p>`;


}


function showRandomNumber(){
    let divToAdd =document.getElementById("addedId");
    randomNumber = generateRandomNumber(1,100);
    divToAdd.innerHTML += `Numero random generado: ${randomNumber}`;
}


function generateRandomNumber(min,max){
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max-min+1) + min)
}


function showFiveDices(urls) {
    const elementDice = document.getElementById('dados');
    elementDice.innerHTML = ''; // limpiar contenido previo

    // Mezclar el array de URLs usando Fisher-Yates
    for (let i = urls.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [urls[i], urls[j]] = [urls[j], urls[i]];
    }

    // Mostrar solo los primeros 5
    for (let i = 0; i < 5; i++) {
        const dice = document.createElement('img');
        dice.src = urls[i] || ''; // si no hay suficiente URL, queda vacío
        dice.alt = `Dado ${i + 1}`;
        dice.style.width = '50px';
        dice.style.margin = '5px';
        elementDice.appendChild(dice);
    }
}




