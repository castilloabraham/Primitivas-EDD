/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ListaDoble;

/**
 *
 * @author adcd_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        System.out.println("=== Agregar nodos al final ===");
        lista.AgregarNodo("A");
        lista.AgregarNodo("B");
        lista.AgregarNodo("C");
        lista.Recorrer();

        System.out.println("\n=== Agregar nodo al inicio ===");
        lista.AgregarNodoInicio("X");
        lista.Recorrer();

        System.out.println("\n=== Agregar nodo después de 'B' ===");
        lista.AgregarNodoDespuesDe("B", "Y");
        lista.Recorrer();

        System.out.println("\n=== Mostrar información de la lista ===");
        lista.Mostrar();

        System.out.println("\n=== Verificar si contiene 'Y' ===");
        System.out.println("Contiene 'Y': " + lista.contains("Y"));

        System.out.println("\n=== Obtener valor por índice (2) ===");
        System.out.println("Valor en índice 2: " + lista.get(2));

        System.out.println("\n=== Eliminar por valor 'C' ===");
        lista.EliminarPorValor("C");
        lista.Recorrer();

        System.out.println("\n=== Eliminar primero ===");
        lista.EliminarPrimero();
        lista.Recorrer();

        System.out.println("\n=== Eliminar último ===");
        lista.EliminarUltimo();
        lista.Recorrer();

        System.out.println("\n=== Invertir lista ===");
        lista.reverse();
        lista.Recorrer();

        System.out.println("\n=== Comparar con otra lista igual ===");
        ListaDoble otra = new ListaDoble();
        otra.AgregarNodo("A");
        otra.AgregarNodo("B");
        System.out.println("Son iguales: " + lista.equals(otra));

        System.out.println("\n=== Crear sublista y verificar cuántas veces aparece ===");
        ListaDoble sublista = new ListaDoble();
        sublista.AgregarNodo("A");
        sublista.AgregarNodo("B");

        // Repetimos "A" y "B" varias veces para comprobar
        lista.AgregarNodo("A");
        lista.AgregarNodo("B");
        lista.AgregarNodo("A");
        lista.AgregarNodo("B");
        lista.AgregarNodo("C");

        System.out.println("Lista principal:");
        lista.Recorrer();

        System.out.println("Sublista:");
        sublista.Recorrer();

        int veces = lista.ExisteSublista(sublista);
        System.out.println("La sublista aparece " + veces + " veces");

        System.out.println("\n=== Vaciar lista ===");
        lista.clear();
        lista.Recorrer();
    }
    
}
