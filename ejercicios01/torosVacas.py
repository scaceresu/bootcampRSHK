import random

#validaciones que tiene que pasar
noComienzaCero = False
nrosDistintos = False

#bandera para que empiece el juego
terminaJuego = False

#rellenar el arreglo con numeros aleatorios
clave = []

#funcion para generar lista
def generarClave(clave):

    for digito in range(4):

        nro_random = random.randint(0,9)
        clave.append(nro_random)


while ( noComienzaCero == False or nrosDistintos == False):
    generarClave(clave)
    
    #verificamos que no haya repetidos 
    setClave = set(clave)
    
    #verificar que no comience en 0 
    if clave[0] == 0:
        print("La clave comienza en 0 ")
        noComienzaCero = False
    else:
        noComienzaCero = True
        
    if len(setClave) != len(clave):
        print("Existen elementos repetidos")
        nrosDistintos = False
    else: 
        nrosDistintos = True
    
    if (nrosDistintos and noComienzaCero):
        break
        
    clave = []


while noComienzaCero and nrosDistintos and terminaJuego == False : 
    
    #definiendo vacas y toros 
    vacas = 0
    toros = 0
    
    print("la clave es: ", clave)
    #pedimos los datos al usuarios
    
    guess = input("Ingrese un codigo de 4 digitos: ")
    
    while len(guess) != 4:
        if isinstance(guess, str):
            print("==> No se aceptan letras o simbolos <==")
            guess=input("Ingrese un numero: ") 
        print("===> Longitud Erronea <==")
        guess=input("Ingrese un codigo valido: ")
    
    #dividimos los digitos 
    guess1 = int(guess[0])
    guess2 = int(guess[1])
    guess3 = int(guess[2])
    guess4 = int(guess[3])
    
    claveUsuario = [guess1, guess2, guess3, guess4]
    
    #en el caso ganador 
    if guess1 == clave[0] and guess2 == clave[1] and guess3 == clave[2] and guess4 == clave[3]:
        print("Haz encontrado la clave!")
        terminaJuego = True
    
    #definir vacas y toros 
    for index,digito in enumerate(claveUsuario):
        
        if digito in clave and digito == clave[index]:
            toros += 1
        elif digito in clave: 
            vacas += 1
        
        
    print(f"Tienes {toros} toros y {vacas} vacas ")
    
        
    


print(clave)
    
