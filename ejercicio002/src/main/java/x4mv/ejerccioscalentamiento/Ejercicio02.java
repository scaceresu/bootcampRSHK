package x4mv.ejerccioscalentamiento;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Ejercicio02 {

    Ejercicio02(){

    }

    private int[] nums = new int[100];
    
    public int[] generarNumeros(){
        
        for (int i =0 ; i < nums.length ; i++){

            Random rand = new Random();
            nums[i] = rand.nextInt(-30, 30);
        }

        return nums;
    }

     public void mostrarNumeros(int[] arr){

        System.out.println("Elementos del vector");
        System.out.println(Arrays.toString(arr));
        

    }

    public void nrosFaltantes(int[] arr){

       int inicioNumero = -30;
       int finNumero = 30;

       Arrays.sort(arr);

       while(inicioNumero != finNumero){

            //busqueda binaria en el arreglo 
            int existe = Arrays.binarySearch(arr, inicioNumero);
            
            if (existe < 0 ){
                System.out.println("No existe el numero: " + inicioNumero);
            }

            inicioNumero++;

       }
        

    }

    public void nrosMasRepetidos(int[] arr){

        int vecesRepetidas = 0;
        int nroMasVecesRepetido = 0;

        Map<Integer,Integer> nroRepetido = new HashMap<>();

        for(int i =0; i< arr.length; i++){
            if (nroRepetido.containsKey(arr[i])){
                nroRepetido.put(arr[i],nroRepetido.get(arr[i]) + 1);
            }else{
                nroRepetido.put(arr[i], 1);
            }
        }
        
        System.out.println("==> Mostrar Elementos <==");
        for (Map.Entry<Integer, Integer> entry : nroRepetido.entrySet()) {

                Integer clave = entry.getKey();
                Integer valor = entry.getValue();

                if(valor > vecesRepetidas){
                    vecesRepetidas = valor;
                    nroMasVecesRepetido = clave;
                }
            }

        
        System.out.println("El numero mas repetido es: "+ nroMasVecesRepetido + " aparece: " + vecesRepetidas + " Veces");

    }

    
}
