package ejerciciosPracticos.ejerciciosPracticosDeColas.simulacionSupermercado;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Clase que representa un cliente en el supermercado.
 */
public class Cliente {
    private int id;
    private boolean tieneCarrito;
    private int numeroCarrito;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param id Identificador del cliente.
     */
    public Cliente(int id) {
        this.id = id;
        this.tieneCarrito = false;
        this.numeroCarrito = -1;
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
     * Verifica si el cliente tiene carrito.
     * 
     * @return true si tiene carrito.
     */
    public boolean isTieneCarrito() {
        return tieneCarrito;
    }

    /**
     * Establece si el cliente tiene carrito.
     * 
     * @param tieneCarrito Estado del carrito.
     */
    public void setTieneCarrito(boolean tieneCarrito) {
        this.tieneCarrito = tieneCarrito;
    }

    /**
     * Obtiene el numero de carrito que tiene el cliente.
     * 
     * @return Numero de carrito.
     */
    public int getNumeroCarrito() {
        return numeroCarrito;
    }

    /**
     * Establece el numero de carrito del cliente.
     * 
     * @param numeroCarrito Numero de carrito.
     */
    public void setNumeroCarrito(int numeroCarrito) {
        this.numeroCarrito = numeroCarrito;
    }

    @Override
    public String toString() {
        return "Cliente " + id;
    }
}