package x4mv.relojclases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reloj {

    private int hora;
    private int minutos;
    private int segundos;


    // Por defecto inicializa en 
    Reloj(){
        this.hora = 12;
        this.minutos = 00;
        this.segundos = 00;
    }

    Reloj(int hora, int minuto, int segundos){
        this.hora = hora;
        this.minutos = minuto;
        this.segundos = segundos;
    }

    // recibe los segundo totales desde media noche
    Reloj(int segundosTotales){

        int horasCalculadas = segundosTotales / 3600;
        int minutosSinHoras = segundosTotales % 3600;
        int minutosCalculados = minutosSinHoras / 60;
        int segundosSinMinutos = minutosSinHoras % 60;

        this.hora = horasCalculadas;
        this.minutos = minutosCalculados;
        this.segundos = segundosSinMinutos;
    }

    public int setReloj(){
        int segundosTotales = this.hora*3600;
        segundosTotales += this.minutos*60;
        segundosTotales += this.segundos;
        return segundosTotales;
    }

    public String toString(){

        // imprimir en el formato correcto
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formatoFecha ="";
        String fechaRaw = String.valueOf(hora) +":" +String.valueOf(minutos)+":"+String.valueOf(segundos);

        try {
            Date parsedFecha = sdf.parse(fechaRaw);
            formatoFecha = sdf.format(parsedFecha);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al convertir la fecha");
            
        }

        return "["+ formatoFecha +"]"; 
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void tick(){

        // Aumentar un segundo al reloj
        this.segundos++;

        if (this.segundos == 60) {
            this.segundos = 0;
            this.minutos++;

            if (this.minutos == 60) {
                this.minutos = 0;
                this.hora++;

                if (this.hora == 24) {
                    this.hora = 0; // Se pasa al siguiente día
                }
            }
        }

        // Mensajes de depuración
        System.out.println("Hora aumentada +1 seg");
        System.out.println(toString());

    }


    public void addReloj(Reloj reloj){

        int segundosTotales = reloj.setReloj();

        int sumaHoras = segundosTotales + setReloj();

        Reloj nuevaHora = new Reloj(sumaHoras);
    
        System.out.println("La hora sumada es");
        System.out.println(nuevaHora.toString());
    }

   
   public void tickDecrement() {
    if (this.segundos > 0) {
        this.segundos--;
    } else {
        this.segundos = 59;
        if (this.minutos > 0) {
            this.minutos--;
        } else {
            this.minutos = 59;
            if (this.hora > 0) {
                this.hora--;
            } else { 
                this.hora = 23;
            }
        }
    }

    System.out.println("Hora restada -1 seg");
    System.out.println(toString());
}

public void restaReloj(Reloj reloj){

    int tiempoTranscurrido = reloj.setReloj();
    
    int tiempoActual = this.setReloj();
    
    int nuevoTiempo = tiempoActual - tiempoTranscurrido;


    Reloj nuevaHora = new Reloj(nuevoTiempo);

    System.out.println("Hora restada");
    System.out.println(nuevaHora.toString());

//    public void mostrarHora() {
//        System.out.println("Hora actual: " + toString());
//    }CJ: Para cumplir con la tarea


    System.out.println("Probando diff");
}
    
}
