package x4mv.bootcamp;

import java.util.Scanner;

public class Ejercicio6 {

    private  double IVA = 10.00;
    
    Scanner scan = new Scanner(System.in);

    public void calcularPrecio(){

        while (!scan.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número valido.");
            scan.next(); // Consumimos la entrada inválida (ej: una palabra)
            System.out.print("Ingrese un número: ");
        }

        double precio = scan.nextDouble();


        double ivaProducto = precio/IVA;

        double precioFinal = ivaProducto + precio;

        System.out.println("El precio final es: "+ precioFinal);

    }

}
