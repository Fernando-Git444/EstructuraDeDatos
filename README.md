# Estructura de Datos
## En este repositorio se encontraran todas las actividades de la materia

### Fernando Vega Negrete 1224100720.fvn@gmail.com
### GTID141 1224100720

## Unidad 2
### Enlaces
#### 🧭 [Ejercicios Guiados](#ejercicios-guiados)
#### 🧪 [Ejercicios Prácticos](#ejercicios-practicos)

## Ejercicios Guiados

| Nombre         | Ejercicio      |
|----------------|----------------|
|Nearpod_Listas_en_Java|[Nearpod_Listas_en_Java.pdf](https://github.com/user-attachments/files/22993707/Nearpod_Listas_en_Java.pdf)|
|U2ACT1 Ejercicio de Lista Enlazada Simple con VisuAlgo|[U2ACT1 Ejercicio de Lista Enlazada Simple con VisuAlgo.pdf](https://github.com/user-attachments/files/22993721/U2ACT1.Ejercicio.de.Lista.Enlazada.Simple.con.VisuAlgo.pdf)|
|U2ACT2 Lista Encantada Humana en Java|[U2ACT2 Lista Encantada Humana en Java.pdf](https://github.com/user-attachments/files/22993728/U2ACT2.Lista.Encantada.Humana.en.Java.pdf)|
|U2ACT3 Práctica Manual y Algorítmica Lista|[U2ACT3 Práctica Manual y Algorítmica Lista.pdf](https://github.com/user-attachments/files/22993735/U2ACT3.Practica.Manual.y.Algoritmica.Lista.pdf)|
|U2ACT2 Especificación de la Pila|[Ver codigo](https://github.com/Fernando-Git444/EstructuraDeDatos/tree/5a0165886fb26011e2bbabed8bf8a811766a0f51/Codigos_Ejercicios_Guiados_Unidad_2/U2ACT2%20Especificaci%C3%B3n%20de%20la%20Pila)|
## Interfaz IStack 
```java
/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 */

/**
 * @param <T> tipo de dato que almacenará la pila
 *  Interface lista para implemetarse en la clase StackArray que simulara una pila estatica(tamaño definido)
 */

public interface IStack<T> {
    
    /**
     * Inserta un elemento en la cima de la pila.
     * @param elemento valor a agregar
     */
    void push(T elemento);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return elemento eliminado o null si la pila está vacía
     */
    T pop();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * @return elemento en la cima o null si la pila está vacía
     */
    T peak();

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila no contiene elementos, false en caso contrario
     */
    boolean isEmpty();
}
```
## Clase StackArray
```java
/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * @param <T> tipo de elemento que contendrá la pila
 * Clase que simula una pila estatica(tamaño definido)
 */
public class StackArray<T> implements IStack<T> {
    
    private T[] elements;  // Estructura de datos interna (Array)
    private int top;       // Índice de la cima

    /**
     * Constructor por defecto que inicializa la pila con tamaño 30.
     */
    public StackArray() {
        elements = (T[]) new Object[30];
        top = 0;
    }

    /**
     * Constructor que permite definir el tamaño máximo de la pila.
     * @param size tamaño máximo del arreglo interno
     */
    public StackArray(int size) {
        elements = (T[]) new Object[size];
        top = 0;
    }

    /**
     * Inserta un nuevo elemento en la cima de la pila.
     * @param element elemento a agregar
     */
    @Override
    public void push(T element) {
        if (top < elements.length) {
            elements[top] = element;
            top++;
        } else {
            System.out.println("Se ha llegado al límite de la pila.");
        }
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return elemento eliminado o null si la pila está vacía
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía.");
            return null;
        }
        top--;
        T value = elements[top];
        elements[top] = null;
        return value;
    }

    /**
     * Devuelve el elemento en la cima sin eliminarlo.
     * @return elemento en la cima o null si la pila está vacía
     */
    @Override
    public T peak() {
        if (isEmpty()) {
            System.out.println("Pila vacía.");
            return null;
        }
        System.out.println("Conociendo el último de la pila");
        return elements[top - 1];
    }

    /**
     * Verifica si la pila se encuentra vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    // Muestra los elementos de la pila como texto
    @Override
    public String toString() {
        String list = "";
        for (T x : elements) {
            list += x + "\n";
        }
        return list;
    }
}
```
## Clase Main
```java
/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

public class MainStackArray {
    // Método principal del programa.
    public static void main(String[] args) {
        // Crear una pila de tipo String con capacidad para 5 elementos
        StackArray<String> nombres = new StackArray<>(5);
        
        // Agregar elementos a la pila
        nombres.push("Isaac");
        nombres.push("Susy");
        nombres.push("Alejandro");
        nombres.push("Tere");
        
        // Eliminar los dos últimos
        nombres.pop();
        System.out.println(nombres.pop());
        
        // Mostrar el elemento actual en la cima
        System.out.println(nombres.peak() + "\n");
        
        // Mostrar todos los elementos restantes
        System.out.println(nombres);
    }   
}
```
## Ejercicios Practicos
| Nombre         | Ejercicio      |
|----------------|----------------|
|Ejercicios Practicos de Listas|Ver codigo abajo|
### Actividad01_ListaEnteros
```java
import java.util.Random;
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad01_ListaEnteros.java
 * Lista enlazada simple: insertar al final, mostrar, eliminar nodos con dato > límite.
 */
public class Actividad01_ListaEnteros {

    static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int d) { dato = d; siguiente = null; }
    }

    private Nodo cabeza = null;

    // Insertar al final
    public void insertarAlFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo p = cabeza;
        while (p.siguiente != null) p = p.siguiente;
        p.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[Lista vacía]");
            return;
        }
        Nodo p = cabeza;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.dato + (p.siguiente != null ? " -> " : ""));
            p = p.siguiente;
        }
        System.out.println();
    }

    // Eliminar nodos con dato > limite
    public void eliminarMayoresQue(int limite) {
        // Eliminar del inicio mientras cabeza > limite
        while (cabeza != null && cabeza.dato > limite) {
            cabeza = cabeza.siguiente;
        }
        if (cabeza == null) return;
        Nodo p = cabeza;
        while (p.siguiente != null) {
            if (p.siguiente.dato > limite) {
                // saltar el nodo
                p.siguiente = p.siguiente.siguiente;
            } else {
                p = p.siguiente;
            }
        }
    }

    public static void main(String[] args) {
        Actividad01_ListaEnteros lista = new Actividad01_ListaEnteros();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Actividad 01: Lista enlazada de enteros (inserción al final).");
        System.out.print("¿Cuántos números aleatorios quieres generar? (ej. 10): ");
        int n = 10;
        try { n = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { /* usar 10 */ }

        for (int i = 0; i < n; i++) {
            int val = rnd.nextInt(100) + 1; // 1..100
            lista.insertarAlFinal(val);
        }

        System.out.println("\nLista generada:");
        lista.mostrar();

        System.out.print("\nIngresa un valor límite (se eliminarán nodos con valor > límite): ");
        int limite;
        try {
            limite = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Usando límite = 50.");
            limite = 50;
        }

        lista.eliminarMayoresQue(limite);
        System.out.println("\nLista después de eliminar nodos mayores que " + limite + ":");
        lista.mostrar();

        sc.close();
    }
}
```
### Actividad02_ListaPalabrasArchivo
```java
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
```
### Actividad03_PolinomioLista
```java
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad03_PolinomioLista.java
 * Representación de polinomio con lista enlazada (nodos con coeficiente y exponente).
 * Evaluación para x desde 0.0 a 5.0 con paso 0.5.
 */
public class Actividad03_PolinomioLista {

    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; siguiente = null; }
    }

    private Nodo cabeza = null;

    // Insertar al final (orden de aparición)
    public void insertarTermino(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
        if (cabeza == null) { cabeza = nuevo; return; }
        Nodo p = cabeza;
        while (p.siguiente != null) p = p.siguiente;
        p.siguiente = nuevo;
    }

    // Evaluar P(x)
    public double evaluar(double x) {
        double suma = 0.0;
        Nodo p = cabeza;
        while (p != null) {
            suma += p.coef * Math.pow(x, p.exp);
            p = p.siguiente;
        }
        return suma;
    }

    // Mostrar representación: término por término
    public void mostrarPolinomio() {
        if (cabeza == null) {
            System.out.println("[Polinomio vacío]"); return;
        }
        Nodo p = cabeza;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            String term = String.format("%.2f*x^%d", p.coef, p.exp);
            sb.append(term);
            if (p.siguiente != null) sb.append("  +  ");
            p = p.siguiente;
        }
        System.out.println("Polinomio (orden de entrada): " + sb.toString());
    }

    public static void main(String[] args) {
        Actividad03_PolinomioLista pol = new Actividad03_PolinomioLista();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 03: Representación y evaluación de polinomios.");
        System.out.println("Ingresa términos en pares: coeficiente exponente (por ejemplo: 3 4).");
        System.out.println("Escribe una línea vacía para terminar la entrada.");

        while (true) {
            System.out.print("Ingresa coef y exponente (o ENTER para terminar): ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) break;
            String[] partes = linea.split("\\s+");
            if (partes.length < 2) {
                System.out.println("Entrada inválida. Debes dar dos valores: coef exp");
                continue;
            }
            try {
                double coef = Double.parseDouble(partes[0]);
                int exp = Integer.parseInt(partes[1]);
                pol.insertarTermino(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Intenta de nuevo.");
            }
        }

        System.out.println();
        pol.mostrarPolinomio();

        // Evaluar desde 0.0 a 5.0 paso 0.5
        System.out.println("\nTabla de valores P(x):");
        System.out.println(" x    |   P(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0 + 1e-9; x += 0.5) {
            double val = pol.evaluar(x);
            System.out.printf("%4.1f  |  %.6f%n", x, val);
        }

        sc.close();
    }
}
```
### Actividad04_PolinomioCircular
```java
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad04_PolinomioCircular.java
 * Lista enlazada circular para polinomio. La referencia de acceso es el último nodo.
 */
public class Actividad04_PolinomioCircular {

    static class Nodo {
        double coef;
        int exp;
        Nodo siguiente;
        Nodo(double c, int e) { coef = c; exp = e; siguiente = null; }
    }

    // referencia al último nodo (si lista vacía, ultimo == null)
    private Nodo ultimo = null;

    // Insertar al final (último)
    public void insertarAlFinal(double coef, int exp) {
        Nodo nuevo = new Nodo(coef, exp);
        if (ultimo == null) {
            nuevo.siguiente = nuevo; // apunta a sí mismo
            ultimo = nuevo;
            return;
        }
        nuevo.siguiente = ultimo.siguiente; // primero actual
        ultimo.siguiente = nuevo;
        ultimo = nuevo;
    }

    // Mostrar recorrido circular (desde primero = ultimo.siguiente)
    public void mostrarCircular() {
        if (ultimo == null) {
            System.out.println("[Lista circular vacía]"); return;
        }
        Nodo inicio = ultimo.siguiente;
        Nodo p = inicio;
        System.out.print("Polinomio (circular): ");
        do {
            System.out.print(String.format("%.2f*x^%d", p.coef, p.exp));
            p = p.siguiente;
            if (p != inicio) System.out.print("  ->  ");
        } while (p != inicio);
        System.out.println();
    }

    // Evaluar polinomio (recorrer todos los nodos una vez)
    public double evaluar(double x) {
        if (ultimo == null) return 0.0;
        Nodo inicio = ultimo.siguiente;
        Nodo p = inicio;
        double suma = 0.0;
        do {
            suma += p.coef * Math.pow(x, p.exp);
            p = p.siguiente;
        } while (p != inicio);
        return suma;
    }

    public static void main(String[] args) {
        Actividad04_PolinomioCircular pol = new Actividad04_PolinomioCircular();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 04: Polinomio con lista enlazada circular.");
        System.out.println("Ingresa términos en pares: coeficiente exponente (ej. 3 4). Línea vacía para terminar.");

        while (true) {
            System.out.print("Ingresa coef y exponente (o ENTER para terminar): ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) break;
            String[] partes = linea.split("\\s+");
            if (partes.length < 2) {
                System.out.println("Entrada inválida.");
                continue;
            }
            try {
                double coef = Double.parseDouble(partes[0]);
                int exp = Integer.parseInt(partes[1]);
                pol.insertarAlFinal(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido.");
            }
        }

        System.out.println();
        pol.mostrarCircular();

        System.out.println("\nEvaluación P(x) para x=0.0..5.0 paso 0.5:");
        System.out.println(" x    |   P(x)");
        System.out.println("------------------------");
        for (double x = 0.0; x <= 5.0 + 1e-9; x += 0.5) {
            double val = pol.evaluar(x);
            System.out.printf("%4.1f  |  %.6f%n", x, val);
        }

        sc.close();
    }
}
```
### Actividad05_ListaDobleCaracteres
```java
import java.util.Scanner;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Actividad05_ListaDobleCaracteres.java
 * Lista doblemente enlazada construida desde una cadena de entrada.
 * Ordenamiento alfabético: se realiza swapping de los datos de los nodos para
 * simplificar y evitar manipulación compleja de punteros (la estructura sigue siendo válida).
 */
public class Actividad05_ListaDobleCaracteres {

    static class NodoDoble {
        char dato;
        NodoDoble prev;
        NodoDoble next;
        NodoDoble(char d) { dato = d; prev = next = null; }
    }

    private NodoDoble cabeza = null;
    private NodoDoble cola = null;

    // Construir lista a partir de cadena: cada carácter (incluye espacio si quieres, por defecto omito espacios)
    public void construirDesdeCadena(String s) {
        for (char c : s.toCharArray()) {
            if (c == ' ') continue; // omitir espacios; si quieres incluir espacios, elimina esta línea
            NodoDoble nuevo = new NodoDoble(c);
            if (cabeza == null) {
                cabeza = cola = nuevo;
            } else {
                cola.next = nuevo;
                nuevo.prev = cola;
                cola = nuevo;
            }
        }
    }

    // Mostrar desde cabeza hacia adelante
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("[Lista vacía]"); return;
        }
        NodoDoble p = cabeza;
        System.out.print("Lista: ");
        while (p != null) {
            System.out.print(p.dato);
            p = p.next;
        }
        System.out.println();
    }

    // Ordenamiento alfabético (burbuja) intercambiando datos de nodos
    public void ordenarAlfabeticamente() {
        if (cabeza == null) return;
        boolean huboCambio;
        do {
            huboCambio = false;
            NodoDoble p = cabeza;
            while (p.next != null) {
                if (Character.toLowerCase(p.dato) > Character.toLowerCase(p.next.dato)) {
                    // swap datos
                    char tmp = p.dato;
                    p.dato = p.next.dato;
                    p.next.dato = tmp;
                    huboCambio = true;
                }
                p = p.next;
            }
        } while (huboCambio);
    }

    public static void main(String[] args) {
        Actividad05_ListaDobleCaracteres programa = new Actividad05_ListaDobleCaracteres();
        Scanner sc = new Scanner(System.in);

        System.out.println("Actividad 05: Lista doblemente enlazada de caracteres.");
        System.out.print("Ingresa una cadena (los espacios serán omitidos en la lista): ");
        String linea = sc.nextLine();

        programa.construirDesdeCadena(linea);
        System.out.println("\nLista original:");
        programa.mostrar();

        programa.ordenarAlfabeticamente();
        System.out.println("\nLista ordenada alfabéticamente:");
        programa.mostrar();

        sc.close();
    }
}
```
