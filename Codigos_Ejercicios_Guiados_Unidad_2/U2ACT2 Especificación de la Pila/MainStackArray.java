package pila;

/**
 * @author Fernando Vega Negrete 1224100720.fvn@gmail.com
 * GTID141 1224100720
 */

public class MainStackArray {
    // Método principal del programa.
    public static void main(String[] args) {
        // Crear una pila de tipo String con capacidad para 5 elementos
        StackArray<String> nombres = new StackArray<>(5);
        
        // Agregar elementos a la pila
        nombres.push("Isaac");
        nombres.push("Susy");
        nombres.push("Alejandro");
        nombres.push("Tere");
        
        // Eliminar los dos últimos
        nombres.pop();
        System.out.println(nombres.pop());
        
        // Mostrar el elemento actual en la cima
        System.out.println(nombres.peak() + "\n");
        
        // Mostrar todos los elementos restantes
        System.out.println(nombres);
    }   
}