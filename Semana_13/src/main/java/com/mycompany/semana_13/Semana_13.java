/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author victo
 */
public class Semana_13 extends JFrame {
    private JTextField campoTexto;
    private JButton botonAgregar, botonLimpiar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaDatos;

    public Semana_13() {
        //configuración de la ventana
        setTitle("Aplicación GUI - Semana 13"); //titulo
        setSize(400, 300);//tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //centrar ventana
        setLayout(new BorderLayout());

        //crear componentes
        JLabel etiqueta= new JLabel("Ingresa un dato:");
        campoTexto = new JTextField(15);
        botonAgregar = new JButton("Agregar");
        botonLimpiar = new JButton("Limpiar");
        modeloLista = new DefaultListModel<>();
        listaDatos = new JList<>(modeloLista);

        //panel superior de etiqueta +campo de texto
        JPanel pnlSuper=new JPanel(new FlowLayout());
        pnlSuper.add(etiqueta);
        pnlSuper.add(campoTexto);

        //panel inferior de botones
        JPanel panelInferior=new JPanel(new FlowLayout());
        panelInferior.add(botonAgregar);
        panelInferior.add(botonLimpiar);

        // Agregar todo al JFrame
        add(pnlSuper, BorderLayout.NORTH);
        add(new JScrollPane(listaDatos), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        //boton Agregar
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txt=campoTexto.getText().trim();
                if (!txt.isEmpty()) {
                    modeloLista.addElement(txt);
                    campoTexto.setText(""); //limpiar campo
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "No puedes agregar un texto vacío", 
                        "Error", JOptionPane.WARNING_MESSAGE);
                } }
        });

        //boton limpiar
        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modeloLista.clear();
                campoTexto.setText("");
            }});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Semana_13 ventana= new Semana_13();
            ventana.setVisible(true);
        });
    }
}
