package x4mv.ejerccioscalentamiento;

import java.util.Scanner;

public class Ejercicio03 {

    Ejercicio03(){

    }

    public void esPalindormo(){

        boolean esPalindromo = true;

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese una palabra");
        String palabra = scan.nextLine().toLowerCase().replaceAll("\\s+", "").trim();

        for (int i = palabra.length() - 1, j = 0; i > j; i--, j++) {
            if (palabra.charAt(i) != palabra.charAt(j)) {
                esPalindromo = false;
                break;
            }
        }

            if (esPalindromo) {
                System.out.println("Es palindromo");
            } else {
                System.out.println("No es palindromo");
            }


        

    }
    
}
