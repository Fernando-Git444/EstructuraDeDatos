package ejerciciosPracticos.ejerciciosPracticosDeListas.listaEnlazadaDePalabrasDesdeArchivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad 2:
 * Este programa lee palabras desde un archivo de texto, las almacena en una lista enlazada,
 * permite al usuario ver, agregar o eliminar palabras y finalmente guarda los cambios
 * en el mismo archivo.
 * 
 */
public class PruebaListaPalabras {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String archivo = "palabras.txt";
        boolean salir = false;

        System.out.println("Lista enlazada de palabras");
        System.out.println("Archivo: " + archivo);

        // Cargamos las palabras
        cargarArchivo(archivo);

        do {
            System.out.println("Opciones:");
            System.out.println("1) Mostrar palabras");
            System.out.println("2) Añadir palabra");
            System.out.println("3) Eliminar palabra");
            System.out.println("4) Guardar y salir");
            System.out.println("5) Salir sin guardar");
            System.out.print("Seleccione una opción (1-5): ");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    System.out.println("Lista actual:");
                    System.out.println(lista.recorrer());
                    break;

                case 2:
                    System.out.println();
                    System.out.print("Ingrese la palabra a añadir: ");
                    String nueva = teclado.nextLine().trim();
                    if (!nueva.isEmpty()) {
                        lista.insertarAlFinal(nueva);
                        System.out.println("'" + nueva + "' añadida correctamente.");
                    } else {
                        System.out.println("No se añadió ninguna palabra, palabra vacia");
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Ingrese la palabra a eliminar: ");
                    String palabra = teclado.nextLine().trim();
                    if (eliminarPalabra(palabra)) {
                        System.out.println("La palabra: '" + palabra + "' fue eliminada con éxito.");
                    } else {
                        System.out.println("La palabra no se encontró en la lista.");
                    }
                    break;

                case 4:
                    System.out.println();
                    escribirArchivo(archivo);
                    System.out.println("Cambios guardados en " + archivo);
                    salir = true;
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Saliendo sin guardar");
                    salir = true;
                    break;

                default:
                    System.out.println();
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while(!salir);

        teclado.close();
        System.out.println();
        System.out.println("Programa finalizado correctamente.");
    }

    // Lista enlazada que almacena las palabras leídas
    private static ListaEnlazada<String> lista = new ListaEnlazada<>();

    /**
     * Carga las palabras desde un archivo de texto y las guarda en la lista.
     * Si el archivo no existe, se crea más adelante al guardar.
     * 
     * @param nombreArchivo Nombre del archivo que se leerá.
     */
    public static void cargarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("No se encontró el archivo " + nombreArchivo + ". Se creará al guardar.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split("\\s+");
                for (String palabra : partes) {
                    if (!palabra.isEmpty()) {
                        lista.insertarAlFinal(palabra);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    /**
     * Escribe las palabras almacenadas en la lista hacia el archivo indicado.
     * 
     * @param nombreArchivo Nombre del archivo donde se guardarán las palabras.
     */
    public static void escribirArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            String[] elementos = lista.recorrer().split(", ");
            for (int i = 0; i < elementos.length; i++) {
                bw.write(elementos[i]);
                if (i < elementos.length - 1) bw.write(" ");
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Elimina la primera ocurrencia de una palabra en la lista.
     * 
     * @param palabra Palabra que se desea eliminar.
     * @return true si se eliminó con éxito, false si no se encontró.
     */
    public static boolean eliminarPalabra(String palabra) {
        // Creamos una lista auxiliar para reconstruir sin la palabra eliminada
        ListaEnlazada<String> nuevaLista = new ListaEnlazada<>();
        String[] elementos = lista.recorrer().split(", ");
        boolean eliminada = false;

        for (String p : elementos) {
            if (!eliminada && p.equalsIgnoreCase(palabra)) {
                eliminada = true;
            } else {
                nuevaLista.insertarAlFinal(p);
            }
        }

        lista = nuevaLista; // Actualizamos la lista principal
        return eliminada;
    }
}