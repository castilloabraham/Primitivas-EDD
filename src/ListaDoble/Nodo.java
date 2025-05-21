/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDoble;

/**
 *
 * @author Abraham Castillo
 */

/**
 * Representa un nodo en una lista doblemente enlazada.
 * Cada nodo contiene un valor, una referencia al siguiente nodo y una referencia al nodo anterior.
 */
public class Nodo {
    private String value;  // Valor almacenado en el nodo
    private Nodo pNext;    // Referencia al siguiente nodo en la lista
    private Nodo pPrev;    // Referencia al nodo anterior en la lista

    /**
     * Constructor que crea un nodo con el valor dado.
     * Inicializa las referencias al siguiente y anterior nodo como null.
     *
     * @param value El valor que se almacena en el nodo
     */
    public Nodo(String value) {
        this.value = value;
        this.pNext = null;
        this.pPrev = null;
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

    /**
     * @return El nodo anterior
     */
    public Nodo getpPrev() {
        return pPrev;
    }

    /**
     * @param pPrev El nodo que debe ser el anterior en la lista
     */
    public void setpPrev(Nodo pPrev) {
        this.pPrev = pPrev;
    }
}
