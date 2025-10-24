package colas;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase genérica que representa un nodo dentro de la estructura de la cola
 */

public class Nodo<T> {
    private T dato;         // Dato almacenado en el nodo
    private Nodo siguiente; // Referencia al siguiente nodo de la cola

    // Constructor: inicializa el nodo con un dato y sin siguiente
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Métodos setter y getter para modificar y obtener el dato
    public void setDato(T dato) {
        this.dato = dato;
    }

    // Asigna el siguiente nodo en la secuencia
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Devuelve el dato almacenado
    public T getDato() {
        return dato;
    }

    // Devuelve la referencia al siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Representación en texto del nodo (útil para depuración)
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
}