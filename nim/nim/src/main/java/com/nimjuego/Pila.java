package com.nimjuego;

import java.util.Random;

public class Pila {

    private int cantidad;

    Pila(){

        Random rand = new Random();
        this.cantidad = rand.nextInt(10);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    


    
}
