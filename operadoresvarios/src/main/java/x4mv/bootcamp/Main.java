package x4mv.bootcamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Ejercicio1 
        System.out.println("==> Ejercicio 1 <==");
        Ejercicio1 eje1 = new Ejercicio1();
        eje1.suma();
        eje1.resta();
        eje1.multiplicaicon();
        eje1.division();
        eje1.modulo();

        // ejercicio 2
        System.out.println("==> Ejercicio2 <==");
        Ejercicio2 eje2 = new Ejercicio2();
        eje2.calcularRelacion();

        // ejercicio 3
        System.out.println("==> Ejercicio3 <==");
        Ejercicio3 eje3 = new Ejercicio3();
        eje3.saludar();

        // ejercicio4

        System.out.println("==> Ejercicio4 <==");
        Ejercicio3 eje4 = new Ejercicio3();
        System.out.println("Ingrese un nombre: ");
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();
        eje3.saludar(nombre);


        //ejercicio5 
        System.out.println("==> Ejercicio5 <==");
        Ejercicio5 eje5 = new Ejercicio5();
        System.out.println("Ingrese un numero: ");
        eje5.esDivisible();

        //ejercicio6
        System.out.println("==> Ejercicio6 <==");
        System.out.println("Ingrese el precio del producto: ");
        Ejercicio6 eje6 = new Ejercicio6();
        eje6.calcularPrecio(); 

        //ejercicio7
        System.out.println("==> Ejercicio7 <==");
        System.out.println("Imprimiendo numeros divisibles entre 2 y 3");
        Ejercicio7 eje7 = new Ejercicio7();
        eje7.mostrarNumeros();

        //ejercicio8 
        System.out.println("==> Ejercicio8 <==");
        Ejercicio8 eje8 = new Ejercicio8();
        eje8.relacionCero();

        // ejercicio9
        System.out.println("==> Ejercicio9 <==");
        Ejercicio9 eje9 = new Ejercicio9();
        eje9.tryPassword();

        // Ejercicio10
        System.out.println("==> Ejercicio10 <==");
        Ejercicio10 eje10 = new Ejercicio10();
        eje10.diaLaboral();

        //Termina el ingreso por consola 
        scan.close();
    }
}