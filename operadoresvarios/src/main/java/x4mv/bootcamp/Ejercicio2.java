package x4mv.bootcamp;

public class Ejercicio2 {

    // casos de prueba
    int[] mayor = {2,4};
    int[] menor = {4,2};
    int[] iguales = {5,5};

    int num1 = 2;
    int num2 = 4;

    Ejercicio2(){

    }


    public void calcularRelacion(){

        if (num1 > num2){
        System.out.println("El numero mayor es: "+ num1);
        }else if (num1 < num2){
            System.out.println("El numero mayor es: "+ num2);
        }else {
            System.out.println("Tienen el mismo valor");
        }

    }
    
    
}
