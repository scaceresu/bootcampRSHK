// validaciones que tiene que pasar
noComienzaCero = false
nrosDistintos = false

// bandera para que empiece el juego
terminaJuego = false

// rellenar el arreglo con numeros aleatorios
  clave = []

function generarClave(clave){

    for (let digito = 0; digito < 4; digito++) {

        nro_random = Math.floor(Math.random()*9)
        clave.push(nro_random);
    
    }
}

// verificando que se cumplan las condiciones 
while (noComienzaCero == false && nrosDistintos == false){
    
    generarClave(clave)

    // verificamos si encuentra un valor repetido
    const setClave = new Set(clave)
    
    // verificamos que el numero no comience en 0
    if (clave[0] == 0){
        console.log("La clave comienza en 0")
        noComienzaCero = false
    }else{
        noComienzaCero = true
    }


    if (setClave.size !== clave.length){
        console.log("Existen elementos repetidos")
        nrosDistintos = false
    }else{
        nrosDistintos = true
    }

    clave = []
}

console.log(noComienzaCero)
console.log(nrosDistintos)
console.log(terminaJuego)

