package ejerciciosPracticos.ejerciciosPracticosDeColas.cola;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase generica que representa una Cola.
 * Una cola es una estructura de datos FIFO (First In, First Out).
 * El primer elemento en entrar es el primero en salir.
 * 
 * @param <T> Tipo de dato que contendran los elementos de la cola.
 */
public class Cola<T> {
    private Nodo<T> cabeza;
    private Nodo<T> finalCola;
    private int tamano;

    /**
     * Constructor: inicializa la cola vacia.
     */
    public Cola() {
        this.cabeza = null;
        this.finalCola = null;
        this.tamano = 0;
    }

    /**
     * Inserta un nuevo elemento al final de la cola.
     * 
     * @param dato Elemento a insertar.
     */
    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        
        if (estaVacia()) {
            cabeza = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.setSiguiente(nuevo);
            finalCola = nuevo;
        }
        tamano++;
    }

    /**
     * Elimina y retorna el elemento del frente de la cola.
     * 
     * @return Elemento que estaba al frente, o null si esta vacia.
     */
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Error: la cola esta vacia");
            return null;
        }
        
        T valor = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        
        if (cabeza == null) {
            finalCola = null;
        }
        
        tamano--;
        return valor;
    }

    /**
     * Retorna el elemento del frente sin eliminarlo.
     * 
     * @return Elemento que esta al frente, o null si esta vacia.
     */
    public T verFrente() {
        if (estaVacia()) {
            return null;
        }
        return cabeza.getDato();
    }

    /**
     * Verifica si la cola esta vacia.
     * 
     * @return true si la cola no tiene elementos.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Retorna el numero de elementos en la cola.
     * 
     * @return Tamano de la cola.
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Muestra todos los elementos de la cola.
     * 
     * @return Cadena con los elementos de la cola.
     */
    public String mostrar() {
        if (estaVacia()) {
            return "[]";
        }
        
        String resultado = "[";
        Nodo<T> actual = cabeza;
        
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
