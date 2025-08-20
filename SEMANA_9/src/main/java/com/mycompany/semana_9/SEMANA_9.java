/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_9;

/**
 *
 * @author victo
 */
public class SEMANA_9 {

    public static void main(String[] args) {
        GestorDeArchivo gestor=new GestorDeArchivo();
        ValidadorArchivo validador=new ValidadorArchivo();
        String nombreArchivo = "Archivito.txt";
        String contenido = "Holiii este seria el ejemplo del archivo xd.";

        try {
            //guarda contenido en el archivo
            gestor.guardar(nombreArchivo,contenido);

            //lee el contenido
            String texto = gestor.leer(nombreArchivo);
            System.out.println("Contenido del archivo:\n" + texto);

            //verifica si el archivo esta vacío
            validador.verificarNoVacio(nombreArchivo);
            System.out.println("El archivo no esta vacio.");

        } catch (ArchivoVacioException xd) {
            System.out.println("Excepcion: " + xd.getMessage());
        } catch (Exception e) {
            System.out.println("error inesperado: " + e.getMessage());
        }} 
}
