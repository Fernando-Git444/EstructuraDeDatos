package ejerciciosPracticos.ejerciciosPracticosDePilas.pruebaVerificarPalindromo;

import java.util.Scanner;
import ejerciciosPracticos.ejerciciosPracticosDePilas.pila.Pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 10: Verificar palindromo
 * 
 * Objetivo: Determinar si una palabra es palindroma usando pila.
 * 
 * Algoritmo:
 * 1. Apilar caracteres de la palabra
 * 2. Desapilar para formar palabra invertida
 * 3. Comparar con la palabra original
 */
public class PruebaVerificarPalindromo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ejercicio 10: Verificar palindromo");
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
        
        // Desapilar para formar palabra invertida
        String invertida = "";
        while (!pila.estaVacia()) {
            invertida += pila.pop();
        }
        
        System.out.println("Palabra original: " + palabra);
        System.out.println("Palabra invertida: " + invertida);
        System.out.println();
        
        // Comparar palabras
        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }        
        sc.close();
    }
}
