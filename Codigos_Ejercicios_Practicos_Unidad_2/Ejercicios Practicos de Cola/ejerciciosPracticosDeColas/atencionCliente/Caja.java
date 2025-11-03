package ejerciciosPracticos.ejerciciosPracticosDeColas.atencionCliente;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa una caja de atencion.
 */
public class Caja {
    private int numero;
    private Cliente clienteActual;
    private int tiempoRestante;

    /**
     * Constructor de la clase Caja.
     * 
     * @param numero Numero identificador de la caja.
     */
    public Caja(int numero) {
        this.numero = numero;
        this.clienteActual = null;
        this.tiempoRestante = 0;
    }

    /**
     * Verifica si la caja esta libre.
     * 
     * @return true si no esta atendiendo a nadie.
     */
    public boolean estaLibre() {
        return clienteActual == null;
    }

    /**
     * Atiende a un cliente con un tiempo determinado.
     * 
     * @param cliente Cliente a atender.
     * @param tiempoAtencion Tiempo que tomara atenderlo.
     */
    public void atenderCliente(Cliente cliente, int tiempoAtencion) {
        this.clienteActual = cliente;
        this.tiempoRestante = tiempoAtencion;
    }

    /**
     * Avanza un minuto en la atencion.
     * 
     * @return Cliente si termino de atender, null si sigue ocupado.
     */
    public Cliente avanzarMinuto() {
        if (clienteActual != null) {
            tiempoRestante--;
            if (tiempoRestante <= 0) {
                Cliente atendido = clienteActual;
                clienteActual = null;
                return atendido;
            }
        }
        return null;
    }

    /**
     * Obtiene el numero de la caja.
     * 
     * @return Numero de caja.
     */
    public int getNumero() {
        return numero;
    }
}