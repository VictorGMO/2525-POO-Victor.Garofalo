/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.victor.proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victo
 */
public class Servicio {
    //registrar materias,obtener notas y calcular promedio
    private List<Modelo> listaNot;

    public Servicio() {
        listaNot = new ArrayList<>();
    }

    public void agregarNota(String materia, double nota) {
        listaNot.add(new Modelo(materia, nota));
    }

    public List<Modelo> obtenerNotas() {
        return listaNot;
    }

    public boolean hayNotas() {
        return !listaNot.isEmpty();
    }

    public double calcularPromedio() {
        if (listaNot.isEmpty()) return 0;
        double suma = 0;
        for (Modelo m : listaNot) {
            suma += m.getNota();
        }
        return suma / listaNot.size();
    }
}
