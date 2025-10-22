package pila;

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