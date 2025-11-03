package ejerciciosPracticos.ejerciciosPracticosDeColas.atencionCliente;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un cliente en la simulacion.
 */
public class Cliente {
    private int id;
    private int tiempoLlegada;
    private int tiempoEspera;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param id Identificador del cliente.
     * @param tiempoLlegada Minuto en que llego el cliente.
     */
    public Cliente(int id, int tiempoLlegada) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEspera = 0;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el tiempo de llegada del cliente.
     * 
     * @return Tiempo de llegada en minutos.
     */
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    /**
     * Obtiene el tiempo de espera del cliente.
     * 
     * @return Tiempo de espera en minutos.
     */
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    /**
     * Establece el tiempo de espera del cliente.
     * 
     * @param tiempoEspera Tiempo de espera en minutos.
     */
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String toString() {
        return "Cliente " + id;
    }
}