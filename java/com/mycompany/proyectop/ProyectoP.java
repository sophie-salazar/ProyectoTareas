/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectop;


import controlador.TareasController;
import modelo.GestorTareas;
import vista.TareasVista;

public class ProyectoP {

    public static void main(String[] args) {
        // Crear el modelo y la vista
        GestorTareas modelo = new GestorTareas();
        TareasVista vista = new TareasVista();

        // Crear el controlador
        TareasController tareasController = new TareasController(modelo, vista);

        // Mostrar la vista
        vista.setVisible(true);
    }
}