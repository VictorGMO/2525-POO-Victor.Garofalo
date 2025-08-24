/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_10;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author victo
 */
public class SEMANA_10 {

    public static void main(String[] args) throws IOException {
        Scanner es= new Scanner(System.in);
        GestionInventario gestor = new GestionInventario("inventario.txt");
        Validar validador = new Validar();
        int opcion;

        //ciclo para volver a tener el menu de opciones
        do {
            System.out.println("==== Menu de Inventario ====");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Agregar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Borrar todo");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = es.nextInt(); //elige 
            es.nextLine(); 

            switch (opcion) {
                case 1:
                    try {
                        validador.verificarNoVacio("inventario.txt");
                        gestor.mostrarInventario();
                    } catch (Exception exp) {
                        System.out.println(exp.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("escriba producto a agregar: ");
                    String producto = es.nextLine();
                    gestor.agregar(producto);
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("escriba el producto a eliminar: ");
                    String prodEliminar = es.nextLine();
                    gestor.eliminar(prodEliminar);
                    break;
                case 4:
                    gestor.borrarTodo();
                    break;
                case 5:
                    System.out.println("-Saliendo-");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
    }
}
