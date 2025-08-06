package x4mv.ejerccioscalentamiento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    

        Scanner scan = new Scanner(System.in);

        // Ejericio1
        System.out.println("==> Ejercicio1 <===");
        
        Ejercicio01 eje1 = new Ejercicio01();

        int[] nums = eje1.generarNumeros();
        eje1.encontrarMayor(nums);
        

        // Ejercicio2

        System.out.println("==> Ejercicio02 <===");
        Ejercicio02 eje2 = new Ejercicio02();

        int[] cienNros = eje2.generarNumeros();
        eje2.mostrarNumeros(cienNros);
        eje2.nrosFaltantes(cienNros);
        eje2.nrosMasRepetidos(cienNros);

        // Ejercicio3

        System.out.println("===> Ejercicio03 <===");
        Ejercicio03 eje3 = new Ejercicio03();
        eje3.esPalindormo();

        // Ejercicio4
        System.out.println("=== Ejercicio04 <===");
        Ejercicio04 eje4 = new Ejercicio04();
        eje4.getValues();

   
        EjercicioIsa ejeIs = new EjercicioIsa();
        ejeIs.esP();
        scan.close();
    }
}