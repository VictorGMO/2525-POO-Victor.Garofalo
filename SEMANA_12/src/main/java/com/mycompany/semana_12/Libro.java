/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_12;

/**
 *
 * @author victo
 */
public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || isbn.isEmpty() ||
            titulo == null || titulo.isEmpty() ||
            autor == null || autor.isEmpty() ||
            categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Datos inválidos para libro");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titulo + " - " + autor + " (" + categoria + ")";
    }
}