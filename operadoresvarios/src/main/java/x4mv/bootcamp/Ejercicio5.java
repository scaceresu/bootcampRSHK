package x4mv.bootcamp;

import java.util.Scanner;

public class Ejercicio5 {
    
    Ejercicio5(){

    }

    public void esDivisible(){

        Scanner scan = new Scanner(System.in);
        

        while (!scan.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            scan.next(); 
            System.out.print("Ingrese un número: ");
        }

        int number = scan.nextInt();
        

        if (number % 2 == 0){
            System.out.println("Es divisible entre 2");
        }else{
            System.out.println("No es divisible entre 2");
        }

    }

}
