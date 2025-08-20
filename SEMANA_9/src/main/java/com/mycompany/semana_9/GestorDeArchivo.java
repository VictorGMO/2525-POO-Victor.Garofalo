/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author victo
 */
public class GestorDeArchivo {

/*
 void guardar (String contenido){
     
 }
    void leer (){
        
    }
    void validar (){
*/
    
    
//guarda contenido en un archivo

    public void guardar(String nombreArchivo, String contenido) {
        try (BufferedWriter guarda= new BufferedWriter(new FileWriter(nombreArchivo))) {
            guarda.write(contenido);
            System.out.println("-Archivo guardado correctamente-");
        } catch (IOException e) {
            System.out.println("error al guardar el archivo: " + e.getMessage());
        }
    }

     //Lee el contenido de un archivo línea por línea.

    public String leer(String nombreArchivo) {
        StringBuilder contenid=new StringBuilder();
        try (BufferedReader reader=new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea=reader.readLine()) != null) {
                contenid.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenid.toString();
    }
}
