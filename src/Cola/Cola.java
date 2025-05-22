/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cola;

/**
 *
 * @author adcd_
 */
/**
 * Clase Cola implementada mediante nodos enlazados.
 * Sigue el esquema FIFO (First In, First Out).
 * @param <T> Tipo de dato almacenado en la cola.
 */
public class Cola<T> {
    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int iN;

    /**
     * Constructor: Inicializa una cola vacía.
     */
    public Cola() {
        pFirst = null;
        pLast = null;
        iN = 0;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si está vacía, false en caso contrario.
     */
    public boolean esVacia() {
        return iN == 0;
    }

    /**
     * Inserta un elemento al final de la cola.
     * @param x Valor a insertar.
     */
    public void encolar(T x) {
        Nodo<T> nuevo = new Nodo<>(x);
        if (esVacia()) {
            pFirst = nuevo;
        } else {
            pLast.siguiente = nuevo;
        }
        pLast = nuevo;
        iN++;
    }

    /**
     * Elimina el primer elemento de la cola.
     * Lanza excepción si está vacía.
     */
    public void desencolar() {
        if (esVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        Nodo<T> temp = pFirst;
        pFirst = pFirst.siguiente;
        temp.siguiente = null;
        if (pFirst == null) {
            pLast = null;
        }
        iN--;
    }

    /**
     * Retorna el número de elementos en la cola.
     * @return Tamaño de la cola.
     */
    public int tamanio() {
        return iN;
    }

    /**
     * Retorna el elemento que está en el frente de la cola sin eliminarlo.
     * @return Valor del primer elemento.
     */
    public T leerCabeza() {
        if (esVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return pFirst.valor;
    }

    /**
     * Elimina todos los elementos de la cola.
     */
    public void limpiar() {
        while (!esVacia()) {
            desencolar();
        }
    }

    /**
     * Invierte el orden de los elementos en la cola de forma recursiva.
     */
    public void invertir() {
        if (!esVacia()) {
            T elem = leerCabeza();
            desencolar();
            invertir();
            encolar(elem);
        }
    }

    /**
     * Copia el contenido de otra cola sin alterar el orden original.
     * @param origen Cola de origen a copiar.
     */
    public void copiar(Cola<T> origen) {
        int n = origen.tamanio();
        for (int i = 0; i < n; i++) {
            T elem = origen.leerCabeza();
            origen.desencolar();
            this.encolar(elem);
            origen.encolar(elem);
        }
    }

    /**
     * Inserta un elemento al inicio de la cola.
     * @param info Elemento a insertar.
     */
    public void insertarAlInicio(T info) {
        int n = tamanio();
        encolar(info);
        for (int i = 0; i < n; i++) {
            T elem = leerCabeza();
            desencolar();
            encolar(elem);
        }
    }

    /**
     * Verifica si un dato está en la cola.
     * Mantiene el orden original.
     * @param dato Valor a buscar.
     * @return true si el valor está presente.
     */
    public boolean existe(T dato) {
        boolean resul = false;
        int n = tamanio();
        for (int i = 0; i < n; i++) {
            T elem = leerCabeza();
            desencolar();
            encolar(elem);
            if (elem.equals(dato)) {
                resul = true;
            }
        }
        return resul;
    }
}
