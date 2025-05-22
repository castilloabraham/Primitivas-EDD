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
 * Clase Nodo utilizada en la pila para almacenar los datos.
 * Cada nodo contiene un valor genérico y una referencia al siguiente nodo.
 * @param <T> Tipo de dato que almacenará el nodo.
 */
class Nodo<T> {
    T valor;
    Nodo<T> siguiente;

    /**
     * Constructor que inicializa un nodo con un valor dado.
     * @param valor El valor que almacenará el nodo.
     */
    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}