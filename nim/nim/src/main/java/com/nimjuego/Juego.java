package com.nimjuego;

import java.util.Scanner;


public class Juego {

    private Pila[] pilas = new Pila[3];
    private String jugador1 = "player1";
    private String jugador2 = "player2";
    protected int totalPilas = 0;

    private int turno = 0;


    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    Juego(){

    }

   public void jugar() {

        Scanner scan = new Scanner(System.in);

        // Inicializar pilas
        pilas[0] = new Pila();
        pilas[1] = new Pila();
        pilas[2] = new Pila();

        // Cargar las pilas con elementos
        totalPilas = getTotalPilas(totalPilas);

        // Solicitar nombres
        getNames();

        verPilas(pilas[0], pilas[1], pilas[2]);

        while (totalPilas > 0) {
            String nombreJugador = (turno == 0) ? jugador1 : jugador2;

            String pilaSeleccionada = "";
            int cantidadSeleccionada = 0;

            boolean jugadaValida = false;

            while (!jugadaValida) {
                System.out.println(nombreJugador + ", elija una pila (a, b o c): ");
                pilaSeleccionada = scan.nextLine().toLowerCase();

                System.out.println("Ingrese cuántas pilas deseas quitar:");
                try {
                    cantidadSeleccionada = scan.nextInt();
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("Entrada inválida, debe ser un número.");
                    scan.nextLine(); 
                    continue;
                }

                jugadaValida = desarrolloJuego(pilaSeleccionada, cantidadSeleccionada);
            }

            totalPilas = getTotalPilas(totalPilas);
            verPilas(pilas[0], pilas[1], pilas[2]);

            if (totalPilas == 0) {
                String ganador = (turno == 0) ? jugador2 : jugador1; 
                System.out.println("Ya no quedan pilas que remover asi es que..." );
                System.out.println("¡" + ganador + " ha ganado!");
                break;
            }

            // Cambiar turno
            turno = (turno == 0) ? 1 : 0;
        }

        scan.close();
    }
    
    
    public boolean desarrolloJuego(String pilaSeleccionada, int cantidadSeleccionada) {
        int index = -1;
        if (pilaSeleccionada.equals("a")) index = 0;
        else if (pilaSeleccionada.equals("b")) index = 1;
        else if (pilaSeleccionada.equals("c")) index = 2;
        else {
            System.out.println("Pila inválida. Intente de nuevo.");
            verPilas(pilas[0], pilas[1], pilas[2]);
            return false;
        }

        if (pilas[index].getCantidad() == 0) {
            System.out.println("Esa pila está vacía. Elija otra.");
            verPilas(pilas[0], pilas[1], pilas[2]);
            return false;
        }

        if (cantidadSeleccionada <= 0 || cantidadSeleccionada > pilas[index].getCantidad()) {
            System.out.println("Cantidad inválida. Intente de nuevo.");
            return false;
        }

        // Aplicar jugada
        pilas[index].setCantidad(pilas[index].getCantidad() - cantidadSeleccionada);
        return true;
    }


    public void verPilas(Pila a, Pila b, Pila c){
        System.out.println("Las pilas son");
        System.out.println("A: " + a.getCantidad() + " B: "+ b.getCantidad()+" C: " + c.getCantidad());
    }

    public void getNames(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Jugador 1 ingrese su nombre: ");
        String nommbre1 = scan.nextLine();
        setJugador1(nommbre1);

       System.out.println("Jugador 2 ingrese su nombre: ");
        String nommbre2 = scan.nextLine();
        setJugador2(nommbre2); 


    }
    

    public int getTotalPilas(int totalPilas){
        totalPilas = 0;
        for (int i = 0; i < pilas.length; i++) {
            totalPilas += pilas[i].getCantidad();
        }

        return totalPilas;
    }
}
