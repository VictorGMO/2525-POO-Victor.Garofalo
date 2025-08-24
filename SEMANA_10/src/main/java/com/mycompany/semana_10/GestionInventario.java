/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author victo
 */


public class GestionInventario {
   
    private String nombreArchivo;

    public GestionInventario(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // agregara un producto
    public void agregar(String producto) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            wr.write(producto);
            wr.newLine();
            System.out.println("Producto agregado correctamente.");
        } catch (IOException exp) {
            System.out.println("Error al agregar producto: " + exp.getMessage());
        }
    }

    //Servira para  mostrar el inventario 
    public void mostrarInventario() {
        try (BufferedReader mt = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("||||||| Inventario |||||||");
            while ((linea = mt.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException exp) {
            System.out.println("Error al leer inventario: " + exp.getMessage());
        }
    }

    //metodo para brrar un producto especifico
    public void eliminar(String producto) {
        try (BufferedReader el = new BufferedReader(new FileReader(nombreArchivo))) {
            ArrayList<String> lineas = new ArrayList<>(); //para ubicar la la linea de la lista
            String linea;
            while ((linea = el.readLine()) != null) {
                if (!linea.equalsIgnoreCase(producto)) {//para qu gaurde solo lo que queremos mantener
                    lineas.add(linea);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                for (String l : lineas) {
                    bw.write(l);
                    bw.newLine();
                }
            }
            System.out.println("Producto eliminado correctamente.");
        } catch (IOException exp) {
            System.out.println("Error al eliminar producto: " + exp.getMessage());
        }
    }

    //metodo para borarra todo el inventario
    public void borrarTodo() {
        try (BufferedWriter brr = new BufferedWriter(new FileWriter(nombreArchivo))) {
            
            System.out.println("Archivo borrado completamente.");
        } catch (IOException exp) {
            System.out.println("Error al borrar archivo: " + exp.getMessage());
        }
    }
}

    

