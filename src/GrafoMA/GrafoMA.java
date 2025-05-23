/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoMA;

/**
 *
 * @author adcd_
 */

/**
 * Clase que representa un grafo usando matriz de adyacencia.
 */
public class GrafoMA {
    private int[][] matrizAdy;
    private int numVertices;
    private int maxVertices;
    private boolean dirigido;

    /**
     * Constructor que inicializa un grafo vacío.
     * @param maxVertices Número máximo de vértices
     * @param dirigido true si es dirigido, false si no
     */
    public GrafoMA(int maxVertices, boolean dirigido) {
        this.maxVertices = maxVertices;
        this.dirigido = dirigido;
        this.numVertices = 0;
        this.matrizAdy = new int[maxVertices][maxVertices];
    }

    /**
     * Agrega n vértices al grafo.
     * @param n cantidad de vértices a agregar
     */
    public void insertarVertices(int n) {
        if (numVertices + n > maxVertices) {
            System.out.println("Error: se excede el número máximo de vértices.");
            return;
        }
        numVertices += n;
    }

    /**
     * Inserta una arista entre dos vértices.
     * @param i vértice origen
     * @param j vértice destino
     */
    public void insertarArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error: vértices no válidos.");
            return;
        }
        matrizAdy[i][j] = 1;
        if (!dirigido) {
            matrizAdy[j][i] = 1;
        }
    }

    /**
     * Elimina una arista entre dos vértices.
     * @param i vértice origen
     * @param j vértice destino
     */
    public void eliminarArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error: vértices no válidos.");
            return;
        }
        matrizAdy[i][j] = 0;
        if (!dirigido) {
            matrizAdy[j][i] = 0;
        }
    }

    /**
     * Verifica si existe una arista entre dos vértices.
     * @param i vértice origen
     * @param j vértice destino
     * @return true si existe la arista
     */
    public boolean existeArista(int i, int j) {
        return matrizAdy[i][j] != 0;
    }

    /**
     * Devuelve el grado de entrada de un vértice.
     * @param v vértice
     * @return grado de entrada
     */
    public int gradoEntrada(int v) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdy[i][v] != 0) grado++;
        }
        return grado;
    }

    /**
     * Devuelve el grado de salida de un vértice.
     * @param v vértice
     * @return grado de salida
     */
    public int gradoSalida(int v) {
        int grado = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdy[v][i] != 0) grado++;
        }
        return grado;
    }

    /**
     * Devuelve el número total de aristas del grafo.
     * @return número de aristas
     */
    public int tamano() {
        int total = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j] != 0) total++;
            }
        }
        return dirigido ? total : total / 2;
    }

    /**
     * Imprime la matriz de adyacencia del grafo.
     */
    public void imprimirMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdy[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Devuelve el número de vértices actuales.
     * @return número de vértices
     */
    public int obtenerNumVertices() {
        return numVertices;
    }
}
