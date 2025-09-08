/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_12;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class Usuario {
    private String id;
    private String nombre;
    private List<String> isbnsPrestados;

    public Usuario(String id, String nombre) {
        if (id == null || id.isEmpty() || nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Datos inválidos para usuario");
        }
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { return isbnsPrestados; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}