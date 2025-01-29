/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class GestorTareas {
    //creamos la lista en la que se almacenaran los datos
    private final ArrayList<Tarea>tareas=new ArrayList<>();
    private final int nextId=1;
    
    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }
    
  public void eliminarTarea(int id) {
        tareas.removeIf(t -> t.getId() == id); // Elimina la tarea por ID
    }

    // Método para marcar una tarea como completada
    public void completarTarea(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                break;
            }
        }
    }

    // Método para obtener la lista de tareas
    public ArrayList<Tarea> getTareas() {
        return tareas; // Devuelve la lista de tareas
    }
}

