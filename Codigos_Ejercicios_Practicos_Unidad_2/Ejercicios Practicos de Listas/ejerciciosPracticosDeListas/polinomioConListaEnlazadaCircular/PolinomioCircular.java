package ejerciciosPracticos.ejerciciosPracticosDeListas.polinomioConListaEnlazadaCircular;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un polinomio mediante una lista enlazada circular.
 * 
 * Cada nodo contiene un coeficiente y un exponente.
 * El último nodo apunta al primero, formando un ciclo continuo.
 * La referencia principal de acceso es el último nodo.
 */
public class PolinomioCircular {
    private TerminoCircular ultimo; // referencia al último nodo

    /**
     * Constructor: inicializa el polinomio vacío.
     */
    public PolinomioCircular() {
        this.ultimo = null;
    }

    /**
     * Agrega un término al polinomio.
     * Si la lista está vacía, el nuevo nodo se enlaza a sí mismo.
     * 
     * @param coeficiente valor numérico del término.
     * @param exponente potencia correspondiente.
     */
    public void agregarTermino(double coeficiente, int exponente) {
        TerminoCircular nuevo = new TerminoCircular(coeficiente, exponente);

        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.setSiguiente(ultimo); // el primero apunta a sí mismo
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente()); // apunta al primero
            ultimo.setSiguiente(nuevo); // el antiguo último apunta al nuevo
            ultimo = nuevo; // ahora este es el nuevo último
        }
    }

    /**
     * Muestra el polinomio en formato legible.
     * Recorre desde el primer nodo hasta volver a él.
     * 
     * @return Representación textual del polinomio.
     */
    public String mostrar() {
        if (ultimo == null) {
            return "Polinomio vacío";
        }

        StringBuilder sb = new StringBuilder();
        TerminoCircular actual = ultimo.getSiguiente(); // primer nodo
        do {
            double coef = actual.getCoeficiente();
            int exp = actual.getExponente();

            if (coef != 0) {
                if (sb.length() > 0 && coef > 0) sb.append(" + ");
                else if (coef < 0) sb.append(" - ");

                double valorAbs = Math.abs(coef);
                if (exp == 0) sb.append(valorAbs);
                else if (exp == 1) sb.append(valorAbs).append("x");
                else sb.append(valorAbs).append("x^").append(exp);
            }

            actual = actual.getSiguiente();
        } while (actual != ultimo.getSiguiente());

        return sb.toString();
    }

    /**
     * Recorre la lista circular una vuelta completa,
     * mostrando cada término con su posición.
     */
    public void recorrerCircular() {
        if (ultimo == null) {
            System.out.println("(Lista vacía)");
            return;
        }

        TerminoCircular actual = ultimo.getSiguiente(); // primer nodo
        int contador = 1;
        do {
            System.out.println("Término " + contador + ": "
                    + actual.getCoeficiente() + "x^" + actual.getExponente());
            actual = actual.getSiguiente();
            contador++;
        } while (actual != ultimo.getSiguiente());
    }
}