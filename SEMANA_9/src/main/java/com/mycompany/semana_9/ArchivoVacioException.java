/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_9;

/**
 *
 * @author victo
 */
//excepcion personalizada que se lanza cuando un archivo esta vacio
    public class ArchivoVacioException extends Exception {
    public ArchivoVacioException(String mensaje) {
        super(mensaje);
    }}
