/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana_16;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author victo
 */
public class CapturaTeclaC extends JFrame {
    private JList<String> list;
    private JButton boton;
    public CapturaTeclaC() {
        setTitle("Captura tecla 'C'");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,125);
        setLocationRelativeTo(null);//centra la ventana

        //crear lista con algunos elementos
        String[] elements={"Elemento 1","Elemento 2","Elemento 3"};
        list = new JList<>(elements);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //agregar un KeyListener para detectar la tecla "C"
        list.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar()== 'c'||e.getKeyChar()=='C') {
                    int index =list.getSelectedIndex();
                    if (index !=-1) {
                        System.out.println("Presionaste 'C' sobre: " + list.getSelectedValue());
                    } else {
                        System.out.println("Presionaste 'C' pero no hay ningún elemento seleccionado.");
                    }}}});

        //crear botón (solo decorativo)
        boton = new JButton("Botón de ejemplo");

        //panel principal
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(new JScrollPane(list),BorderLayout.CENTER);
        panel.add(boton, BorderLayout.SOUTH);
        add(panel);
    }
}