package pila;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 */

/**
 * @param <T> tipo de dato que almacenará la pila
 * Interface lista para implemetarse en la clase StackArray que simulara una pila estatica(tamaño definido)
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