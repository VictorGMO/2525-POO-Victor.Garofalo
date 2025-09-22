/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_14;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victo
 */
public class Semana_14 extends JFrame {

    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextField txtDescripcion;
    private JButton btnAgregar, btnEliminar, btnSalir;

    public Semana_14() {
        setTitle("Agenda Personal");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Parte superior,entrada de datos 
        JPanel panelEntrada=new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel lblFecha=new JLabel("Fecha (dd/MM/yyyy):");
        spinnerFecha=new JSpinner(new SpinnerDateModel());
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));

        JLabel lblHora=new JLabel("Hora (HH:mm):");
        spinnerHora=new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));

        JLabel lblDescripcion =new JLabel("Descripcion:");
        txtDescripcion =new JTextField();

        panelEntrada.add(lblFecha);
        panelEntrada.add(spinnerFecha);
        panelEntrada.add(lblHora);
        panelEntrada.add(spinnerHora);
        panelEntrada.add(lblDescripcion);
        panelEntrada.add(txtDescripcion);

        add(panelEntrada, BorderLayout.NORTH);

        //Tabla 
        modeloTabla =new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0);
        tablaEventos =new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaEventos);
        add(scroll, BorderLayout.CENTER);

        //botones
        JPanel panelBotones =new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnAgregar =new JButton("Agregar");
        btnEliminar=new JButton("Eliminar seleccionado");
        btnSalir= new JButton("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

        //eventos
        btnAgregar.addActionListener(e -> agregarEvento());
        btnEliminar.addActionListener(e -> eliminarEvento());
        btnSalir.addActionListener(e -> dispose());
    }

    private void agregarEvento() {
        String descripcion= txtDescripcion.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La descripción no puede estar vacía",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return;}

        Date fecha=(Date) spinnerFecha.getValue();
        Date hora=(Date) spinnerHora.getValue();

       SimpleDateFormat formatoFecha =new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora=new SimpleDateFormat("H:mm");
        String fechaStr = formatoFecha.format(fecha);
        String horaStr = formatoHora.format(hora);

        modeloTabla.addRow(new Object[]{fechaStr, horaStr, descripcion});

        txtDescripcion.setText("");
        txtDescripcion.requestFocus();}

    private void eliminarEvento() {
        int filaSeleccionada=tablaEventos.getSelectedRow();
        if (filaSeleccionada== -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un evento primero",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirmacion=JOptionPane.showConfirmDialog(this,
                "¿Eliminar el evento seleccionado?",
                "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Semana_14().setVisible(true));
    }}
