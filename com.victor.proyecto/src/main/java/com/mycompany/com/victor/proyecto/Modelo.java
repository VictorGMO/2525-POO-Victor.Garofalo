/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.com.victor.proyecto;

/**
 *
 * @author victo
 */
public class Modelo {
//clase que representa una materia con su respectiva nota
    private String materia;
    private double nota;

    public Modelo(String materia, double nota) {
        this.materia = materia;
        this.nota = nota;
    }
    public String getMateria() {
        return materia;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return materia+": "+nota;
    }
}
