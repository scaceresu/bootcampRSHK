package x4mv.bootcamp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio10 {
   
    private List<String> semana = Arrays.asList("lunes", "martes", "miercoles", "jueves", "viernes");
    Ejercicio10(){

    }

    public void diaLaboral(){
        System.out.println("Ingrese un dia de la semana");
        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        String userDay = scan.nextLine().toLowerCase();

        if (semana.contains(userDay)){
            System.out.println("Es dia laboral");
        }else{
            System.out.println("No es dia laboral");
        }

        
    }
}
