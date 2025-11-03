/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosPracticos.ejerciciosPracticosDeListas.polinomioConListaEnlazadaCircular;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad 04:
 * Polinomio con Lista Enlazada Circular
 * 
 * Este programa representa un polinomio mediante una lista enlazada circular,
 * donde el último nodo apunta nuevamente al primero, permitiendo un recorrido continuo.
 * 
 * El usuario ingresa los términos (coeficiente y exponente), y el programa
 * muestra el polinomio recorriéndolo de forma circular desde el primer nodo.
 */
public class PruebaPolinomioCircular {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        PolinomioCircular polinomio = new PolinomioCircular();

        System.out.println("Representación de Polinomio con Lista Enlazada Circular");
        System.out.println("Ingrese los términos del polinomio (coeficiente y exponente).");
        System.out.println("Ejemplo: para 3x^4 - 4x^2 + 11, ingrese: 3 4, -4 2, 11 0");
        System.out.println("Ingrese 'fin' cuando haya terminado.");
        System.out.println();

        // Lectura de términos del polinomio
        while (true) {
            System.out.print("Coeficiente (o 'fin'): ");
            String entrada = teclado.next();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                double coef = Double.parseDouble(entrada);
                System.out.print("Exponente: ");
                int exp = teclado.nextInt();
                polinomio.agregarTermino(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }

        // Mostrar el polinomio en formato legible
        System.out.println();
        System.out.println("Polinomio ingresado:");
        System.out.println(polinomio.mostrar());

        // Recorrido circular de comprobación
        System.out.println();
        System.out.println("Recorriendo de forma circular (una vuelta completa):");
        polinomio.recorrerCircular();

        teclado.close();
        System.out.println();
        System.out.println("Programa finalizado correctamente.");
    }
}