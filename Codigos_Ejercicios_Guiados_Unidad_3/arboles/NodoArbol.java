package mx.edu.utng.tics.arboles;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase base que simula un Nodo de un Arbol Binario
 */
public class NodoArbol {
    private int dato;
    public NodoArbol hijoIzquierdo;
    public NodoArbol hijoDerecho;
    
    public NodoArbol(int valor) {
        this.dato = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    // ----------------------------------------
    // MÉTODOS GETTERS Y SETTERS (Encapsulamiento)
    // ----------------------------------------
    // Getter para obtener el dato
    public int getDato() {
        return dato;
    }
    // Setter para modificar el dato (Si fuera necesario)
    public void setDato(int nuevoDato) {
        this.dato = nuevoDato;
    }
}