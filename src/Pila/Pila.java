/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pila;

/**
 *
 * @author adcd_
 */

/**
 * Clase Pila que implementa una pila utilizando nodos enlazados.
 * Incluye operaciones comunes como apilar, desapilar, obtener la cima, etc.
 * @param <T> Tipo de dato que almacena la pila.
 */
public class Pila<T> {
    private Nodo<T> cima;
    private int tamanio;

    /**
     * Constructor: crea una pila vacía.
     */
    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila no contiene elementos, false en caso contrario.
     */
    public boolean esVacia() {
        return tamanio == 0;
    }

    /**
     * Agrega un nuevo elemento al tope de la pila.
     * @param valor El valor a apilar.
     */
    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    /**
     * Elimina el elemento en la cima de la pila.
     * Lanza una excepcion si la pila esta vacia.
     * @throws IllegalStateException si la pila esta vacia.
     */
    public void desapilar() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        Nodo<T> temp = cima;
        cima = cima.siguiente;
        temp.siguiente = null;
        tamanio--;
    }

    /**
     * Retorna el valor del elemento en la cima de la pila sin eliminarlo.
     * @return El valor en la cima.
     * @throws IllegalStateException si la pila esta vacia.
     */
    public T cima() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return cima.valor;
    }

    /**
     * Retorna el numero de elementos en la pila.
     * @return El tamaño de la pila.
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Elimina todos los elementos de la pila.
     */
    public void limpiar() {
        while (!esVacia()) {
            desapilar();
        }
    }
}

