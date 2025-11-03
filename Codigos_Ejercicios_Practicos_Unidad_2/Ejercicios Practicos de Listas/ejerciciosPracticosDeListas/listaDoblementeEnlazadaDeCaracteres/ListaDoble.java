package ejerciciosPracticos.ejerciciosPracticosDeListas.listaDoblementeEnlazadaDeCaracteres;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa una lista doblemente enlazada de caracteres.
 * 
 * Permite insertar caracteres, mostrar la lista en orden normal
 * y ordenarla alfabéticamente sin perder las referencias entre nodos.
 */
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    /**
     * Constructor: crea una lista vacía.
     */
    public ListaDoble() {
        cabeza = null;
        cola = null;
    }

    /**
     * Inserta un nuevo carácter al final de la lista.
     * 
     * @param dato Carácter a insertar.
     */
    public void insertar(char dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }

    /**
     * Muestra los caracteres en orden normal (de izquierda a derecha).
     * 
     * @return Cadena con los caracteres.
     */
    public String mostrar() {
        if (cabeza == null) {
            return "Lista vacía";
        }

        StringBuilder sb = new StringBuilder();
        NodoDoble actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(" ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    /**
     * Ordena la lista alfabéticamente usando el algoritmo de burbuja.
     * 
     * Compara los caracteres de los nodos y los intercambia si están en orden incorrecto.
     */
    public void ordenar() {
        if (cabeza == null) return;

        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            NodoDoble actual = cabeza;

            while (actual.getSiguiente() != null) {
                if (Character.toLowerCase(actual.getDato()) > Character.toLowerCase(actual.getSiguiente().getDato())) {
                    // Intercambiar valores
                    char temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    huboIntercambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (huboIntercambio);
    }
}