package colas;

import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase que implementa un menú interactivo para manipular una cola desde consola
 */

public class ColaMenu {

    public static void main(String[] args) {
        int bandera; // Variable de control para el menú
        Scanner tcl = new Scanner(System.in);
        System.out.println("Bienvenido al menu de Cola");
        
        // Se crea una cola vacía de tipo String
        Cola<String> cola = new Cola();
        
        // Ciclo principal del menú
        do {
            bandera = 0;
            System.out.println();
            System.out.println("Seleccione algunas de las siguientes opciones");
            System.out.println("1 -> Insertar / 2 -> Ver frente / 3 -> Eliminar frente / 4 -> Mostrar cola / 5 -> Ver tamaño de cola / 0 -> Salir");
            
            // Lectura de la opción del usuario
            bandera = tcl.nextInt();
            tcl.nextLine(); // Limpia el buffer
            
            // Estructura switch para ejecutar la opción elegida
            switch (bandera) {
                case 1:
                    System.out.println();
                    System.out.println("Opción de insertar elegida");
                    System.out.print("Ingrese el dato a insertar: ");
                    cola.insertar(tcl.nextLine());
                    System.out.println("El dato insertado es: " + cola.getCola().getDato());
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Opción de ver frente elegida");
                    System.out.println("El frente de la cola es: " + cola.frente());
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Opción de eliminar frente elegida");
                    String dato = cola.quitar();
                    if(dato == null){
                        break;
                    }
                    System.out.println("El dato eliminado es: " + dato);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Opción de mostrar cola elegida");
                    System.out.println("El contenido de la cola es el siguiente");
                    cola.mostrar();
                    break;
                case 5: 
                    System.out.println();
                    System.out.println("Opción de mostrar tamaño elegida");
                    System.out.println("El tamaño de la cola es de: " + cola.getTamano());
                    // Falta break aquí en tu versión original
                 default:
                     System.out.println();
                     System.out.println("Elige una de las opciones");
            }            
        } while (bandera != 0); // Repite hasta que el usuario elija salir
        
        System.out.println();
        System.out.println("Programa terminado");
        tcl.close(); // Cierra el escáner
    }
}