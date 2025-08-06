package x4mv.ejerccioscalentamiento;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio01 {


    Ejercicio01(){

    }

    int[] nums = new int[10];
    

    public int[] generarNumeros(){

        for (int i = 0 ; i < nums.length ; i++){

            Random rand = new Random();
            nums[i] = rand.nextInt(-5, 5);

        }

        return nums;
    }

    public void mostrarNumeros(int[] arr){

        String arregloString = Arrays.toString(arr);
        System.out.println("Imprimiendo arreglo");
        System.out.println(arregloString);

    }

    public void encontrarMayor(int[] arr){

        Arrays.sort(arr);

        mostrarNumeros(arr);
        int mayor = arr[arr.length - 1];
        
        System.out.println("El nro mayor es: " + mayor);
        
    }
    
}
