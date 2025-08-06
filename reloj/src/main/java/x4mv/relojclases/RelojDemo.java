package x4mv.relojclases;

import java.util.Scanner;

public class RelojDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
   
        System.out.println("REVISADO Y APROBADO POR ALEXIS CANETE");

        Reloj default1 = new Reloj();
        System.out.println("Hora sin parametros");
        System.out.println(default1.toString());

        System.out.println("Hora con 3 parametros");
        Reloj prueba = new Reloj(7,1,2);
        System.out.println("formato ");
        System.out.println(prueba.toString());

        int tiempoSegundos=0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el tiempo transcurrido en segundos");

        // validacion para el formato
        while(!scan.hasNextInt()){
            System.out.println("El formato no es correcto intente de nuevo");
            scan.next();
            System.out.println("Ingrese un formato valido: ");

        }

        // validacion para numeros negativos
        do{

            tiempoSegundos = scan.nextInt();

            if (tiempoSegundos < 0){
                System.out.println("Ingrese un numero positivo");
            }
        }while(tiempoSegundos < 0);

        

        Reloj reloj = new Reloj(tiempoSegundos);
        System.out.println("===> Hora ingresada <=== ");
        System.out.println(reloj.toString());
        System.out.println("La hora es: " + reloj.getHora());
        System.out.println("Los minutos son: " + reloj.getMinutos());
        System.out.println("Los segundos son: " + reloj.getSegundos());

        // agregamos 10 segundos
        for (int i = 0; i < 10; i++) {
            reloj.tick();
        }

        // se suman 2hrs 
        Reloj sumaReloj = new Reloj(7200);
        System.out.println("===> Horas a sumar <===");
        System.out.println(sumaReloj.toString());

        reloj.addReloj(sumaReloj);

        // se restan 8hrs
        Reloj restaReloj = new Reloj(28800);
        System.out.println("===> Horas a restar <===");
        System.out.println(restaReloj.toString());

        reloj.restaReloj(restaReloj);

         // agregamos 10 segundos
        for (int i = 0; i < 20; i++) {
            reloj.tickDecrement();
        }

        scan.close();
        
        // Reloj suma = new Reloj(43200);
        
        // reloj.addReloj(suma);
        
    }
}