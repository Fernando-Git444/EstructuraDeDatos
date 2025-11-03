package ejerciciosPracticos.ejerciciosPracticosDePilas.revertirLista;

import ejerciciosPracticos.ejerciciosPracticosDePilas.pila.Pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 9: Revertir lista
 * 
 * Objetivo: Usar una pila para invertir los elementos de una lista.
 * 
 * Algoritmo:
 * 1. Apilar elementos de la lista
 * 2. Desapilar e imprimir
 */
public class PruebaRevertirLista {
    
    public static void main(String[] args) {
        
        System.out.println("Ejercicio 9: Revertir lista");
        System.out.println();
        
        // Crear un array con elementos
        int[] lista = {1, 2, 3, 4};
        
        // Mostrar lista original
        System.out.print("Lista original: ");
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i]);
            if (i < lista.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println();
        
        // Crear una pila para invertir
        Pila<Integer> pila = new Pila<>();
        
        // Apilar cada elemento
        for (int numero : lista) {
            pila.push(numero);
        }
        
        // Desapilar e imprimir invertido
        System.out.print("Lista invertida: ");
        while (!pila.estaVacia()) {
            System.out.print(pila.pop() + " ");
        }
    }
}