/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.semana7;

/**
 *
 * @author victo
 */
public class Estudiante {
 private String nombre,carrera;
    private int edad;
   
    public Estudiante() {
        this.nombre = "no definido";
        this.edad = 0;
        this.carrera = "sin carrera";
    }
    //constructor con parametros
    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

    //constructor de solo nombre y edad
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = "Carrera no especificada";
    }

    
    
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Carrera: " + carrera);
    }

    }

