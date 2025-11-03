package ejerciciosPracticos.ejerciciosPracticosDeListas.polinomioConListaEnlazadaCircular;


/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un término de un polinomio circular.
 * Cada término contiene un coeficiente, un exponente y una referencia
 * al siguiente término (lo que forma la lista circular).
 * 
 * Ejemplo: En 3x², el coeficiente es 3 y el exponente es 2.
 * 
 * @author Fernando Vega
 */
public class TerminoCircular {
    private double coeficiente;
    private int exponente;
    private TerminoCircular siguiente;

    /**
     * Constructor que inicializa un término con coeficiente y exponente.
     * @param coeficiente Coeficiente del polinomio
     * @param exponente Exponente del polinomio
     */
    public TerminoCircular(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }

    // Métodos de acceso getters y setters
    
    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public TerminoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TerminoCircular siguiente) {
        this.siguiente = siguiente;
    }
}