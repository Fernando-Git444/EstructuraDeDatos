package ejerciciosPracticosDeListas;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad04_PolinomioCircular.java
 * Lista enlazada circular para polinomio. La referencia de acceso es el último nodo.
 */
public class Actividad04_PolinomioCircular {

    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; siguiente = null; }
    }

    // referencia al último nodo (si lista vacía, ultimo == null)
    private Nodo ultimo = null;

    // Insertar al final (último)
    public void insertarAlFinal(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
        if (ultimo == null) {
            nuevo.siguiente = nuevo; // apunta a sí mismo
            ultimo = nuevo;
            return;
        }
        nuevo.siguiente = ultimo.siguiente; // primero actual
        ultimo.siguiente = nuevo;
        ultimo = nuevo;
    }

    // Mostrar recorrido circular (desde primero = ultimo.siguiente)
    public void mostrarCircular() {
        if (ultimo == null) {
            System.out.println("[Lista circular vacía]"); return;
        }
        Nodo inicio = ultimo.siguiente;
        Nodo p = inicio;
        System.out.print("Polinomio (circular): ");
        do {
            System.out.print(String.format("%.2f*x^%d", p.coef, p.exp));
            p = p.siguiente;
            if (p != inicio) System.out.print("  ->  ");
        } while (p != inicio);
        System.out.println();
    }

    // Evaluar polinomio (recorrer todos los nodos una vez)
    public double evaluar(double x) {
        if (ultimo == null) return 0.0;
        Nodo inicio = ultimo.siguiente;
        Nodo p = inicio;
        double suma = 0.0;
        do {
            suma += p.coef * Math.pow(x, p.exp);
            p = p.siguiente;
        } while (p != inicio);
        return suma;
    }

    public static void main(String[] args) {
        Actividad04_PolinomioCircular pol = new Actividad04_PolinomioCircular();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 04: Polinomio con lista enlazada circular.");
        System.out.println("Ingresa términos en pares: coeficiente exponente (ej. 3 4). Línea vacía para terminar.");

        while (true) {
            System.out.print("Ingresa coef y exponente (o ENTER para terminar): ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) break;
            String[] partes = linea.split("\\s+");
            if (partes.length < 2) {
                System.out.println("Entrada inválida.");
                continue;
            }
            try {
                double coef = Double.parseDouble(partes[0]);
                int exp = Integer.parseInt(partes[1]);
                pol.insertarAlFinal(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido.");
            }
        }

        System.out.println();
        pol.mostrarCircular();

        System.out.println("\nEvaluación P(x) para x=0.0..5.0 paso 0.5:");
        System.out.println(" x    |   P(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0 + 1e-9; x += 0.5) {
            double val = pol.evaluar(x);
            System.out.printf("%4.1f  |  %.6f%n", x, val);
        }

        sc.close();
    }
}