package ejerciciosPracticos.ejerciciosPracticosDePilas.pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase generica que representa una Pila.
 * Una pila es una estructura de datos LIFO (Last In, First Out).
 * 
 * @param <T> Tipo de dato que contendran los elementos de la pila.
 */
public class Pila<T> {
    private Nodo<T> tope;

    /**
     * Constructor: inicializa la pila vacia.
     */
    public Pila() {
        this.tope = null;
    }

    /**
     * Inserta un nuevo elemento en el tope de la pila.
     * 
     * @param dato Elemento a insertar.
     */
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    /**
     * Elimina y retorna el elemento del tope de la pila.
     * 
     * @return Elemento que estaba en el tope, o null si esta vacia.
     */
    public T pop() {
        if (estaVacia()) {
            System.out.println("Error: la pila esta vacia");
            return null;
        }
        T valor = tope.getDato();
        tope = tope.getSiguiente();
        return valor;
    }

    /**
     * Verifica si la pila esta vacia.
     * 
     * @return true si la pila no tiene elementos.
     */
    public boolean estaVacia() {
        return tope == null;
    }

    /**
     * Muestra todos los elementos de la pila.
     * 
     * @return Cadena con los elementos de la pila.
     */
    public String mostrar() {
        if (estaVacia()) {
            return "[]";
        }
        
        String resultado = "[";
        Nodo<T> actual = tope;
        
        while (actual != null) {
            resultado += actual.getDato();
            if (actual.getSiguiente() != null) {
                resultado += ", ";
            }
            actual = actual.getSiguiente();
        }
        resultado += "]";
        return resultado;
    }
}