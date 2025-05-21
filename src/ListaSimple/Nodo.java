/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Abraham Castillo
 */

/**
 * Representa un nodo en una lista vinculada.
 * Cada nodo contiene un valor y una referencia al siguiente nodo en la lista.
 */
public class Nodo {
    // Atributos
    private String value;  // Valor que almacena el nodo
    private Nodo pNext;    // Referencia al siguiente nodo en la lista

    /**
     * Constructor que crea un nodo con el valor dado.
     * Inicializa el nodo con el valor y establece la referencia al siguiente nodo como null.
     *
     * @param value El valor que se almacena en el nodo
     */
    public Nodo(String value) {
        this.value = value;
        this.pNext = null;
    }

    /**
     * @return El valor del nodo
     */
    public String getValue() {
        return value;
    }
    /**
     * @param value El valor que se desea establecer en el nodo
     */
    public void setValue(String value) {
        this.value = value;
    }
    /**
     * @return El siguiente nodo
     */
    public Nodo getpNext() {
        return pNext;
    }
    /**
     * @param pNext El nodo que debe ser el siguiente en la lista
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}