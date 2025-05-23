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
 * Nodo de una lista de adyacencia para grafos.
 */
class NodoLista {
    public int clave;
    public NodoLista sig;

    public NodoLista(int dato, NodoLista siguiente) {
        this.clave = dato;
        this.sig = siguiente;
    }
}