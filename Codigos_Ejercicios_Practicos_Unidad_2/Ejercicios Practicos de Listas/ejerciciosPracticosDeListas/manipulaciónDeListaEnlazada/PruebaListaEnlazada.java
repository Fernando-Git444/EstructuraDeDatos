package ejerciciosPracticos.ejerciciosPracticosDeListas.manipulaciónDeListaEnlazada;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad 1:
 * Funcionamiento de la lista enlazada
 * Aquí se crean números aleatorios, se insertan en la lista,
 * se muestra la lista completa, se solicita un valor límite
 * y se eliminan los elementos mayores a dicho valor.
 * 
 */
public class PruebaListaEnlazada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        // Insertamos números aleatorios entre 1 y 100
        System.out.println("Insertando 10 números aleatorios en la lista");
        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(100) + 1;
            lista.insertarAlFinal(valor);
        }

        // Mostramos la lista actual
        System.out.println();
        System.out.println("Lista inicial:");
        System.out.println(lista.recorrer());

        // Pedimos al usuario un valor límite
        System.out.println();
        System.out.print("Ingrese un valor límite (se eliminarán los mayores que dicho número): ");
        boolean bandera = false;
        
        int limite = 0;
        do {     
            try {
                limite = Integer.parseInt(sc.nextLine());
                bandera = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, ingrese un valor adecuado");
            }
        } while (!bandera);

        // Eliminamos los elementos mayores al límite
        lista.eliminarMayoresQue(limite);

        // Mostramos la lista final
        System.out.println();
        System.out.println("Lista después de eliminar los mayores que " + limite + ":");
        System.out.println(lista.recorrer());
        
        System.out.println();
        System.out.println("Programa finalizado correctamente.");
    }
}