/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.victor.proyecto;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Dashboard {
    private Servicio servicio;
    private Scanner scanner;

    public Dashboard() {
        servicio=new Servicio();
        scanner= new Scanner (System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            //listado
            System.out.println("\n=== SISTEMA DE NOTAS ===");
            System.out.println("1. Registrar materia y nota");
            System.out.println("2. Ver todas las notas");
            System.out.println("3. Ver promedio general");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarNota();
                case 2 -> verNotas();
                case 3 -> verPromedio();
                case 0 -> System.out.println("Hasta pronto");
                default -> System.out.println("Opción invalida.");
            }
        } while (opcion != 0);
    }
//registro materia y notas
    private void registrarNota() {
        System.out.print("Nombre de la materia: ");
        String materia = scanner.nextLine();
        System.out.print("Nota obtenida: ");
        double nota = scanner.nextDouble();
        servicio.agregarNota(materia, nota);
        System.out.println("Nota registrada con éxito.");
    }
//notas
    private void verNotas() {
        System.out.println("\n--- NOTAS REGISTRADAS ---");
        if (servicio.hayNotas()) {
            for (Modelo m : servicio.obtenerNotas()) {
                System.out.println(m);
            }
        } else {
            System.out.println("No hay notas registradas aún.");
        }
    }
//promedio
    private void verPromedio() {
        double promedio = servicio.calcularPromedio();
        System.out.println("Promedio general: " + promedio);
    }
}
