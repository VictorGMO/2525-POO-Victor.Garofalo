
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.semana7;

/**
 *
 * @author victo
 */
public class Clase_main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante();
        //el constructor con parámetros completos
        Estudiante estudiante2 = new Estudiante("Ana López", 19, "Ingeniería en Sistemas");
        //el constructor de nomb y edad
        Estudiante estudiante3 = new Estudiante("Carlos Pérez", 20);

        System.out.println("Estudiante 1:");
        estudiante1.mostrarDatos();

        System.out.println("\nEstudiante 2:");
        estudiante2.mostrarDatos();

        System.out.println("\nEstudiante 3:");
        estudiante3.mostrarDatos();
    }
}
