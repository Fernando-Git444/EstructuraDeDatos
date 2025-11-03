/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosPracticos.ejerciciosPracticosDeColas.atencionCliente;

import ejerciciosPracticos.ejerciciosPracticosDeColas.cola.Cola;
import java.util.Random;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

/**
 * Ejercicio 3: Simulacion de atencion al cliente en supermercado
 * 
 * Descripcion:
 * - Simulacion de 7 horas (420 minutos)
 * - 3 cajas activas inicialmente
 * - Se abre 4ta caja si hay mas de 20 clientes en fila
 * - Clientes llegan aleatoriamente
 * - Tiempo de atencion aleatorio entre 3 y 8 minutos
 */
public class SimulacionAtencionCliente {
    
    public static void main(String[] args) {
        System.out.println("Ejercicio 3: Simulacion de atencion al cliente");
        System.out.println();
        
        SimulacionAtencionCliente simulacion = new SimulacionAtencionCliente();
        simulacion.simular();
    }
    
    private Cola<Cliente> filaClientes;
    private Caja[] cajas;
    private Random random;
    
    // Estadisticas
    private int totalClientesAtendidos;
    private int tamanoMaximoFila;
    private int sumaTamanosFila;
    private int tiempoMaximoEspera;
    private int minutoCuartaCaja;
    private boolean cuartaCajaAbierta;
    
    private int contadorClientes;
    private int minutoActual;
    
    /**
     * Constructor de la simulacion.
     */
    public SimulacionAtencionCliente() {
        filaClientes = new Cola<>();
        cajas = new Caja[4];
        
        // Inicializar 3 cajas (indices 0, 1, 2)
        for (int i = 0; i < 3; i++) {
            cajas[i] = new Caja(i + 1);
        }
        // La cuarta caja no existe inicialmente
        cajas[3] = null;
        
        random = new Random();
        
        // Inicializar estadisticas
        totalClientesAtendidos = 0;
        tamanoMaximoFila = 0;
        sumaTamanosFila = 0;
        tiempoMaximoEspera = 0;
        minutoCuartaCaja = -1;
        cuartaCajaAbierta = false;
        contadorClientes = 0;
        minutoActual = 0;
    }
    
    /**
     * Ejecuta la simulacion completa de 7 horas.
     */
    public void simular() {
        System.out.println("Iniciando simulacion de 7 horas (420 minutos)");
        System.out.println();
        
        // Simular 420 minutos (7 horas)
        for (minutoActual = 1; minutoActual <= 420; minutoActual++) {
            
            // Llega un cliente con cierta probabilidad
            if (random.nextDouble() < 0.7) { // 70% de probabilidad cada minuto
                contadorClientes++;
                Cliente nuevoCliente = new Cliente(contadorClientes, minutoActual);
                filaClientes.encolar(nuevoCliente);
            }
            
            // Verificar si se debe abrir la cuarta caja
            if (!cuartaCajaAbierta && filaClientes.getTamano() > 20) {
                abrirCuartaCaja();
            }
            
            // Procesar cajas: atender clientes o terminar atencion
            procesarCajas();
            
            // Actualizar estadisticas
            actualizarEstadisticas();
        }
        
        mostrarEstadisticas();
    }
    
    /**
     * Abre la cuarta caja cuando hay mas de 20 clientes.
     */
    private void abrirCuartaCaja() {
        cajas[3] = new Caja(4);
        cuartaCajaAbierta = true;
        minutoCuartaCaja = minutoActual;
        System.out.println("Minuto " + minutoActual + ": Se abre la CAJA 4 (hay " + filaClientes.getTamano() + " clientes en fila)");
    }
    
    /**
     * Procesa todas las cajas activas.
     */
    private void procesarCajas() {
        for (int i = 0; i < 4; i++) {
            if (cajas[i] != null) {
                // Avanzar un minuto en la caja
                Cliente clienteAtendido = cajas[i].avanzarMinuto();
                
                if (clienteAtendido != null) {
                    // Termino de atender a un cliente
                    totalClientesAtendidos++;
                }
                
                // Si la caja esta libre, atender al siguiente de la fila
                if (cajas[i].estaLibre() && !filaClientes.estaVacia()) {
                    Cliente siguiente = filaClientes.desencolar();
                    
                    // Calcular tiempo de espera
                    int tiempoEspera = minutoActual - siguiente.getTiempoLlegada();
                    siguiente.setTiempoEspera(tiempoEspera);
                    
                    if (tiempoEspera > tiempoMaximoEspera) {
                        tiempoMaximoEspera = tiempoEspera;
                    }
                    
                    // Tiempo de atencion aleatorio entre 3 y 8 minutos
                    int tiempoAtencion = 3 + random.nextInt(6);
                    cajas[i].atenderCliente(siguiente, tiempoAtencion);
                }
            }
        }
    }
    
    /**
     * Actualiza las estadisticas cada minuto.
     */
    private void actualizarEstadisticas() {
        int tamanoActual = filaClientes.getTamano();
        
        sumaTamanosFila += tamanoActual;
        
        if (tamanoActual > tamanoMaximoFila) {
            tamanoMaximoFila = tamanoActual;
        }
    }
    
    /**
     * Muestra las estadisticas finales de la simulacion.
     */
    private void mostrarEstadisticas() {
        System.out.println();
        System.out.println("ESTADISTICAS FINALES");
        System.out.println();
        System.out.println("Total de clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Tamano maximo de la fila: " + tamanoMaximoFila + " clientes");
        
        double tamanoMedio = (double) sumaTamanosFila / 420;
        System.out.println("Tamano medio de la fila: " + String.format("%.2f", tamanoMedio) + " clientes");
        
        System.out.println("Tiempo maximo de espera: " + tiempoMaximoEspera + " minutos");
        
        if (cuartaCajaAbierta) {
            System.out.println("La cuarta caja se abrio en el minuto: " + minutoCuartaCaja);
        } else {
            System.out.println("La cuarta caja NO fue necesaria durante la simulacion");
        }
        
        System.out.println();
        System.out.println("Clientes que quedaron en fila: " + filaClientes.getTamano());
    }
}