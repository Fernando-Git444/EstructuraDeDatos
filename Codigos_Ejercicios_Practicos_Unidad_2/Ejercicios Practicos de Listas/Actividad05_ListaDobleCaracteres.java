package ejerciciosPracticosDeListas;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad05_ListaDobleCaracteres.java
 * Lista doblemente enlazada construida desde una cadena de entrada.
 * Ordenamiento alfabético: se realiza swapping de los datos de los nodos para
 * simplificar y evitar manipulación compleja de punteros (la estructura sigue siendo válida).
 */
public class Actividad05_ListaDobleCaracteres {

    static class NodoDoble {
        char dato;
        NodoDoble prev;
        NodoDoble next;
        NodoDoble(char d) { dato = d; prev = next = null; }
    }

    private NodoDoble cabeza = null;
    private NodoDoble cola = null;

    // Construir lista a partir de cadena: cada carácter (incluye espacio si quieres, por defecto omito espacios)
    public void construirDesdeCadena(String s) {
        for (char c : s.toCharArray()) {
            if (c == ' ') continue; // omitir espacios; si quieres incluir espacios, elimina esta línea
            NodoDoble nuevo = new NodoDoble(c);
            if (cabeza == null) {
                cabeza = cola = nuevo;
            } else {
                cola.next = nuevo;
                nuevo.prev = cola;
                cola = nuevo;
            }
        }
    }

    // Mostrar desde cabeza hacia adelante
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[Lista vacía]"); return;
        }
        NodoDoble p = cabeza;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.dato);
            p = p.next;
        }
        System.out.println();
    }

    // Ordenamiento alfabético (burbuja) intercambiando datos de nodos
    public void ordenarAlfabeticamente() {
        if (cabeza == null) return;
        boolean huboCambio;
        do {
            huboCambio = false;
            NodoDoble p = cabeza;
            while (p.next != null) {
                if (Character.toLowerCase(p.dato) > Character.toLowerCase(p.next.dato)) {
                    // swap datos
                    char tmp = p.dato;
                    p.dato = p.next.dato;
                    p.next.dato = tmp;
                    huboCambio = true;
                }
                p = p.next;
            }
        } while (huboCambio);
    }

    public static void main(String[] args) {
        Actividad05_ListaDobleCaracteres programa = new Actividad05_ListaDobleCaracteres();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 05: Lista doblemente enlazada de caracteres.");
        System.out.print("Ingresa una cadena (los espacios serán omitidos en la lista): ");
        String linea = sc.nextLine();

        programa.construirDesdeCadena(linea);
        System.out.println("\nLista original:");
        programa.mostrar();

        programa.ordenarAlfabeticamente();
        System.out.println("\nLista ordenada alfabéticamente:");
        programa.mostrar();

        sc.close();
    }
}