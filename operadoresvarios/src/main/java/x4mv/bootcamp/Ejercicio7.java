package x4mv.bootcamp;

public class Ejercicio7 {

    Ejercicio7(){

    }

    public void mostrarNumeros(){

        for(int i = 0 ; i <= 100 ; i++){

            if (i % 2 == 0 && i % 3 ==0){
                System.out.println("numero divisibles entre 2 y 3: " + i);
            }
        }
    }
    
}
