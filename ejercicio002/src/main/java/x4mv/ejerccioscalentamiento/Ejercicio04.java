package x4mv.ejerccioscalentamiento;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {

    Ejercicio04(){

    }
    
    public void getValues(){

        Scanner scan = new Scanner(System.in);


        System.out.println("Ingrese un numero: ");
        String digits = scan.nextLine();

        int[] digitsArr = new int[digits.length()];

        for(int i =0 ; i < digitsArr.length; i++){
            try{
                digitsArr[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
            }catch (NumberFormatException e) {
                System.out.println("No son digitos \n" + e);
                System.out.println("fin del programa \n");
                System.exit(0);
            }
        }

        // imprimiendo un arreglo de enteros en una linea
        System.out.println(Arrays.toString(digitsArr));

    }

   
}
