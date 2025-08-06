package x4mv.bootcamp;

import java.util.Scanner;

public class Ejercicio8 {

    public int numero;
    Ejercicio8(){

    }

    public void relacionCero(){

        System.out.println("Ingrese un numero entero que sea > 0: ");
        Scanner scan = new Scanner(System.in);
        do{

            while (!scan.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número valido.");
            scan.next(); 
            System.out.print("Ingrese un número: ");
        }

            
            numero = scan.nextInt();
            

        }while(numero <= 0);
        
    }
    
}
