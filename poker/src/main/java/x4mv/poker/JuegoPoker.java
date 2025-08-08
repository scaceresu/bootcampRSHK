// JuegoPoker.java
package x4mv.poker;

import java.util.*;

public class JuegoPoker {

    private static final List<String> VALORES_ORDENADOS = Arrays.asList(
        "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"
    );
    private static final List<String> PALOS = Arrays.asList("S", "H", "D", "C");

    public static void main(String[] args) {
        Carta[] mano = generarManoAleatoria();
        System.out.println("Mano generada: " + Arrays.toString(mano));
        System.out.println("La jugada es: " + identificarJugada(mano));
        System.out.println("==> RESONDER RESPUESTAS <===");
        responderRespuestas();

        System.out.println("===> POKER PARA 2 <===");
    }

    // creando las convinaciones posibles 
    public static Carta[] generarManoAleatoria() {
        List<Carta> mazo = new ArrayList<>();
        for (String valor : VALORES_ORDENADOS) {
            for (String palo : PALOS) {
                mazo.add(new Carta(valor, palo));
            }
        }

        Collections.shuffle(mazo); // Mezcla el mazo
        return mazo.subList(0, 5).toArray(new Carta[0]); // Toma las 5 primeras cartas
    }

    public static String identificarJugada(Carta[] mano) {
        boolean esColor = esColor(mano);
        boolean esEscalera = esEscalera(mano);

        Map<String, Integer> repeticiones = contarValores(mano);
        Collection<Integer> valoresRepetidos = repeticiones.values();

        if (esColor && esEscalera) return "Escalera Color";
        if (valoresRepetidos.contains(4)) return "Poker";
        if (valoresRepetidos.contains(3) && valoresRepetidos.contains(2)) return "Full";
        if (esColor) return "Color";
        if (esEscalera) return "Escalera";
        if (valoresRepetidos.contains(3)) return "Trío";
        
        int pares = 0;
        for (int rep : valoresRepetidos) if (rep == 2) pares++;
        if (pares == 2) return "Par Doble";
        if (pares == 1) return "Par";
        
        return "Carta Alta";
    }

    private static boolean esColor(Carta[] mano) {
        String palo = mano[0].getPalo();
        for (Carta c : mano) {
            if (!c.getPalo().equals(palo)) return false;
        }
        return true;
    }

