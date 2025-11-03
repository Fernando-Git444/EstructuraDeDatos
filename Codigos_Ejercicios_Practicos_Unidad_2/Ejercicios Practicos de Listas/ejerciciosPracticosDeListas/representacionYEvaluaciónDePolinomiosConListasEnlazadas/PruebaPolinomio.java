package ejerciciosPracticos.ejerciciosPracticosDeListas.representacionYEvaluaciónDePolinomiosConListasEnlazadas;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad 03:
 * Representación y Evaluación de Polinomios con Listas Enlazadas
 * 
 * Este programa permite ingresar los términos de un polinomio en forma de pares:
 * (coeficiente, exponente). Luego representa el polinomio en una lista enlazada
 * y calcula sus valores para x desde 0.0 hasta 5.0 en incrementos de 0.5,
 * mostrando los resultados en forma tabular.
 */
public class PruebaPolinomio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();

        System.out.println("Representación y Evaluación de Polinomios");
        System.out.println("Ingrese los términos del polinomio (coeficiente y exponente).");
        System.out.println("Ejemplo: para 3x^4 - 4x^2 + 11, ingrese: 3 4, -4 2, 11 0");
        System.out.println("Ingrese 'fin' cuando haya terminado.");
        System.out.println();

        // Lectura de términos
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

        // Mostrar el polinomio
        System.out.println("Polinomio ingresado:");
        System.out.println(polinomio.mostrar());

        // Evaluación desde x = 0.0 hasta x = 5.0 con incremento de 0.5
        System.out.println();
        System.out.println("Tabla de valores:");
        System.out.println("------------------------");
        System.out.println(" x\t|\tP(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double resultado = polinomio.evaluar(x);
            System.out.printf(" %.1f\t|\t%.3f%n", x, resultado);
        }
        System.out.println("------------------------");

        teclado.close();
        System.out.println();
        System.out.println("Programa finalizado correctamente.");
    }
}