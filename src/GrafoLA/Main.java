/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GrafoLA;

/**
 *
 * @author adcd_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un grafo no dirigido con capacidad para 6 nodos
        GrafoLA grafo = new GrafoLA(6, false);

        // Insertar 6 vértices
        grafo.insertaVertice(6);

        // Insertar algunas aristas
        grafo.insertaArista(0, 1);
        grafo.insertaArista(0, 2);
        grafo.insertaArista(1, 3);
        grafo.insertaArista(1, 4);
        grafo.insertaArista(2, 5);

        // Imprimir el grafo
        System.out.println("\n== Grafo creado ==");
        grafo.imprimirGrafo();

        // Mostrar grado de entrada, salida e incidencia
        System.out.println("\nGrado de entrada de 1: " + grafo.gradoIn(1));
        System.out.println("Grado de salida de 1: " + grafo.gradoOut(1));
        System.out.println("Incidencia de 1: " + grafo.incidencia(1));

        // Verificar si es no dirigido
        System.out.println("\n¿Es no dirigido?: " + grafo.esNoDirigido());

        // Mostrar el tamaño del grafo (número de aristas)
        System.out.println("Tamaño del grafo (número de aristas): " + grafo.tamanno());

        // Recorridos DFS y BFS
        System.out.println("\n== Recorridos desde el vértice 0 ==");
        grafo.recorridoDFS(0);
        grafo.recorridoBFS(0);

        // Eliminar una arista y volver a imprimir
        grafo.eliminaArista(0, 1);
        System.out.println("\n== Grafo tras eliminar la arista (0,1) ==");
        grafo.imprimirGrafo();
    }
    
}
