/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author victo
 */
public class Validar {
    //Verifica que el archivo no este vacío.
    public void verificarNoVacio(String nombreArchivo) throws Exception, IOException {
        try (BufferedReader veri=new BufferedReader(new FileReader(nombreArchivo))) {
            if (veri.readLine() ==null) { //que no hay contenido
                throw new Exception("El archivo esta vacio.");
            }
        } catch (IOException ee) {
            System.out.println("Error al verificar el archivo: " + ee.getMessage());
        }
    }
}
