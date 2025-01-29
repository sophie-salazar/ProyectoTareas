/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.GestorTareas;
import modelo.Tarea;
import vista.TareasVista;

public class TareasController {
    //llamamos a las clase del paquete Modelo y Vista
    private final GestorTareas modelo;
    private final TareasVista vista;

    public TareasController(GestorTareas modelo, TareasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }

    private void initController() {
        // Vincular los botones de la vista con sus eventos
        vista.getBtnAgregar().addActionListener(e -> agregarTarea());
        vista.getBtnCompletar().addActionListener(e -> completarTarea());
        vista.getBtnEliminar().addActionListener(e -> eliminarTarea());
    }

    private void agregarTarea() {
        String nombre = vista.getNombreTarea().getText();
        String descripcion = vista.getDescripcionTarea().getText();

        if (!nombre.isEmpty() && !descripcion.isEmpty()) {
            int nuevoId = modelo.getTareas().size() + 1;
            modelo.agregarTarea(new Tarea(nuevoId, nombre, descripcion));
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Llene todos los campos.");
        }
}
    private void completarTarea() {
        int fila = vista.getTablaTareas().getSelectedRow();
        if (fila != -1) {
            int id = (int) vista.getModeloTabla().getValueAt(fila, 0);
            modelo.completarTarea(id);
            actualizarTabla();
        }
    }

    private void eliminarTarea() {
       int fila = vista.getTablaTareas().getSelectedRow();
        if (fila != -1) {
            int id = (int) vista.getModeloTabla().getValueAt(fila, 0);
            modelo.eliminarTarea(id);
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        
        DefaultTableModel modeloTabla = vista.getModeloTabla();
    modeloTabla.setRowCount(0);

    for (Tarea tarea : modelo.getTareas()) {
        
        modeloTabla.addRow(new Object[]{
            tarea.getId(),
            tarea.getNombre(),
            tarea.getDescripcion(),
            tarea.isCompletada() ? "Completada" : "Pendiente"
            });
        }
    }
}

