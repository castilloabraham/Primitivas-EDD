/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ListaSimple;

/**
 *
 * @author Abraham Castillo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una lista
        Lista lista = new Lista();
        
        // Agregar nodos a la lista
        lista.AgregarNodo("A");
        lista.AgregarNodo("B");
        lista.AgregarNodo("C");
        lista.AgregarNodo("D");

        // Mostrar la lista
        System.out.println("Lista original:");
        lista.Recorrer(); // Debería imprimir: A B C D

        // Agregar un nodo después de un nodo específico
        lista.agregarNodoDespuesDe("B", "X"); // Lista: A B X C D
        System.out.println("\nLista después de agregar X después de B:");
        lista.Recorrer(); // Debería imprimir: A B X C D

        // Invertir la lista
        lista.reverse();
        System.out.println("\nLista invertida:");
        lista.Recorrer(); // Debería imprimir: D C X B A

        // Crear otra lista para comparar
        Lista otraLista = new Lista();
        otraLista.AgregarNodo("D");
        otraLista.AgregarNodo("C");
        otraLista.AgregarNodo("X");
        otraLista.AgregarNodo("B");
        otraLista.AgregarNodo("A");

        // Comparar las listas
        System.out.println("\nLas listas son iguales: " + lista.equals(otraLista)); // Debería ser true

        // Clonar la lista
        Lista listaClonada = lista.clone();
        System.out.println("\nLista clonada:");
        listaClonada.Recorrer(); // Debería imprimir: D C X B A

        // Eliminar un nodo específico
        lista.EliminarPorValor("X");
        System.out.println("\nLista después de eliminar X:");
        lista.Recorrer(); // Debería imprimir: D C B A

        // Eliminar el último nodo
        lista.EliminarUltimo();
        System.out.println("\nLista después de eliminar el último nodo:");
        lista.Recorrer(); // Debería imprimir: D C B

        // Eliminar el primer nodo
        lista.EliminarPrimero();
        System.out.println("\nLista después de eliminar el primer nodo:");
        lista.Recorrer(); // Debería imprimir: C B
    }
    
}
