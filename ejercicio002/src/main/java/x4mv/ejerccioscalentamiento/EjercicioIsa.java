package x4mv.ejerccioscalentamiento;

import java.util.Scanner;

public class EjercicioIsa {


        EjercicioIsa(){

        }

        public void esP(){
            
            String reversa = "";
        Scanner teclado = new Scanner(System.in);
        // Leer entrada y limpiar caracteres no alfabéticos
        String palabra = teclado.nextLine();
        String palabraModificada = palabra.replaceAll("[^a-zA-Z]", "");
        // Invertir la cadena
        for (int i = palabra.length() - 1; i >= 0; i--) {
            reversa = reversa + palabra.charAt(i);
        }
        System.out.println(reversa);
        // Verificar si es palíndromo
        if (palabra.equals(reversa)) {
            System.out.println("Es un palíndromo.");
        } else {
            System.out.println("No es un palíndromo.");
        }

        }
        
        
}
