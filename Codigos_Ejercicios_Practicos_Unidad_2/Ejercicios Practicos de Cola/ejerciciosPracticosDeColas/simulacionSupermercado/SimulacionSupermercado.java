package ejerciciosPracticos.ejerciciosPracticosDeColas.simulacionSupermercado;

import ejerciciosPracticos.ejerciciosPracticosDeColas.cola.Cola;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 2: Simulacion de supermercado con carritos y cajas
 * 
 * Descripcion:
 * - 25 carritos de compra disponibles
 * - 3 cajas de pago
 * - Clientes esperan si no hay carritos
 * - Se colocan en la caja con menos clientes
 * - Liberan el carrito al pagar
 */
public class SimulacionSupermercado {
    
    private Cola<Integer> carritosDisponibles;
    private Cola<Cliente> caja1;
    private Cola<Cliente> caja2;
    private Cola<Cliente> caja3;
    private Cola<Cliente> clientesEsperandoCarrito;
    
    /**
     * Constructor que inicializa el supermercado.
     */
    public SimulacionSupermercado() {
        // Inicializar 25 carritos disponibles
        carritosDisponibles = new Cola<>();
        for (int i = 1; i <= 25; i++) {
            carritosDisponibles.encolar(i);
        }
        
        // Inicializar las 3 cajas
        caja1 = new Cola<>();
        caja2 = new Cola<>();
        caja3 = new Cola<>();
        
        // Cola de clientes esperando carrito
        clientesEsperandoCarrito = new Cola<>();
    }
    
    /**
     * Cliente llega al supermercado.
     * 
     * @param cliente Cliente que llega.
     */
    public void clienteLlega(Cliente cliente) {
        System.out.println(cliente + " llega al supermercado");
        
        // Verificar si hay carritos disponibles
        if (!carritosDisponibles.estaVacia()) {
            Integer carrito = carritosDisponibles.desencolar();
            cliente.setTieneCarrito(true);
            cliente.setNumeroCarrito(carrito);
            System.out.println("  -> Toma el carrito #" + carrito);
            irACaja(cliente);
        } else {
            System.out.println("  -> No hay carritos, espera en la fila");
            clientesEsperandoCarrito.encolar(cliente);
        }
    }
    
    /**
     * Cliente va a la caja con menos clientes.
     * 
     * @param cliente Cliente que va a pagar.
     */
    private void irACaja(Cliente cliente) {
        // Buscar la caja con menos clientes
        Cola<Cliente> cajaElegida;
        int numeroCaja;
        
        if (caja1.getTamano() <= caja2.getTamano() && caja1.getTamano() <= caja3.getTamano()) {
            cajaElegida = caja1;
            numeroCaja = 1;
        } else if (caja2.getTamano() <= caja3.getTamano()) {
            cajaElegida = caja2;
            numeroCaja = 2;
        } else {
            cajaElegida = caja3;
            numeroCaja = 3;
        }
        
        cajaElegida.encolar(cliente);
        System.out.println("  -> Se coloca en Caja " + numeroCaja + " (tiene " + cajaElegida.getTamano() + " clientes)");
    }
    
    /**
     * Procesa el pago de un cliente en una caja.
     * 
     * @param numeroCaja Numero de caja (1, 2 o 3).
     */
    public void procesarPago(int numeroCaja) {
        Cola<Cliente> caja;
        
        switch (numeroCaja) {
            case 1: caja = caja1; break;
            case 2: caja = caja2; break;
            case 3: caja = caja3; break;
            default: return;
        }
        
        if (!caja.estaVacia()) {
            Cliente cliente = caja.desencolar();
            int carritoLiberado = cliente.getNumeroCarrito();
            System.out.println("Caja " + numeroCaja + ": " + cliente + " termina de pagar");
            
            // Liberar el carrito que tenia el cliente
            carritosDisponibles.encolar(carritoLiberado);
            System.out.println("  -> Carrito #" + carritoLiberado + " liberado");
            
            // Si hay clientes esperando, darle carrito al siguiente
            if (!clientesEsperandoCarrito.estaVacia()) {
                Cliente siguienteCliente = clientesEsperandoCarrito.desencolar();
                Integer carrito = carritosDisponibles.desencolar();
                siguienteCliente.setTieneCarrito(true);
                siguienteCliente.setNumeroCarrito(carrito);
                System.out.println("  -> " + siguienteCliente + " que esperaba, ahora toma carrito #" + carrito);
                irACaja(siguienteCliente);
            }
        }
    }
    
    /**
     * Muestra el estado actual del supermercado.
     */
    public void mostrarEstado() {
        System.out.println();
        System.out.println("Estado del Supermercado");
        System.out.println("Carritos disponibles: " + carritosDisponibles.getTamano());
        System.out.println("Clientes esperando carrito: " + clientesEsperandoCarrito.getTamano());
        System.out.println("Caja 1: " + caja1.getTamano() + " clientes");
        System.out.println("Caja 2: " + caja2.getTamano() + " clientes");
        System.out.println("Caja 3: " + caja3.getTamano() + " clientes");
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("Ejercicio 2: Simulacion de supermercado");
        System.out.println();
        
        SimulacionSupermercado super1 = new SimulacionSupermercado();
        
        // Simulacion: llegan 30 clientes
        System.out.println("Llegada de clientes");
        for (int i = 1; i <= 30; i++) {
            Cliente cliente = new Cliente(i);
            super1.clienteLlega(cliente);
        }
        
        super1.mostrarEstado();
        
        // Procesar algunos pagos
        System.out.println("Procesando pagos");
        super1.procesarPago(1);
        super1.procesarPago(2);
        super1.procesarPago(3);
        super1.procesarPago(1);
        super1.procesarPago(2);
        
        super1.mostrarEstado();
    }
}