/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaCircular;

/**
 *
 * @author adcd_
 */
/**
 * Clase ListaCircular que implementa una lista circular simplemente enlazada
 * con operaciones comunes como inserción, eliminación, búsqueda, recorrido, comparación y clonación.
 */
class ListaCircular {
    private Nodo primero;
    private Nodo ultimo;
    private int size;

    public ListaCircular() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public void agregarNodo(String valor) {
        Nodo nuevo = new Nodo(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.setpNext(nuevo);
        } else {
            ultimo.setpNext(nuevo);
            nuevo.setpNext(primero);
            ultimo = nuevo;
        }
        size++;
    }

    public void agregarNodoInicio(String valor) {
        Nodo nuevo = new Nodo(valor);
        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.setpNext(nuevo);
        } else {
            nuevo.setpNext(primero);
            primero = nuevo;
            ultimo.setpNext(primero);
        }
        size++;
    }

    public void agregarNodoDespuesDe(String valorReferencia, String nuevoValor) {
        if (isEmpty()) return;
        Nodo actual = primero;
        do {
            if (actual.getValue().equals(valorReferencia)) {
                Nodo nuevo = new Nodo(nuevoValor);
                nuevo.setpNext(actual.getpNext());
                actual.setpNext(nuevo);
                if (actual == ultimo) {
                    ultimo = nuevo;
                }
                size++;
                return;
            }
            actual = actual.getpNext();
        } while (actual != primero);
    }

    public void eliminarPrimero() {
        if (isEmpty()) return;
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        } else {
            primero = primero.getpNext();
            ultimo.setpNext(primero);
        }
        size--;
    }

    public void eliminarUltimo() {
        if (isEmpty()) return;
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        } else {
            Nodo actual = primero;
            while (actual.getpNext() != ultimo) {
                actual = actual.getpNext();
            }
            actual.setpNext(primero);
            ultimo = actual;
        }
        size--;
    }

    public void eliminarPorValor(String valor) {
        if (isEmpty()) return;
        Nodo actual = primero;
        Nodo anterior = ultimo;
        do {
            if (actual.getValue().equals(valor)) {
                if (actual == primero) eliminarPrimero();
                else if (actual == ultimo) eliminarUltimo();
                else {
                    anterior.setpNext(actual.getpNext());
                    size--;
                }
                return;
            }
            anterior = actual;
            actual = actual.getpNext();
        } while (actual != primero);
    }

    public void clear() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public void mostrar() {
        System.out.println("Primero: " + (primero != null ? primero.getValue() : "null"));
        System.out.println("Último: " + (ultimo != null ? ultimo.getValue() : "null"));
        System.out.println("Tamaño: " + size);
    }

    public void recorrer() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = primero;
        do {
            System.out.println(actual.getValue());
            actual = actual.getpNext();
        } while (actual != primero);
    }

    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Nodo actual = primero;
        for (int i = 0; i < index; i++) actual = actual.getpNext();
        return actual.getValue();
    }

    public boolean contains(String valor) {
        if (isEmpty()) return false;
        Nodo actual = primero;
        do {
            if (actual.getValue().equals(valor)) return true;
            actual = actual.getpNext();
        } while (actual != primero);
        return false;
    }

    public int existeSublista(ListaCircular sublista) {
        if (sublista == null || sublista.size == 0 || sublista.size > this.size) return 0;
        int count = 0;
        Nodo actual = this.primero;
        for (int i = 0; i < this.size; i++) {
            Nodo tempMain = actual;
            Nodo tempSub = sublista.primero;
            boolean match = true;
            for (int j = 0; j < sublista.size; j++) {
                if (!tempMain.getValue().equals(tempSub.getValue())) {
                    match = false;
                    break;
                }
                tempMain = tempMain.getpNext();
                tempSub = tempSub.getpNext();
            }
            if (match) count++;
            actual = actual.getpNext();
        }
        return count;
    }

    public void reverse() {
        if (isEmpty() || primero == ultimo) return;
        Nodo anterior = ultimo;
        Nodo actual = primero;
        Nodo siguiente;
        do {
            siguiente = actual.getpNext();
            actual.setpNext(anterior);
            anterior = actual;
            actual = siguiente;
        } while (actual != primero);
        ultimo = primero;
        primero = anterior;
    }

    public boolean equals(ListaCircular otra) {
        if (this.size != otra.size) return false;
        Nodo a = this.primero;
        Nodo b = otra.primero;
        for (int i = 0; i < this.size; i++) {
            if (!a.getValue().equals(b.getValue())) return false;
            a = a.getpNext();
            b = b.getpNext();
        }
        return true;
    }

    public ListaCircular clone() {
        ListaCircular clon = new ListaCircular();
        if (!isEmpty()) {
            Nodo actual = this.primero;
            do {
                clon.agregarNodo(actual.getValue());
                actual = actual.getpNext();
            } while (actual != primero);
        }
        return clon;
    }
}

