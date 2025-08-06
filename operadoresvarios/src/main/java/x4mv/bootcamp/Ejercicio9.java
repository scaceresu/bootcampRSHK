package x4mv.bootcamp;

import java.util.Scanner;

public class Ejercicio9 {

    private int intentos = 3;
    private String password = "abc";

    Ejercicio9(){

    }

    public void tryPassword(){

        Scanner scan = new Scanner(System.in);

        while (intentos > 0){
            System.out.println("Te quedan " + intentos + " intentos");
            System.out.println("Ingrese una password");


            while (!scan.hasNextLine()) {
            System.out.println("Entrada inválida. Por favor, ingrese un formato valido (string).");
            scan.next(); 
            System.out.print("Ingrese una password: ");
        }


            String userTry = scan.nextLine();

            if (userTry.equals(password)){
                System.out.println("Correcto");
                break;
            }else{
                System.out.println("password incorrecto");
                this.intentos -= 1;
            }
        }

        if (intentos == 0){
            System.out.println("Fallaste jaja!!");
        }

    
       
    }
    
}
