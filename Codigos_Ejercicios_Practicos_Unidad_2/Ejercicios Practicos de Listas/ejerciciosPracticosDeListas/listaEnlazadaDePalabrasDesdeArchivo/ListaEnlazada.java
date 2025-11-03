package ejerciciosPracticos.ejerciciosPracticosDeListas.listaEnlazadaDePalabrasDesdeArchivo;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase genérica que representa una lista enlazada simple.
 * Permite insertar elementos, recorrerlos y eliminar aquellos y que
 * cumplan con una condición (en este caso, ser mayores a un valor dado).
 * 
 * @param <T> Tipo de dato que contendrán los nodos.
 */
public class ListaEnlazada<T extends Comparable<T>> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    /**
     * Constructor: inicializa la lista vacía.
     */
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    /**
     * Inserta un nuevo nodo al final de la lista.
     * 
     * @param valor Elemento a insertar.
     */
    public void insertarAlFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
    }

    /**
     * Recorre la lista y construye una cadena de texto con todos los elementos.
     * 
     * @return Cadena representando los elementos de la lista.
     */
    public String recorrer() {
        if (cabeza == null) {
            return "(lista vacía)";
        }
        
        String lista = "";
        Nodo<T> actual = cabeza;
        
        while (actual != null) {
            lista += actual.getDato();
            if (actual.getSiguiente() != null) {
                lista += ", ";
            }
            actual = actual.getSiguiente();
        }
            return lista;
    }

    /**
     * Elimina todos los elementos mayores que el valor límite proporcionado.
     * Solo aplica si los datos son comparables.
     * 
     * @param limite Valor límite para eliminar elementos.
     */
    public void eliminarMayoresQue(T limite) {
        // Eliminar nodos al principio si son mayores al límite
        while (cabeza != null && cabeza.getDato().compareTo(limite) > 0) {
            cabeza = cabeza.getSiguiente();
        }

        // Recorremos el resto de la lista
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;

        while (actual != null) {
            if (actual.getDato().compareTo(limite) > 0) {
                // Eliminar el nodo actual
                if (anterior != null) {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                // Si era el último, actualizamos la cola
                if (actual == cola) {
                    cola = anterior;
                }
            } else {
                anterior = actual;
            }
            actual = actual.getSiguiente();
        }
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si no hay elementos en la lista.
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
}