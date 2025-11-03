package ejerciciosPracticos.ejerciciosPracticosDeListas.representacionYEvaluaciónDePolinomiosConListasEnlazadas;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un término de un polinomio.
 * Cada término tiene un coeficiente y un exponente.
 * 
 * Ejemplo: en 3x², el coeficiente es 3 y el exponente es 2.
 * 
 */
public class Termino {
    private double coeficiente;
    private int exponente;
    private Termino siguiente;

    /**
     * Constructor que inicializa el término con coeficiente y exponente.
     * @param coeficiente Coeficiente del polinomio
     * @param exponente Exponente del polinomio
     */
    public Termino(double coeficiente, int exponente) {
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

    public Termino getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Termino siguiente) {
        this.siguiente = siguiente;
    }
}