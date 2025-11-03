package ejerciciosPracticos.ejerciciosPracticosDePilas.verificarSiPilaEstaVacia;

import ejerciciosPracticos.ejerciciosPracticosDePilas.pila.Pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 3: Verificar si una pila esta vacia
 * 
 * Objetivo: Comprobar si la pila tiene elementos usando el metodo estaVacia().
 * 
 * Algoritmo:
 * 1. Crear pila vacia
 * 2. Usar metodo estaVacia()
 * 3. Insertar un elemento
 * 4. Verificar nuevamente
 */
public class PruebaPilaVacia {
    
    public static void main(String[] args) {
        
        System.out.println("Ejercicio 3: Verificar si una pila esta vacia");
        System.out.println();
        
        // Crear una pila vacia
        Pila<Integer> pila = new Pila<>();
        
        // Verificar si esta vacia (debe retornar true)
        System.out.println("¿Esta vacia la pila? " + pila.estaVacia());
        System.out.println();
        
        // Insertar un elemento
        pila.push(1);
        
        // Verificar nuevamente (debe retornar false)
        System.out.println("¿Esta vacia la pila? " + pila.estaVacia());
    }
}