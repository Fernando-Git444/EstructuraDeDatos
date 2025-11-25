package mx.edu.utng.tics.arboles;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase principal que realiza la implementación y prueba del arbol binario.
 */
public class PruebaArbol {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase gestora del árbol
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("Insertando valores:   50, 30, 70, 30, 50, 20, 70 ");
        // 2. Insertar valores usando el método público
        arbol.insertar(50); // Raíz
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(30);
        arbol.insertar(50);
        arbol.insertar(20);
        arbol.insertar(70);

        
        // 3. Ejecutar el recorrido para verificar el orden
        // Resultado esperado (ordenado): 10, 20, 30, 40, 50.
        arbol.recorrerInorden();
    }
}