package ejerciciosPracticos.ejerciciosPracticosDeColas.cola;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un nodo generico dentro de una cola.
 * 
 * @param <T> Tipo de dato que almacenara el nodo
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    /**
     * Constructor que inicializa el nodo con un valor.
     * 
     * @param dato Valor que contendra el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    // Metodos de acceso getters y setters

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}