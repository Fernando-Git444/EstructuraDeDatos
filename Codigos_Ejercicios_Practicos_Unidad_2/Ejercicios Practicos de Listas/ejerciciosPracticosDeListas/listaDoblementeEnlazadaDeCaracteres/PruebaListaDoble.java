package ejerciciosPracticos.ejerciciosPracticosDeListas.listaDoblementeEnlazadaDeCaracteres;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad 05:
 * Lista Doblemente Enlazada de Caracteres (ordenada alfabéticamente).
 * Este programa construye una lista doblemente enlazada a partir de los caracteres
 * de una cadena ingresada por el usuario y luego la ordena alfabéticamente.
 * 
 */
public class PruebaListaDoble {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ListaDoble lista = new ListaDoble();

        System.out.println("Lista Doblemente Enlazada de Caracteres");
        System.out.print("Ingrese una cadena de texto: ");
        String texto = teclado.nextLine();

        // Crear la lista a partir de la cadena ingresada
        for (int i = 0; i < texto.length(); i++) {
            lista.insertar(texto.charAt(i));
        }

        // Mostrar lista original
        System.out.println();
        System.out.println("Lista original:");
        System.out.println(lista.mostrar());

        // Ordenar la lista alfabéticamente
        lista.ordenar();

        // Mostrar lista ordenada
        System.out.println();
        System.out.println("Lista ordenada alfabéticamente:");
        System.out.println(lista.mostrar());

        teclado.close();
        System.out.println();
        System.out.println("Programa finalizado correctamente.");
    }
}