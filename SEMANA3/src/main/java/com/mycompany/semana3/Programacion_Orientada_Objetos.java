/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana3;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Programacion_Orientada_Objetos {
static class ClimaSemanal {
        private double[] temperaturas;
        private String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        //inicializa el arreglo de temperaturas
        public ClimaSemanal() {
            temperaturas = new double[dias.length]; 
        }

        //ingresar temperaturas
        public void ingresarTemperaturas() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese las temperaturas semanales:");
            for (int i = 0; i < dias.length; i++) {
                System.out.print(dias[i] + ": ");
                temperaturas[i] = sc.nextDouble(); // Si el usuario ingresa texto, fallará
            }
        }

        //calcular el promedio
        public double calcularPromedio() {
            double suma = 0;
            for (double temp : temperaturas) {
                suma += temp;
            }
            return suma / temperaturas.length;
        }

        
        public void mostrarResultados() {
            System.out.printf("Promedio semanal: %.2f°C%n", calcularPromedio());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== PROGRAMA DE CLIMA SEMANAL ===");
        ClimaSemanal clima = new ClimaSemanal();
        clima.ingresarTemperaturas();
        clima.mostrarResultados();
    }
}