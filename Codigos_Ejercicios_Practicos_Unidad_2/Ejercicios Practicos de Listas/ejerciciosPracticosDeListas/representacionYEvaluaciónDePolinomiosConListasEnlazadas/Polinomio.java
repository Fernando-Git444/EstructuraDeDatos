package ejerciciosPracticos.ejerciciosPracticosDeListas.representacionYEvaluaciónDePolinomiosConListasEnlazadas;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un polinomio mediante una lista enlazada simple.
 * 
 * Cada nodo almacena un coeficiente y un exponente.
 * Permite agregar términos, mostrar el polinomio y evaluarlo para un valor dado de x.
 */
public class Polinomio {
    private Termino cabeza;

    /**
     * Constructor: inicializa un polinomio vacío.
     */
    public Polinomio() {
        this.cabeza = null;
    }

    /**
     * Agrega un término al final del polinomio.
     * 
     * @param coeficiente valor numérico del término.
     * @param exponente potencia correspondiente.
     */
    public void agregarTermino(double coeficiente, int exponente) {
        Termino nuevo = new Termino(coeficiente, exponente);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Termino actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    /**
     * Devuelve una representación legible del polinomio.
     * 
     * @return Cadena representando el polinomio.
     */
    public String mostrar() {
        if (cabeza == null) {
            return "Polinomio vacío";
        }

        StringBuilder sb = new StringBuilder();
        Termino actual = cabeza;
        while (actual != null) {
            double coeficiente = actual.getCoeficiente();
            int exponente = actual.getExponente();

            if (coeficiente != 0) {
                if (sb.length() > 0 && coeficiente > 0) {
                    sb.append(" + ");
                } else if (coeficiente < 0) {
                    sb.append(" - ");
                }

                double valorAbs = Math.abs(coeficiente);
                if (exponente == 0) sb.append(valorAbs);
                else if (exponente == 1) sb.append(valorAbs).append("x");
                else sb.append(valorAbs).append("x^").append(exponente);
            }

            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    /**
     * Evalúa el polinomio para un valor de x.
     * 
     * @param x valor para evaluar.
     * @return resultado numérico del polinomio.
     */
    public double evaluar(double x) {
        double resultado = 0;
        Termino actual = cabeza;

        while (actual != null) {
            resultado += actual.getCoeficiente() * Math.pow(x, actual.getExponente());
            actual = actual.getSiguiente();
        }
        return resultado;
    }
}