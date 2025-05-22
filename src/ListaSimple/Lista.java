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
 * Clase que representa una lista enlazada simple.
 * Cada elemento de la lista es un nodo (Nodo) que contiene un valor y una referencia al siguiente nodo.
 */
public class Lista {
    private Nodo pFirst;  // Primer nodo de la lista
    private Nodo pLast;   // Último nodo de la lista
    private int size;     // Tamaño de la lista
    
    /**
     * Constructor por defecto. Inicializa una lista vacía.
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /** @return el primer nodo de la lista */
    public Nodo getpFirst() {
        return pFirst;
    }

    /** @param pFirst nodo a establecer como primer nodo de la lista */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /** @return el último nodo de la lista */
    public Nodo getpLast() {
        return pLast;
    }

    /** @param pLast nodo a establecer como último nodo de la lista */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /** @return el tamaño de la lista */
    public int getSize() {
        return size;
    }

    /** @param size tamaño a establecer para la lista */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return pFirst == null;
    }
    
    
    /**
     * Agrega un nuevo nodo con el valor especificado al final de la lista.
     * @param value el valor a almacenar en el nuevo nodo
     */
    public void AgregarNodo(String value) {
        Nodo NuevoNodo = new Nodo(value);

        if (this.isEmpty()) {
            this.pFirst = NuevoNodo;
            this.pLast = NuevoNodo;
        } else {
            this.pLast.setpNext(NuevoNodo);
            this.pLast = NuevoNodo;
        }

        this.size += 1;
    }
    
    /**
     * Agrega un nuevo nodo con el valor especificado al inicio de la lista.
     * @param value el valor a almacenar en el nuevo nodo
     */
    public void AgregarNodoInicio(String value) {
        Nodo NuevoNodo = new Nodo(value);

        if (this.isEmpty()) {
            this.pFirst = NuevoNodo;
            this.pLast = NuevoNodo;
        } else {
            Nodo siguiente = this.pFirst;
            this.pFirst = NuevoNodo;
            this.pFirst.setpNext(siguiente);
        }

        this.size += 1;
    }
    
    /**
    * Agrega un nuevo nodo después del nodo que contiene el valor especificado.
    *
    * @param valorReferencia El valor del nodo después del cual se desea insertar.
    * @param nuevoValor El valor que se desea insertar en el nuevo nodo.
    */
    
    public void agregarNodoDespuesDe(String valorReferencia, String nuevoValor) {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo aux = pFirst;
        while (aux != null) {
            if (aux.getValue().equals(valorReferencia)) {
                Nodo nuevoNodo = new Nodo(nuevoValor);
                nuevoNodo.setpNext(aux.getpNext());
                aux.setpNext(nuevoNodo);

                // Actualizar pLast si se insertó al final
                if (aux == pLast) {
                    pLast = nuevoNodo;
                }

                this.size += 1;
                return;
            }
            aux = aux.getpNext();
        }

        System.out.println("El valor de referencia no se encontró en la lista.");
    }
    
    /**
     * Elimina el último nodo de la lista.
     */
    public void EliminarUltimo() {
        if (this.isEmpty()) {
            System.out.println("Esta lista esta vacia");
        } else {
            Nodo aux = pFirst;
            Nodo anterior = pFirst;

            while (aux != null) {
                if (aux.getpNext() == null) {
                    anterior.setpNext(null);
                    this.pLast = anterior;
                    this.size--;
                    break;
                }
                anterior = aux;
                aux = aux.getpNext();
            }
        }
    }
 
    /**
     * Elimina el primer nodo que contiene el valor especificado.
     * @param value el valor del nodo a eliminar
     */
    public void EliminarPorValor(String value) {
        if (this.isEmpty()) {
            System.out.println("Esta lista no se puede recorrer porque esta vacia");
        } else {
            Nodo aux = pFirst;
            Nodo anterior = null;

            while (aux != null) {
                if (aux.getValue().equals(value)) {
                    if (anterior == null) {
                        pFirst = aux.getpNext();
                    } else {
                        anterior.setpNext(aux.getpNext());
                    }

                    if (aux == pLast) {
                        pLast = anterior;
                    }

                    aux.setpNext(null);
                    this.size--;
                    break;
                }

                anterior = aux;
                aux = aux.getpNext();
            }
        }
    }
    
    /**
     * Elimina el primer nodo de la lista.
     */
    public void EliminarPrimero() {
        if (this.isEmpty()) {
            System.out.println("Esta lista no se puede recorrer porque esta vacia");
        } else {
            Nodo aux = pFirst;
            pFirst = pFirst.getpNext();
            aux.setpNext(null);
            this.size--;
        }
    }
    
    /**
    * Elimina todos los nodos de la lista, dejándola vacía.
    */
    public void clear() {
        pFirst = null;
        pLast = null;
        size = 0;
    }
    
    
    /**
     * Muestra por consola los valores básicos de la lista:
     * primer nodo, último nodo y tamaño.
     */
    public void Mostrar() {
        System.out.println("pFirst: " + pFirst);
        System.out.println("pLast: " + pLast);
        System.out.println("size: " + size);
    }
    
    /**
     * Recorre la lista y muestra por consola los valores de cada nodo.
     */
    public void Recorrer() {
        if (this.isEmpty()) {
            System.out.println("Esta lista esta vacia");
        } else {
            Nodo aux = pFirst;
            while (aux != null) {
                System.out.println(aux.getValue());
                aux = aux.getpNext();
            }
        }
    }    
    
    /**
    * Retorna el valor del nodo en la posición especificada.
    * @param index índice del nodo (0-based)
    * @return el valor del nodo
    * @throws IndexOutOfBoundsException si el índice es inválido
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
    * @param value el valor a buscar
    * @return true si el valor existe, false en caso contrario
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
     * Verifica cuántas veces aparece una sublista L1 en la lista actual.
     * @param L1 la sublista a buscar dentro de la lista actual
     * @return el número de veces que aparece L1 como sublista consecutiva
     */
    public int ExisteSublista(Lista L1) {
        if (L1 == null || this.isEmpty() || L1.getSize() > this.getSize()) {
            return 0;
        }

        int count = 0;
        Nodo current = this.getpFirst();

        while (current != null) {
            Nodo tempL1 = L1.getpFirst();
            Nodo tempL2 = current;

            while (tempL1 != null && tempL2 != null && tempL1.getValue().equals(tempL2.getValue())) {
                tempL1 = tempL1.getpNext();
                tempL2 = tempL2.getpNext();
            }

            if (tempL1 == null) {
                count++;
            }

            current = current.getpNext();
        }

        return count;
    }
    
    /**
    * Invierte el orden de los nodos en la lista.
    */
    public void reverse() {
        if (isEmpty() || pFirst.getpNext() == null) {
            return; // Lista vacía o con un solo elemento, no hace falta invertir
        }

        Nodo anterior = null;
        Nodo actual = pFirst;
        Nodo siguiente;

        pLast = pFirst; // El antiguo primero será el nuevo último

        while (actual != null) {
            siguiente = actual.getpNext();
            actual.setpNext(anterior);
            anterior = actual;
            actual = siguiente;
        }

        pFirst = anterior;
    }

    /**
    * Compara esta lista con otra lista para verificar si son iguales.
    * Dos listas son iguales si tienen los mismos valores en el mismo orden.
    *
    * @param otra la otra lista con la que se desea comparar
    * @return true si las listas son iguales, false en caso contrario
    */
    public boolean equals(Lista otra) {
        if (otra == null || this.getSize() != otra.getSize()) {
            return false;
        }

        Nodo nodo1 = this.pFirst;
        Nodo nodo2 = otra.getpFirst();

        while (nodo1 != null && nodo2 != null) {
            if (!nodo1.getValue().equals(nodo2.getValue())) {
                return false;
            }
            nodo1 = nodo1.getpNext();
            nodo2 = nodo2.getpNext();
        }

        return true;
    }
    
    /**
    * Crea y retorna una copia exacta de la lista actual.
    *
    * @return una nueva lista con los mismos valores y en el mismo orden
    */
    public Lista clone() {
        Lista copia = new Lista();

        Nodo aux = this.pFirst;
        while (aux != null) {
            copia.AgregarNodo(aux.getValue());
            aux = aux.getpNext();
        }

        return copia;
    }
    
    
    /**
    * Convierte la lista simple en circular, haciendo que el último nodo apunte al primero.
    */
   public void hacerCircular() {
       if (!isEmpty() && pLast.getpNext() == null) {
           pLast.setpNext(pFirst);
       }
   }

   /**
    * Convierte la lista circular en simple, eliminando el enlace del último nodo al primero.
    */
   public void hacerLineal() {
       if (!isEmpty() && pLast.getpNext() == pFirst) {
           pLast.setpNext(null);
       }
   }
}
