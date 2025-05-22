/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pila;

/**
 *
 * @author adcd_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una pila de tipo String
        Pila<String> pila = new Pila<>();

        System.out.println("== Apilar elementos ==");
        pila.apilar("A");
        pila.apilar("B");
        pila.apilar("C");
        System.out.println("Elemento en la cima: " + pila.cima());
        System.out.println("Tamaño de la pila: " + pila.tamanio());

        System.out.println("\n== Desapilar un elemento ==");
        pila.desapilar();
        System.out.println("Elemento en la cima: " + pila.cima());
        System.out.println("Tamaño de la pila: " + pila.tamanio());

        System.out.println("\n== Verificar si la pila contiene elementos ==");
        System.out.println("Pila vacía?: " + pila.esVacia());

        System.out.println("\n== Limpiar pila ==");
        pila.limpiar();
        System.out.println("Pila vacía?: " + pila.esVacia());

        System.out.println("\n== Probar excepciones ==");
        try {
            pila.cima();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
    
}
