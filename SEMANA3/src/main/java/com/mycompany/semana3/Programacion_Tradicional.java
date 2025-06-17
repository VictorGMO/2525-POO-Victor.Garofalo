/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana3;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class Programacion_Tradicional {

 //variables globales para almacenar temperaturas y resultados
    static double promedio;  
    static double suma;      
    static int lunes, martes, mier, juev, vier, sab, dom;  

    
     //Pide al usuario que ingrese valores para cada día.
     
    public static void temp() {
        Scanner dato = new Scanner(System.in);
        
        System.out.println("Temperatura Dia lunes");
        lunes = dato.nextInt();
        
        System.out.println("Temperatura Dia martes");
        martes = dato.nextInt();
        
        System.out.println("Temperatura Dia miercoles");
        mier = dato.nextInt();
        
        System.out.println("Temperatura Dia jueves");
        juev = dato.nextInt();
        
        System.out.println("Temperatura Dia viernes");
        vier = dato.nextInt();
        
        System.out.println("Temperatura Dia sabado");
        sab = dato.nextInt();
        
        System.out.println("Temperatura Dia domingo");
        dom = dato.nextInt();
    }

    
    //Función para calcular el promedio de temperaturas.
     
    public static double calcular() {
        return (double) (lunes + martes + mier + juev + vier + sab + dom) / 7;
    }

    
    public static void main(String[] args) {
        temp();
        
        //calcular promedio
        promedio = calcular();
        System.out.println("=== PROGRAMA DE CLIMA SEMANAL ===");
        //mostrar resultados con 2 decimales
        System.out.println("El clima promedio de la semana es: " + String.format("%.2f", promedio) + "°C");
    }
}