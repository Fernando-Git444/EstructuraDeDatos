package ejerciciosPracticos.ejerciciosPracticosDePilas.simulacionSimpleDePila;

import ejerciciosPracticos.ejerciciosPracticosDePilas.pila.Pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 1: Simulacion simple de pila
 * 
 * Objetivo: Practicar las operaciones basicas push y pop en una pila.
 * 
 * 1. Crear una pila vacia
 * 2. Insertar 5, 10, 15, 20
 * 3. Eliminar dos elementos
 * 4. Mostrar contenido
 */
public class PruebaPila {
    
    public static void main(String[] args) {
        
        System.out.println("Ejercicio 1: Simulacion simple de pila");
        System.out.println();
        
        // Crear una pila vacia
        Pila<Integer> pila = new Pila<>();
        
        // Insertar elementos usando push
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        
        System.out.println("Pila despues de insertar: " + pila.mostrar());
        System.out.println();
        
        // Eliminar dos elementos usando pop
        pila.pop();
        pila.pop();
        
        // Mostrar contenido final
        System.out.println("Contenido actual: " + pila.mostrar());
    }
}