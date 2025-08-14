
 // definir los atributos 
    let turno = 0;
    let vecesEmpezadas = 0;
    let juegoTerminado = null;
    turnoShow = document.getElementById('turnoShow');


document.addEventListener('DOMContentLoaded', e =>{

   

    // Capturamos el btn 
    let empezarBtn = document.getElementById('empezarBtn');

    // calculando quien va a empezar el juego
    empezarBtn.addEventListener('click', e => {
        e.preventDefault();
        // seleccionar el turno
        turno = quienEmpieza();

    })

    // cuando alguien haga algun click en el dom

document.addEventListener('click', e => {
    const elementClicked = e.target;

    if (elementClicked.dataset.state === 'disponible') {
        rellenarCampo(elementClicked);
        const resultado = checkWinOrTie();

        if (resultado === true) {
            alert(`¡Hay un ganador es ${turno === 0 ? 'el O': 'la X' } `);
            clear();
        } else if (resultado === false) {
            alert('Empate!');
            clear();
        }

        turno = turno === 0 ? 1 : 0;
    }
});

})


// ===> Lista de funciones <===

function quienEmpieza(){

    clear();
    nroRandom = generarNumeroRandom(0,1);

    if (nroRandom == 0){
        console.log("Empieza la O");
        turnoShow.textContent = "Empieza el  O"; 
        turno = 0;
        vecesEmpezadas +=1;
        return 0;
    }else{
        console.log("Empieza la X");
        turnoShow.textContent = "Empieza la X"; 
        turno = 1;
        vecesEmpezadas +=1;
        return 1;
    }
    
}


function generarNumeroRandom(min, max){
       return Math.floor(Math.random() * (max - min + 1) + min);
  }

// rellenar el campo 
function rellenarCampo(element){
   
    if (element.dataset.state == 'disponible' && turno == 0){
        element.textContent = 'O';
        element.dataset.state = 'bloqueado';
        turnoShow.textContent = "Turno de la X"
    }else{
        element.textContent = 'X';
        element.dataset.state = 'bloqueado';
        turnoShow.textContent = "Turno del O"
    }

}

// limpiar todos los campos

function clear(){

    let respuesta = false

    if (vecesEmpezadas > 0){
        respuesta = confirm("Estas seguro que deseas reiniciar el juego ? se perdera todo el progreso");
    }

    if (respuesta){
        const celdas = document.querySelectorAll("th, td");

        // Cambia atributos para todos
        celdas.forEach(celda => {
            celda.dataset.state = "disponible";  
            celda.textContent= "";                
        });
    }
    
}



// Función para verificar ganador o empate
function checkWinOrTie() {
    const table = document.querySelector('table');
    const header = Array.from(table.querySelectorAll('thead th'));
    const rows = Array.from(table.querySelectorAll('tbody tr'));

    // Matriz del tablero
    const board = [
        header.map(cell => cell.textContent),
        Array.from(rows[0].querySelectorAll('td')).map(cell => cell.textContent),
        Array.from(rows[1].querySelectorAll('td')).map(cell => cell.textContent)
    ];

    const states = [
        header.map(cell => cell.dataset.state),
        Array.from(rows[0].querySelectorAll('td')).map(cell => cell.dataset.state),
        Array.from(rows[1].querySelectorAll('td')).map(cell => cell.dataset.state)
    ];

    // Función que detecta línea ganadora
    const isWinningLine = (a, b, c) => (a !== '' && a === b && b === c);

    // Revisar filas
    for (let i = 0; i < board.length; i++) {
        if (isWinningLine(board[i][0], board[i][1], board[i][2])) return true;
    }

    // Revisar columnas
    for (let i = 0; i < 3; i++) {
        if (isWinningLine(board[0][i], board[1][i], board[2][i])) return true;
    }

    // Revisar diagonales
    if (isWinningLine(board[0][0], board[1][1], board[2][2])) return true;
    if (isWinningLine(board[0][2], board[1][1], board[2][0])) return true;

    // Empate si todas las celdas están bloqueadas
    const allBlocked = states.flat().every(state => state === 'bloqueado');
    if (allBlocked) return false; // empate

    return null; // juego continúa
}
