/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoLA;

/**
 *
 * @author adcd_
 */

/**
 * Clase que representa un grafo utilizando una lista de adyacencias.
 */
public class GrafoLA {
    private boolean dirigido;
    private int maxNodos;
    private int numVertices;
    private Lista[] listaAdy;

    public GrafoLA(int n, boolean d) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.listaAdy = new Lista[n];
    }

    public void insertaVertice(int n) {
        if (n > maxNodos - numVertices) {
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        } else {
            for (int i = numVertices; i < numVertices + n; i++) {
                listaAdy[i] = new Lista();
            }
            numVertices += n;
        }
    }

    public void insertaArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error, vértice no válido");
            return;
        }
        listaAdy[i].insertar(j);
        if (!dirigido) listaAdy[j].insertar(i);
    }

    public void eliminaArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error, vértice no válido");
            return;
        }
        listaAdy[i].eliminar(j);
        if (!dirigido) listaAdy[j].eliminar(i);
    }

    public int gradoIn(int v) {
        int gIn = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i != v && listaAdy[i].busqueda(v)) gIn++;
        }
        return gIn;
    }

    public int gradoOut(int i) {
        int gOut = 0;
        NodoLista aux = listaAdy[i].inicio;
        while (aux != null) {
            gOut++;
            aux = aux.sig;
        }
        return gOut;
    }

    public int incidencia(int i) {
        return dirigido ? gradoIn(i) + gradoOut(i) : gradoIn(i);
    }

    public int tamanno() {
        int tm = 0;
        for (int i = 0; i < numVertices; i++) {
            tm += numElementos(listaAdy[i]);
        }
        return dirigido ? tm : tm / 2;
    }

    private static int numElementos(Lista lista) {
        int resul = 0;
        NodoLista aux = lista.obtenerInicio();
        while (aux != null) {
            resul++;
            aux = aux.sig;
        }
        return resul;
    }

    public boolean esNoDirigido() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (listaAdy[i].busqueda(j) != listaAdy[j].busqueda(i)) return false;
            }
        }
        return true;
    }

    public void imprimirGrafo() {
        System.out.println("Tamaño máximo del grafo: " + maxNodos);
        System.out.println("El grafo contiene " + numVertices + " vértices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            escribir(listaAdy[i]);
        }
    }

    private static void escribir(Lista lista) {
        NodoLista aux = lista.obtenerInicio();
        while (aux != null) {
            System.out.print(aux.clave + " ");
            aux = aux.sig;
        }
        System.out.println("FIN");
    }

    public int obtenerNumVertices() {
        return numVertices;
    }

    public boolean existeArista(int i, int j) {
        return listaAdy[i].busqueda(j);
    }

    public void recorridoDFS(int inicio) {
        boolean[] visitado = new boolean[numVertices];
        System.out.print("DFS desde vértice " + inicio + ": ");
        dfsRecursivo(inicio, visitado);
        System.out.println();
    }

    private void dfsRecursivo(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(v + " ");
        NodoLista actual = listaAdy[v].obtenerInicio();
        while (actual != null) {
            if (!visitado[actual.clave]) {
                dfsRecursivo(actual.clave, visitado);
            }
            actual = actual.sig;
        }
    }

    public void recorridoBFS(int inicio) {
        boolean[] visitado = new boolean[numVertices];
        java.util.Queue<Integer> cola = new java.util.LinkedList<>();
        visitado[inicio] = true;
        cola.add(inicio);
        System.out.print("BFS desde vértice " + inicio + ": ");
        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(v + " ");
            NodoLista actual = listaAdy[v].obtenerInicio();
            while (actual != null) {
                if (!visitado[actual.clave]) {
                    visitado[actual.clave] = true;
                    cola.add(actual.clave);
                }
                actual = actual.sig;
            }
        }
        System.out.println();
    }
}
