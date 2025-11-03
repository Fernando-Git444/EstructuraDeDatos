package ejerciciosPracticos.ejerciciosPracticosDePilas.invertirPalabra;

import java.util.Scanner;
import ejerciciosPracticos.ejerciciosPracticosDePilas.pila.Pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 4: Invertir una palabra
 * 
 * Objetivo: Invertir una palabra usando una pila de caracteres.
 * 
 * Algoritmo:
 * 1. Leer palabra del usuario
 * 2. Apilar cada letra
 * 3. Desapilar e imprimir
 */
public class PruebaInvertirPalabra {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ejercicio 4: Invertir una palabra");
        System.out.println();
        
        // Leer palabra del usuario
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();
        
        System.out.println();
        
        // Crear pila de caracteres
        Pila<Character> pila = new Pila<>();
        
        // Apilar cada caracter
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }
        
        // Desapilar e imprimir invertido
        System.out.print("Invertida: ");
        while (!pila.estaVacia()) {
            System.out.print(pila.pop());
        }        
        sc.close();
    }
}