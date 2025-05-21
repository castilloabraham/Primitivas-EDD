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
 * Representa una lista doblemente enlazada, donde cada nodo tiene referencias tanto al siguiente
 * como al anterior nodo. Esta lista permite operaciones como agregar, eliminar, recorrer, etc.
 */
public class ListaDoble {
    private Nodo pFirst;  // Primer nodo de la lista
    private Nodo pLast;   // Último nodo de la lista
    private int size;     // Tamaño de la lista

    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaDoble() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @return El primer nodo de la lista.
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst El nodo a establecer como primer nodo.
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return El último nodo de la lista.
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast El nodo a establecer como último nodo.
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size El tamaño de la lista a establecer.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return pFirst == null;
    }

    /**
     * Agrega un nodo al final de la lista.
     * 
     * @param value El valor que debe almacenar el nuevo nodo.
     */
    public void AgregarNodo(String value) {
        Nodo nuevoNodo = new Nodo(value);
        if (isEmpty()) {
            pFirst = nuevoNodo;
            pLast = nuevoNodo;
        } else {
            pLast.setpNext(nuevoNodo);
            nuevoNodo.setpPrev(pLast);
            pLast = nuevoNodo;
        }
        size++;
    }

    /**
     * Agrega un nodo al inicio de la lista.
     * 
     * @param value El valor que debe almacenar el nuevo nodo.
     */
    public void AgregarNodoInicio(String value) {
        Nodo nuevoNodo = new Nodo(value);
        if (isEmpty()) {
            pFirst = nuevoNodo;
            pLast = nuevoNodo;
        } else {
            nuevoNodo.setpNext(pFirst);
            pFirst.setpPrev(nuevoNodo);
            pFirst = nuevoNodo;
        }
        size++;
    }

    /**
     * Inserta un nodo después de un nodo con un valor específico.
     * 
     * @param valorReferencia El valor del nodo de referencia.
     * @param nuevoValor El valor del nuevo nodo.
     */
    public void AgregarNodoDespuesDe(String valorReferencia, String nuevoValor) {
        Nodo aux = pFirst;
        while (aux != null) {
            if (aux.getValue().equals(valorReferencia)) {
                Nodo nuevoNodo = new Nodo(nuevoValor);
                Nodo siguiente = aux.getpNext();
                aux.setpNext(nuevoNodo);
                nuevoNodo.setpPrev(aux);
                if (siguiente != null) {
                    siguiente.setpPrev(nuevoNodo);
                    nuevoNodo.setpNext(siguiente);
                } else {
                    pLast = nuevoNodo;
                }
                size++;
                return;
            }
            aux = aux.getpNext();
        }
    }

    /**
     * Elimina el último nodo de la lista.
     */
    public void EliminarUltimo() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            if (pFirst == pLast) {
                pFirst = null;
                pLast = null;
            } else {
                pLast = pLast.getpPrev();
                pLast.setpNext(null);
            }
            size--;
        }
    }

    /**
     * Elimina el primer nodo con un valor específico.
     * 
     * @param value El valor del nodo a eliminar.
     */
    public void EliminarPorValor(String value) {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo aux = pFirst;
            while (aux != null) {
                if (aux.getValue().equals(value)) {
                    if (aux == pFirst) {
                        EliminarPrimero();
                    } else if (aux == pLast) {
                        EliminarUltimo();
                    } else {
                        Nodo prev = aux.getpPrev();
                        Nodo next = aux.getpNext();
                        prev.setpNext(next);
                        if (next != null) {
                            next.setpPrev(prev);
                        }
                    }
                    size--;
                    break;
                }
                aux = aux.getpNext();
            }
        }
    }

    /**
     * Elimina el primer nodo de la lista.
     */
    public void EliminarPrimero() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            if (pFirst == pLast) {
                pFirst = null;
                pLast = null;
            } else {
                pFirst = pFirst.getpNext();
                pFirst.setpPrev(null);
            }
            size--;
        }
    }

    /**
     * Vacía la lista eliminando todos sus nodos.
     */
    public void clear() {
        pFirst = null;
        pLast = null;
        size = 0;
    }

    /**
     * Muestra el primer nodo, el último nodo y el tamaño de la lista.
     */
    public void Mostrar() {
        System.out.println("Primer Nodo: " + (pFirst != null ? pFirst.getValue() : "null"));
        System.out.println("Último Nodo: " + (pLast != null ? pLast.getValue() : "null"));
        System.out.println("Tamaño: " + size);
    }

    /**
     * Recorre e imprime todos los valores de los nodos de la lista.
     */
    public void Recorrer() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo aux = pFirst;
            while (aux != null) {
                System.out.println(aux.getValue());
                aux = aux.getpNext();
            }
        }
    }

    /**
     * Retorna el valor en la posición indicada por index.
     * 
     * @param index La posición del valor a obtener.
     * @return El valor en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice está fuera del rango de la lista.
     */
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        Nodo aux = pFirst;
        for (int i = 0; i < index; i++) {
            aux = aux.getpNext();
        }
        return aux.getValue();
    }

    /**
     * Verifica si un valor existe en la lista.
     * 
     * @param value El valor a verificar.
     * @return true si el valor está en la lista, false en caso contrario.
     */
    public boolean contains(String value) {
        Nodo aux = pFirst;
        while (aux != null) {
            if (aux.getValue().equals(value)) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }

    /**
     * Cuenta cuántas veces aparece una sublista en la lista principal.
     * 
     * @param L1 La sublista que se quiere buscar.
     * @return El número de veces que la sublista aparece.
     */
    public int ExisteSublista(ListaDoble L1) {
        int count = 0;
        Nodo aux = pFirst;
        while (aux != null) {
            Nodo tempAux = aux;
            Nodo tempL1 = L1.pFirst;
            while (tempAux != null && tempL1 != null && tempAux.getValue().equals(tempL1.getValue())) {
                tempAux = tempAux.getpNext();
                tempL1 = tempL1.getpNext();
            }

            if (tempL1 == null) {
                count++;
            }
            aux = aux.getpNext();
        }
        return count;
    }

    /**
     * Invierte el orden de los nodos en la lista.
     */
    public void reverse() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo actual = pFirst;
            Nodo temp = null;
            while (actual != null) {
                temp = actual.getpPrev();
                actual.setpPrev(actual.getpNext());
                actual.setpNext(temp);
                actual = actual.getpPrev();
            }
            if (temp != null) {
                pFirst = temp.getpPrev();
            }
        }
    }

    /**
     * Compara dos listas para verificar si son iguales.
     * 
     * @param otra La otra lista a comparar.
     * @return true si las listas son iguales, false en caso contrario.
     */
    public boolean equals(ListaDoble otra) {
        if (otra == null || this.size != otra.size) {
            return false;
        }

        Nodo actual1 = this.pFirst;
        Nodo actual2 = otra.pFirst;

        while (actual1 != null) {
            if (!actual1.getValue().equals(actual2.getValue())) {
                return false;
            }
            actual1 = actual1.getpNext();
            actual2 = actual2.getpNext();
        }
        return true;
    }

    /**
     * Crea una copia exacta de la lista.
     * 
     * @return Una nueva lista idéntica a la actual.
     */
    public ListaDoble clone() {
        ListaDoble nuevaLista = new ListaDoble();
        Nodo actual = this.pFirst;
        while (actual != null) {
            nuevaLista.AgregarNodo(actual.getValue());
            actual = actual.getpNext();
        }
        return nuevaLista;
    }
}


