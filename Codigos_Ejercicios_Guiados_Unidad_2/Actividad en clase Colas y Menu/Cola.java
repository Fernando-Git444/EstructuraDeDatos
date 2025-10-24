package colas;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase genérica que implementa una cola (FIFO: First In, First Out)
 */

public class Cola<T> {
    private Nodo<T> cabeza; // Primer nodo de la cola (frente)
    private Nodo<T> cola;   // Último nodo de la cola (final)
    private int tamano;     // Cantidad de elementos en la cola

    // Constructor: inicializa una cola vacía
    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }
    
    // Inserta un nuevo elemento al final de la cola
    public void insertar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        // Si la cola está vacía, el nuevo nodo es cabeza y cola
        if(colaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // Si no está vacía, enlaza al final y actualiza la cola
            this.cola.setSiguiente(nuevoNodo);
            this.cola = nuevoNodo;
        }
        
        tamano++; // Incrementa el tamaño de la cola
        System.out.println("-> Insertar: " + elemento);
    }
    
    // Elimina y devuelve el elemento que está al frente de la cola
    public T quitar() {
        if(colaVacia()) {
            System.out.println("Error: la cola está vacía.");
            return null;
        }
        // Guarda el dato del frente
        T datoQuitado = this.cabeza.getDato();
        
        // Avanza la cabeza al siguiente nodo
        this.cabeza = this.cabeza.getSiguiente();
        
        // Si la cabeza se vuelve nula, también la cola
        if(this.cabeza == null) {
            this.cola = null;
        }
        tamano--; // Reduce el tamaño
        return datoQuitado;
    }
    
    // Devuelve el elemento del frente sin eliminarlo
    public T frente() {
        if(colaVacia()) {
            System.out.println("Error: La cola está vacía");
        }
        return this.cabeza.getDato();
    }
    
    // Muestra el contenido completo de la cola
    public void mostrar() {
        if (colaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo<T> actual = cabeza;
        System.out.print("Contenido de la cola: ");
        while (actual != null) {
            System.out.print(actual.getDato() + " ,");
            actual = actual.getSiguiente();
        }
        System.out.println(); // Salto de línea final
    }
    
    // Devuelve el número de elementos en la cola
    public int getTamano() {
        return tamano;
    }
    
    // Verifica si la cola está vacía
    public boolean colaVacia() {
        return cabeza == null;
    }

    // Métodos setter y getter opcionales
    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }

    public void setTamaño(int tamaño) {
        this.tamano = tamaño;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }
}