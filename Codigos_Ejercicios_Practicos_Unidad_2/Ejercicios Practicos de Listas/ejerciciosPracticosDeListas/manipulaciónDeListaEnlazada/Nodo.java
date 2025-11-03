package ejerciciosPracticos.ejerciciosPracticosDeListas.manipulaciónDeListaEnlazada;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un nodo genérico dentro de una lista enlazada simple.
 * 
 * @param <T> Tipo de dato que almacenará el nodo (puede ser Integer, String, etc.)
 * 
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

     /**
     * Constructor que inicializa el nodo con un valor.
     * Por defecto, el puntero siguiente queda en null.
     * 
     * @param dato Valor que contendrá el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Métodos de acceso getters y setters
    
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    
    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }
}
