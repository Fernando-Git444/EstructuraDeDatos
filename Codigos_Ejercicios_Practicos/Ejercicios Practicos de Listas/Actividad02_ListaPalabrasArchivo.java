package ejerciciosPracticosDeListas;

import java.io.*;
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad02_ListaPalabrasArchivo.java
 * Lee palabras desde "palabras.txt", las almacena en una lista enlazada simple,
 * permite añadir/eliminar palabras, y escribe de vuelta al archivo.
 *
 * Formato: palabras separadas por espacios o saltos de línea.
 */
public class Actividad02_ListaPalabrasArchivo {

    static class Nodo {
        String palabra;
        Nodo siguiente;
        Nodo(String p) { palabra = p; siguiente = null; }
    }

    private Nodo cabeza = null;

    // Insertar al final
    public void insertarAlFinal(String palabra) {
        Nodo nuevo = new Nodo(palabra);
        if (cabeza == null) {
            cabeza = nuevo; return;
        }
        Nodo p = cabeza;
        while (p.siguiente != null) p = p.siguiente;
        p.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[Lista vacía]"); return;
        }
        Nodo p = cabeza;
        System.out.print("Lista de palabras: ");
        while (p != null) {
            System.out.print(p.palabra + (p.siguiente != null ? " " : ""));
            p = p.siguiente;
        }
        System.out.println();
    }

    // Eliminar primera ocurrencia de palabra (si existe)
    public boolean eliminarPalabra(String palabra) {
        if (cabeza == null) return false;
        if (cabeza.palabra.equals(palabra)) {
            cabeza = cabeza.siguiente; return true;
        }
        Nodo p = cabeza;
        while (p.siguiente != null) {
            if (p.siguiente.palabra.equals(palabra)) {
                p.siguiente = p.siguiente.siguiente; return true;
            }
            p = p.siguiente;
        }
        return false;
    }

    // Escribir lista de palabras a archivo (separadas por espacios)
    public void escribirAArchivo(String nombreArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Nodo p = cabeza;
            boolean first = true;
            while (p != null) {
                if (!first) bw.write(" ");
                bw.write(p.palabra);
                first = false;
                p = p.siguiente;
            }
            bw.newLine();
        }
    }

    // Cargar palabras desde archivo
    public void cargarDesdeArchivo(String nombreArchivo) throws IOException {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            System.out.println("Archivo no encontrado: " + nombreArchivo + ". Se creará al guardar.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split("\\s+");
                for (String p : partes) {
                    if (!p.isEmpty()) insertarAlFinal(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        Actividad02_ListaPalabrasArchivo programa = new Actividad02_ListaPalabrasArchivo();
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "palabras.txt";
        
        System.out.println("Nota: el programa intentará leer palabras.txt en el directorio de trabajo. Si no existe, te avisará y lo creará cuando elijas \"Guardar y salir\".");
        System.out.println("Actividad 02: Lista enlazada de palabras desde archivo (" + nombreArchivo + ")");

        // Cargar
        try {
            programa.cargarDesdeArchivo(nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        // Interacción simple
        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones: 1) Mostrar  2) Añadir  3) Eliminar  4) Guardar y salir  5) Salir sin guardar");
            System.out.print("Elige una opción (1-5): ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    programa.mostrar();
                    break;
                case "2":
                    System.out.print("Ingresa la palabra a añadir: ");
                    String p = sc.nextLine().trim();
                    if (!p.isEmpty()) {
                        programa.insertarAlFinal(p);
                        System.out.println("'" + p + "' añadida.");
                    }
                    break;
                case "3":
                    System.out.print("Ingresa la palabra a eliminar (se elimina la primera ocurrencia): ");
                    String e = sc.nextLine().trim();
                    if (programa.eliminarPalabra(e)) System.out.println("Eliminada: " + e);
                    else System.out.println("No se encontró: " + e);
                    break;
                case "4":
                    try {
                        programa.escribirAArchivo(nombreArchivo);
                        System.out.println("Guardado en " + nombreArchivo + ". Saliendo...");
                    } catch (IOException ex) {
                        System.out.println("Error al guardar: " + ex.getMessage());
                    }
                    salir = true;
                    break;
                case "5":
                    System.out.println("Saliendo sin guardar...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}