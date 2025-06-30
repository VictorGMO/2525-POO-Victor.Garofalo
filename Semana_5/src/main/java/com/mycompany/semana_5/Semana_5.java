/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_5;

import java.util.Scanner;

/**
 *
 * @author victo
 */
//programa que calculara el area de un rectángulo usando base y altura dadas por el usuario

public class Semana_5 {

    public static void main(String[] args) {
         
        Scanner entrada = new Scanner(System.in);

        //declaro variables 
        float base, altura, areaCalculada;
        float area_calculada;
        boolean datos_validos = true;
        System.out.print(" ");
        //pedira al usuario que ingrese la base
        System.out.print("Ingresa la base del rectangulo(en cm): ");
        base = entrada.nextFloat();

        //pedira la altura
        System.out.print("Ingresa la altura del rectangulo(en cm): ");
        altura = entrada.nextFloat();

        //validara que los datos no sean negativos
        if (base <= 0 || altura <= 0) {
            System.out.println("Los valores deben ser mayores a cero.");
            datos_validos = false;
        }

        //si los datos son válidos calculara el area
        if (datos_validos) {
            area_calculada = base * altura;
            System.out.println("El área del rectángulo es: " + area_calculada + " cm²");
        }
        
    }
}
