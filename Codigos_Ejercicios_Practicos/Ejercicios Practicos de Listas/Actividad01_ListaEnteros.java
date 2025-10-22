package ejerciciosPracticosDeListas;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad01_ListaEnteros.java
 * Lista enlazada simple: insertar al final, mostrar, eliminar nodos con dato > límite.
 */
public class Actividad01_ListaEnteros {

    static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int d) { dato = d; siguiente = null; }
    }

    private Nodo cabeza = null;

    // Insertar al final
    public void insertarAlFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo p = cabeza;
        while (p.siguiente != null) p = p.siguiente;
        p.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[Lista vacía]");
            return;
        }
        Nodo p = cabeza;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.dato + (p.siguiente != null ? " -> " : ""));
            p = p.siguiente;
        }
        System.out.println();
    }

    // Eliminar nodos con dato > limite
    public void eliminarMayoresQue(int limite) {
        // Eliminar del inicio mientras cabeza > limite
        while (cabeza != null && cabeza.dato > limite) {
            cabeza = cabeza.siguiente;
        }
        if (cabeza == null) return;
        Nodo p = cabeza;
        while (p.siguiente != null) {
            if (p.siguiente.dato > limite) {
                // saltar el nodo
                p.siguiente = p.siguiente.siguiente;
            } else {
                p = p.siguiente;
            }
        }
    }

    public static void main(String[] args) {
        Actividad01_ListaEnteros lista = new Actividad01_ListaEnteros();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Actividad 01: Lista enlazada de enteros (inserción al final).");
        System.out.print("¿Cuántos números aleatorios quieres generar? (ej. 10): ");
        int n = 10;
        try { n = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { /* usar 10 */ }

        for (int i = 0; i < n; i++) {
            int val = rnd.nextInt(100) + 1; // 1..100
            lista.insertarAlFinal(val);
        }

        System.out.println("\nLista generada:");
        lista.mostrar();

        System.out.print("\nIngresa un valor límite (se eliminarán nodos con valor > límite): ");
        int limite;
        try {
            limite = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Usando límite = 50.");
            limite = 50;
        }

        lista.eliminarMayoresQue(limite);
        System.out.println("\nLista después de eliminar nodos mayores que " + limite + ":");
        lista.mostrar();

        sc.close();
    }
}