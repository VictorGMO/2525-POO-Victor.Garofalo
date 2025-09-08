/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author victo
 */
public class Biblioteca {
    private Map<String, Libro> catalogoPorIsbn;
    private Map<String, Usuario> usuariosPorId;
    private Set<String> isbnsPrestados;

    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }
    public void anadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro);
    }
    public void quitarLibro(String isbn) {
        catalogoPorIsbn.remove(isbn);
        isbnsPrestados.remove(isbn);
    }
    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u);
    }

    public void darBajaUsuario(String id) {
        usuariosPorId.remove(id);
    }

    public boolean prestarLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) return false;
        if (!catalogoPorIsbn.containsKey(isbn)) return false;
        if (isbnsPrestados.contains(isbn)) return false;

        u.getIsbnsPrestados().add(isbn);
        isbnsPrestados.add(isbn);
        return true;
    }

    public boolean devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u == null) return false;
        if (!u.getIsbnsPrestados().contains(isbn)) return false;

        u.getIsbnsPrestados().remove(isbn);
        isbnsPrestados.remove(isbn);
        return true;
    }

    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Libro> buscarPorAutor(String texto) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Libro> buscarPorCategoria(String texto) {
        List<Libro> encontrados = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().toLowerCase().contains(texto.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    public List<Libro> listarPrestados(String idUsuario) {
        Usuario u = usuariosPorId.get(idUsuario);
        List<Libro> resultado = new ArrayList<>();
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                resultado.add(catalogoPorIsbn.get(isbn));
            }
        }
        return resultado;
    }
}