    private static boolean esEscalera(Carta[] mano) {
        List<Integer> indices = new ArrayList<>();
        for (Carta c : mano) {
            indices.add(VALORES_ORDENADOS.indexOf(c.getValor()));
        }
        Collections.sort(indices);

        // Caso especial: A-2-3-4-5
        if (indices.equals(Arrays.asList(0, 1, 2, 3, 12))) return true;

        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) != 1) return false;
        }
        return true;
    }

    private static Map<String, Integer> contarValores(Carta[] mano) {
        Map<String, Integer> conteo = new HashMap<>();
        for (Carta c : mano) {
            conteo.put(c.getValor(), conteo.getOrDefault(c.getValor(), 0) + 1);
        }
        return conteo;
    }

    public static void responderRespuestas(){
        long total = 2598960L; // C(52,5)

        long escaleraColor = 40L;
        long poker = 624L;
        long full = 3744L;
        long escalera = 10200L;
        long trio = 54912L;
        long parDoble = 123552L;
        long par = 1098240L;
        long nada = 1302540L;

        System.out.println("Escalera de color: " + String.format("%.6f", (double) escaleraColor / total * 100) + "%");
        System.out.println("Poker: " + String.format("%.6f", (double) poker / total * 100) + "%");
        System.out.println("Full house: " + String.format("%.6f", (double) full / total * 100) + "%");
        System.out.println("Escalera: " + String.format("%.6f", (double) escalera / total * 100) + "%");
        System.out.println("Trío: " + String.format("%.6f", (double) trio / total * 100) + "%");
        System.out.println("Par doble: " + String.format("%.6f", (double) parDoble / total * 100) + "%");
        System.out.println("Par: " + String.format("%.6f", (double) par / total * 100) + "%");
        System.out.println("Nada: " + String.format("%.6f", (double) nada / total * 100) + "%");
    }

    public static void jugarPokerEntreDosJugadores() {
    Scanner sc = new Scanner(System.in);

    // Fondos iniciales
    System.out.print("Ingrese fondos iniciales para Jugador 1: ");
    double fondos1 = sc.nextDouble();

    System.out.print("Ingrese fondos iniciales para Jugador 2: ");
    double fondos2 = sc.nextDouble();

    double apuesta = 10; // Apuesta fija por ronda

    sc.nextLine(); // Limpiar buffer

    while (fondos1 > 0 && fondos2 > 0) {
        System.out.println("\n--- Nueva Ronda ---");

        // Generar manos
        Carta[] mano1 = generarManoAleatoria();
        Carta[] mano2 = generarManoAleatoria();

        // Mostrar manos y jugadas
        String jugada1 = identificarJugada(mano1);
        String jugada2 = identificarJugada(mano2);

        System.out.println("Jugador 1: " + Arrays.toString(mano1) + " -> " + jugada1);
        System.out.println("Jugador 2: " + Arrays.toString(mano2) + " -> " + jugada2);

        // Comparar jugadas para determinar ganador
        int resultado = compararManos(mano1, mano2);

        if (resultado > 0) {
            System.out.println("Gana Jugador 1");
            fondos1 += apuesta;
            fondos2 -= apuesta;
        } else if (resultado < 0) {
            System.out.println("Gana Jugador 2");
            fondos1 -= apuesta;
            fondos2 += apuesta;
        } else {
            System.out.println("Empate - fondos sin cambios");
        }

        // Mostrar fondos
        System.out.println("Fondos Jugador 1: " + fondos1);
        System.out.println("Fondos Jugador 2: " + fondos2);

        // Preguntar si continuar
        System.out.print("¿Desea seguir jugando? (s/n): ");
        String continuar = sc.nextLine().trim().toLowerCase();
        if (continuar.equals("n")) break;
    }

    System.out.println("\nJuego terminado.");
    if (fondos1 > fondos2) {
        System.out.println("Jugador 1 gana la partida final.");
    } else if (fondos2 > fondos1) {
        System.out.println("Jugador 2 gana la partida final.");
    } else {
        System.out.println("La partida terminó en empate.");
    }
}

// Método para comparar manos según la fuerza de la jugada
private static int compararManos(Carta[] mano1, Carta[] mano2) {
    // Ranking de jugadas: mientras más alto, mejor
    List<String> ranking = Arrays.asList(
        "Carta Alta", "Par", "Par Doble", "Trío",
        "Escalera", "Color", "Full", "Poker", "Escalera Color"
    );

    int valor1 = ranking.indexOf(identificarJugada(mano1));
    int valor2 = ranking.indexOf(identificarJugada(mano2));

    if (valor1 > valor2) return 1;
    if (valor2 > valor1) return -1;

    // En caso de empate en jugada, comparar carta más alta
    return compararCartaAlta(mano1, mano2);
}

    // Método para comparar la carta más alta
    private static int compararCartaAlta(Carta[] mano1, Carta[] mano2) {
        List<String> valores = Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"
        );

        List<Integer> indices1 = new ArrayList<>();
        List<Integer> indices2 = new ArrayList<>();
        for (Carta c : mano1) indices1.add(valores.indexOf(c.getValor()));
        for (Carta c : mano2) indices2.add(valores.indexOf(c.getValor()));

        Collections.sort(indices1, Collections.reverseOrder());
        Collections.sort(indices2, Collections.reverseOrder());

        for (int i = 0; i < indices1.size(); i++) {
            if (indices1.get(i) > indices2.get(i)) return 1;
            if (indices2.get(i) > indices1.get(i)) return -1;
        }
        return 0; // Total empate
    }
}
