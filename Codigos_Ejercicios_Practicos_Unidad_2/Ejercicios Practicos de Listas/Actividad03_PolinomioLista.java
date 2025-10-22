package ejerciciosPracticosDeListas;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad03_PolinomioLista.java
 * Representación de polinomio con lista enlazada (nodos con coeficiente y exponente).
 * Evaluación para x desde 0.0 a 5.0 con paso 0.5.
 */
public class Actividad03_PolinomioLista {

    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; siguiente = null; }
    }

    private Nodo cabeza = null;

    // Insertar al final (orden de aparición)
    public void insertarTermino(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
        if (cabeza == null) { cabeza = nuevo; return; }
        Nodo p = cabeza;
        while (p.siguiente != null) p = p.siguiente;
        p.siguiente = nuevo;
    }

    // Evaluar P(x)
    public double evaluar(double x) {
        double suma = 0.0;
        Nodo p = cabeza;
        while (p != null) {
            suma += p.coef * Math.pow(x, p.exp);
            p = p.siguiente;
        }
        return suma;
    }

    // Mostrar representación: término por término
    public void mostrarPolinomio() {
        if (cabeza == null) {
            System.out.println("[Polinomio vacío]"); return;
        }
        Nodo p = cabeza;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            String term = String.format("%.2f*x^%d", p.coef, p.exp);
            sb.append(term);
            if (p.siguiente != null) sb.append("  +  ");
            p = p.siguiente;
        }
        System.out.println("Polinomio (orden de entrada): " + sb.toString());
    }

    public static void main(String[] args) {
        Actividad03_PolinomioLista pol = new Actividad03_PolinomioLista();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 03: Representación y evaluación de polinomios.");
        System.out.println("Ingresa términos en pares: coeficiente exponente (por ejemplo: 3 4).");
        System.out.println("Escribe una línea vacía para terminar la entrada.");

        while (true) {
            System.out.print("Ingresa coef y exponente (o ENTER para terminar): ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) break;
            String[] partes = linea.split("\\s+");
            if (partes.length < 2) {
                System.out.println("Entrada inválida. Debes dar dos valores: coef exp");
                continue;
            }
            try {
                double coef = Double.parseDouble(partes[0]);
                int exp = Integer.parseInt(partes[1]);
                pol.insertarTermino(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Intenta de nuevo.");
            }
        }

        System.out.println();
        pol.mostrarPolinomio();

        // Evaluar desde 0.0 a 5.0 paso 0.5
        System.out.println("\nTabla de valores P(x):");
        System.out.println(" x    |   P(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0 + 1e-9; x += 0.5) {
            double val = pol.evaluar(x);
            System.out.printf("%4.1f  |  %.6f%n", x, val);
        }

        sc.close();
    }
}