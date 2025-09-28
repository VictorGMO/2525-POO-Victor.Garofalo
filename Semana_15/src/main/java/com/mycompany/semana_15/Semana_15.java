/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.semana_15;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
/**
 *
 * @author victo
 */
public class Semana_15 extends JFrame {
    private DefaultListModel<String> tareasMdl;
    private JList<String> listTarea;    
    private JTextField campoEntrada;

    public Semana_15() {
        setTitle("LISTA DE TAREAS");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tareasMdl=new DefaultListModel<>();
        listTarea=new JList<>(tareasMdl);
        listTarea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTarea.setCellRenderer(new TaskCellRenderer());
        campoEntrada=new JTextField();

        JButton botonAgregar=new JButton("Añadir Tarea");
        JButton botonCompletar=new JButton("Marcar como completada");
        JButton botonEliminar=new JButton("Eliminar tarea");

        JPanel panelSuperior=new JPanel(new BorderLayout());
        panelSuperior.add(campoEntrada, BorderLayout.CENTER);
        panelSuperior.add(botonAgregar, BorderLayout.EAST);

        JPanel panelInferior=new JPanel();
        panelInferior.add(botonCompletar);
        panelInferior.add(botonEliminar);

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(listTarea), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        botonAgregar.addActionListener(e-> agregarTarea());
        botonCompletar.addActionListener(e-> completarTarea());
        botonEliminar.addActionListener(e-> eliminarTarea());
        campoEntrada.addActionListener(e-> agregarTarea());

        listTarea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2) {
                    completarTarea();
                }}
        });
    }

    private void agregarTarea() {
        String text= campoEntrada.getText().trim();
        if (!text.isEmpty()) {
            tareasMdl.addElement("=Pendiente= " +text);
            campoEntrada.setText("");
        }}

    private void completarTarea() {
        int index=listTarea.getSelectedIndex();
        if (index !=-1) {
            String tarea=tareasMdl.getElementAt(index);
            if (!tarea.startsWith(":[Completada]")) {
                tareasMdl.set(index, "[Completada] " + tarea.substring(11));
            }}}

    private void eliminarTarea() {
        int index=listTarea.getSelectedIndex();
        if (index != -1) {
            tareasMdl.remove(index);
        }}

    private static class TaskCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label =(JLabel) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
            String tarea=value.toString();

            if (tarea.startsWith("[Completada]")) {
                label.setForeground(Color.GREEN);
                label.setFont(label.getFont().deriveFont(Font.ITALIC));
            } else {
                label.setForeground(Color.BLACK);
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
            }
            return label;
        }}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Semana_15().setVisible(true));
    }
}