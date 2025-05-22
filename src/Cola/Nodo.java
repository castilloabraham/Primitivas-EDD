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
 * Clase Nodo usada por la estructura de datos Cola.
 * Contiene un valor genérico y una referencia al siguiente nodo.
 * @param <T> Tipo de dato almacenado.
 */
class Nodo<T> {
    T valor;
    Nodo<T> siguiente;

    /**
     * Constructor que inicializa el nodo con un valor dado.
     * @param valor valor a almacenar
     */
    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}