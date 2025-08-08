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

}
