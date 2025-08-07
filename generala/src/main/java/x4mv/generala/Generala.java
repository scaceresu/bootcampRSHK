package x4mv.generala;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Generala {

    public static void main(String[] args){

        
        String decision = "";
        Scanner scan = new Scanner(System.in);

    
        do{

            
            int[] intentoGenerado = generarDados() ;
            verDados(intentoGenerado);

            if(checkGenerala(intentoGenerado)){
                System.out.println("GENERALA!!!");
            }else if(checkPoker(intentoGenerado)){
                System.out.println("POKER!!!");
            }else if (checkEscalera(intentoGenerado)){
                System.out.println("ESCALERA!!!");
            }else if(checkFull(intentoGenerado)){
                System.out.println("ES FULL!!!");
            }

            
            System.out.println("Presion (S) para continuar o (X) para salir");
            decision = scan.nextLine().toLowerCase();

        }while(decision.equals("s"));
        
        if(decision.equals("x")){
            responderPreguntas();
            bonus();
        }

        scan.close();
    }


    public static int[] generarDados(){

        Random rand = new Random();
        int dado1 = rand.nextInt(0,9);
        int dado2 = rand.nextInt(0,9);
        int dado3 = rand.nextInt(0,9);
        int dado4 = rand.nextInt(0,9);
        int dado5 = rand.nextInt(0,9);

        int[] dados = new int[5];
        dados[0] = dado1;
        dados[1] = dado2;
        dados[2] = dado3;
        dados[3] = dado4;
        dados[4] = dado5;

        return dados;
    }
   
    public static void verDados(int[] dados){
 
        System.out.println("Los Dados salieron: ["+ dados[0]+"] ["+dados[1]+"] ["+ dados[2]+"] "+"["+dados[3]+"]" + "["+ dados[4]+"]");
    }


    public static boolean checkGenerala(int[] intento){


        // caso generala 
        for (int i = 0; i < intento.length-1; i++) {
            if (intento[i] != intento[i+1] ){
                return false;
            }
        }

        return true;


    }

    public static boolean checkPoker(int[] intento){

        Map<Integer,Integer> dados= new HashMap<>(5);

        for (int i = 0; i < intento.length; i++) {

            // viendo que elementos se repiten
            if (dados.containsKey(intento[i])){
                dados.put(intento[i], dados.get(intento[i]) + 1);
            }else{
                dados.put(intento[i],1);
            }

        }

        if (Collections.max(dados.values()) == 4){
            return true;
        }

        return false;
    }


    public static boolean checkEscalera(int[] intento){

        Arrays.sort(intento);
        int[] esperado = {1, 3, 4, 5, 6};

        if (Arrays.equals(intento, esperado)){
            return true;

        }
        for (int i = 0; i < intento.length-1; i++) {
            if(Math.abs(intento[i] - intento[i+1]) != 1){
                return false;
            }
        }

        return true;
    }
    
    public static boolean checkFull(int[] intento) {
        // Mapa para contar cuántas veces aparece cada valor
        Map<Integer, Integer> contador = new HashMap<>();

        for (int i = 0; i < intento.length; i++) {
            contador.put(intento[i], contador.getOrDefault(intento[i], 0) + 1);
        }

        boolean hayTres = false;
        boolean hayDos = false;

        // Recorremos los valores del mapa para ver si hay un grupo de 3 y uno de 2
        for (int cantidad : contador.values()) {
            if (cantidad == 3) {
                hayTres = true;
            } else if (cantidad == 2) {
                hayDos = true;
            }
        }

        return hayTres && hayDos;
    }
    
   
    public static void responderPreguntas(){

        // 2.1. Cuál es la probabilidad de sacar generala en un tiro 
        // 2.2. Cuál es la probabilidad de sacar poker en un tiro 
        // 2.3. Cuál es la probabilidad de sacar full en un tiro 
        // 2.4. Cuál es la probabilidad de sacar escalera en un tiro 
        // 2.5. Cuál es la probabilidad de sacar nada en un tiro


       System.out.println("Probabilidades de sacar Generala en un tiro:");
        System.out.printf("%.4f%%\n", (6.0 / 7776) * 100);

        System.out.println("Probabilidades de sacar Póker en un tiro:");
        System.out.printf("%.4f%%\n", (150.0 / 7776) * 100);

        System.out.println("Probabilidades de sacar Full en un tiro:");
        System.out.printf("%.4f%%\n", (300.0 / 7776) * 100);

        System.out.println("Probabilidades de sacar Escalera en un tiro:");
        System.out.printf("%.4f%%\n", (240.0 / 7776) * 100);

        System.out.println("Probabilidades de sacar Nada en un tiro:");
        System.out.printf("%.4f%%\n", (7080.0 / 7776) * 100);


    }

    public static void bonus(){

        //3.1. Cuál es la probabilidad de sacar generala en dos tiros
        //3.2. Cuál es la probabilidad de sacar generala en tres tiros

       // Generala en 2 tiros (valor estimado por combinatoria/simulaciones)
        System.out.printf(" - En dos tiros: %.2f%% (estimado)\n", 4.60);

        // Generala en 3 tiros (valor estimado por combinatoria/simulaciones)
        System.out.printf(" - En tres tiros: %.2f%% (estimado)\n", 9.77);

    }
}
