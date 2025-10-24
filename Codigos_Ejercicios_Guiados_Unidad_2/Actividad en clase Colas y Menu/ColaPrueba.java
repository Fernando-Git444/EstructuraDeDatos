package colas;

/**
 * @author Fernando Vega Negrete 1224100720
 * 1224100720.fvn@gmail.com
 * 
 * Clase de prueba para comprobar el funcionamiento básico de la Cola
 */

public class ColaPrueba {

    public static void main(String[] args) {
        // Se crea una cola genérica de tipo String
        Cola tareas = new Cola<>();
        
        // Se insertan varios elementos (tareas)
        tareas.insertar("Preparar cafe");
        tareas.insertar("Revisar emails");
        tareas.insertar("Iniciar proyecto");
        
        // Se obtiene el tamaño de la cola
        tareas.getTamano();
        
        // Se consulta el elemento que está al frente
        tareas.frente();
        
        // Se elimina el primer elemento (frente)
        tareas.quitar();
        
        // Se elimina el segundo elemento
        tareas.quitar();
        
        // Se muestra el contenido final de la cola
        tareas.mostrar();        
    }
}