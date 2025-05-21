/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ListaCircular;

/**
 *
 * @author adcd_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                ListaCircular lista = new ListaCircular();

        System.out.println("== Agregar nodos al final ==");
        lista.agregarNodo("A");
        lista.agregarNodo("B");
        lista.agregarNodo("C");
        lista.recorrer();

        System.out.println("\n== Agregar nodo al inicio ==");
        lista.agregarNodoInicio("X");
        lista.recorrer();

        System.out.println("\n== Agregar nodo después de 'B' ==");
        lista.agregarNodoDespuesDe("B", "Y");
        lista.recorrer();

        System.out.println("\n== Mostrar estado de la lista ==");
        lista.mostrar();

        System.out.println("\n== Contiene 'Y'? ==");
        System.out.println(lista.contains("Y"));

        System.out.println("\n== Obtener valor por índice 2 ==");
        System.out.println("Valor en índice 2: " + lista.get(2));

        System.out.println("\n== Eliminar por valor 'C' ==");
        lista.eliminarPorValor("C");
        lista.recorrer();

        System.out.println("\n== Eliminar primero ==");
        lista.eliminarPrimero();
        lista.recorrer();

        System.out.println("\n== Eliminar último ==");
        lista.eliminarUltimo();
        lista.recorrer();

        System.out.println("\n== Invertir lista ==");
        lista.reverse();
        lista.recorrer();

        System.out.println("\n== Clonar lista ==");
        ListaCircular clon = lista.clone();
        clon.recorrer();

        System.out.println("\n== Comparar listas ==");
        System.out.println("Son iguales: " + lista.equals(clon));

        System.out.println("\n== Crear sublista [A, Y] y contar ==");
        ListaCircular sublista = new ListaCircular();
        sublista.agregarNodo("A");
        sublista.agregarNodo("Y");
        System.out.println("Apariciones: " + lista.existeSublista(sublista));

        System.out.println("\n== Vaciar lista ==");
        lista.clear();
        lista.recorrer();
    }
    
}
