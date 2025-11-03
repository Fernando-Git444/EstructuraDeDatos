package ejerciciosPracticos.ejerciciosPracticosDeListas.listaDoblementeEnlazadaDeCaracteres;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un nodo dentro de una lista doblemente enlazada.
 * 
 * Cada nodo almacena un carácter, una referencia al nodo anterior
 * y otra al nodo siguiente, lo que permite recorrer la lista en ambos sentidos.
 * 
 */
public class NodoDoble {
    private char dato;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    /**
     * Constructor que inicializa el nodo con un carácter.
     * 
     * @param dato Carácter a almacenar.
     */
    public NodoDoble(char dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    // Métodos de acceso getters y setters
    
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}