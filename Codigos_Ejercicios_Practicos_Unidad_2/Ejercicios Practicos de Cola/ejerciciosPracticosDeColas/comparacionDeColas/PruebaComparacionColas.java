/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosPracticos.ejerciciosPracticosDeColas.comparacionDeColas;

import ejerciciosPracticos.ejerciciosPracticosDeColas.cola.Cola;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 1: Comparacion de colas
 * 
 * Objetivo:
 * Aplicar estructuras de datos tipo cola.
 * Implementar recorrido y comparación de elementos.
 * Preservar el estado original de las colas (opcional con colas auxiliares).
 */
public class PruebaComparacionColas {
    
    public static void main(String[] args) {
        
        System.out.println("Ejercicio 1: Comparacion de colas");
        System.out.println();
        
        // Crear primera cola
        Cola<Integer> cola1 = new Cola<>();
        cola1.encolar(10);
        cola1.encolar(20);
        cola1.encolar(30);
        
        System.out.println("Cola 1: " + cola1.mostrar());
        
        // Crear segunda cola identica
        Cola<Integer> cola2 = new Cola<>();
        cola2.encolar(10);
        cola2.encolar(20);
        cola2.encolar(30);
        
        System.out.println("Cola 2: " + cola2.mostrar());
        System.out.println();
        
        // Comparar
        boolean resultado = sonIguales(cola1, cola2);
        System.out.println("¿Son iguales? " + resultado);
        
        System.out.println();
        System.out.println("Verificando que las colas se mantuvieron intactas:");
        System.out.println("Cola 1: " + cola1.mostrar());
        System.out.println("Cola 2: " + cola2.mostrar());
        
        System.out.println();
        System.out.println("Prueba con colas diferentes");
        
        // Crear tercera cola diferente
        Cola<Integer> cola3 = new Cola<>();
        cola3.encolar(10);
        cola3.encolar(25);
        cola3.encolar(30);
        
        System.out.println("Cola 1: " + cola1.mostrar());
        System.out.println("Cola 3: " + cola3.mostrar());
        System.out.println();
        
        resultado = sonIguales(cola1, cola3);
        System.out.println("¿Son iguales? " + resultado);
    }
    
    /**
     * Compara dos colas y verifica si son identicas.
     * Preserva el estado original de las colas.
     * 
     * @param cola1 Primera cola a comparar
     * @param cola2 Segunda cola a comparar
     * @return true si son identicas, false en caso contrario
     */
    public static boolean sonIguales(Cola<Integer> cola1, Cola<Integer> cola2) {
        
        // Verificar si tienen el mismo tamano
        if (cola1.getTamano() != cola2.getTamano()) {
            return false;
        }
        
        // Crear colas auxiliares para restaurar las originales
        Cola<Integer> aux1 = new Cola<>();
        Cola<Integer> aux2 = new Cola<>();
        
        boolean iguales = true;
        
        // Comparar elemento por elemento
        while (!cola1.estaVacia() && !cola2.estaVacia()) {
            Integer elem1 = cola1.desencolar();
            Integer elem2 = cola2.desencolar();
            
            // Guardar en auxiliares para restaurar
            aux1.encolar(elem1);
            aux2.encolar(elem2);
            
            // Comparar elementos
            if (!elem1.equals(elem2)) {
                iguales = false;
            }
        }
        
        // Restaurar colas originales
        while (!aux1.estaVacia()) {
            cola1.encolar(aux1.desencolar());
        }
        
        while (!aux2.estaVacia()) {
            cola2.encolar(aux2.desencolar());
        }
        
        return iguales;
    }
}
