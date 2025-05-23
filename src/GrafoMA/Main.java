/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GrafoMA;

/**
 *
 * @author adcd_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un grafo no dirigido con máximo 5 vértices
        GrafoMA grafo = new GrafoMA(5, false);

        // Insertar 5 vértices
        grafo.insertarVertices(5);

        // Insertar aristas
        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 2);
        grafo.insertarArista(1, 3);
        grafo.insertarArista(3, 4);
        grafo.insertarArista(2, 4);

        // Mostrar matriz de adyacencia
        System.out.println("== Matriz del grafo ==");
        grafo.imprimirMatriz();

        // Verificar existencia de arista
        System.out.println("\n¿Existe arista (0, 1)?: " + grafo.existeArista(0, 1));
        System.out.println("¿Existe arista (1, 2)?: " + grafo.existeArista(1, 2));

        // Mostrar grado de entrada y salida
        System.out.println("\nGrado de entrada del vértice 4: " + grafo.gradoEntrada(4));
        System.out.println("Grado de salida del vértice 4: " + grafo.gradoSalida(4));

        // Mostrar número total de aristas
        System.out.println("\nTamaño del grafo (número de aristas): " + grafo.tamano());

        // Eliminar una arista y volver a mostrar la matriz
        System.out.println("\n== Eliminar arista (3, 4) ==");
        grafo.eliminarArista(3, 4);
        grafo.imprimirMatriz();
    }
    
}
