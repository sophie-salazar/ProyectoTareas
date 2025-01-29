### PROYECTO TAREAS

Este proyecto es una aplicación de escritorio desarrollada en Java utilizando el patrón arquitectónico Modelo-Vista-Controlador (MVC) y componentes gráficos de Swing. La aplicación permite a los usuarios gestionar tareas de manera eficiente con funcionalidades básicas como agregar, listar, actualizar y eliminar tareas.

Estructura del Proyecto
El proyecto está organizado siguiendo el patrón MVC para mantener una estructura modular y facilitar la escalabilidad.
1. Modelo
El modelo contiene las clases que representan los datos y la lógica de negocio.
Clase Tarea
Define una tarea con los siguientes atributos:
•	id: Identificador único de la tarea.
•	nombre: Nombre de la tarea.
•	descripcion: Descripción detallada de la tarea.
•	completada: Estado de la tarea (true si está completada, false si sigue pendiente).
public class Tarea {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean completada;

    public Tarea(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = false;
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }
    
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
Clase GestorTareas
Esta clase gestiona la lista de tareas y proporciona métodos para manipularlas.
import java.util.ArrayList;
public class GestorTareas {
    private ArrayList<Tarea> tareas;
    private int idCounter = 1;
    
    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }
    
    public void agregarTarea(String nombre, String descripcion) {
        tareas.add(new Tarea(idCounter++, nombre, descripcion));
    }
    
    public ArrayList<Tarea> listarTareas() {
        return tareas;
    }
    
    public void marcarCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                break;
            }
        }
    }
    
    public void eliminarTarea(int id) {
        tareas.removeIf(tarea -> tarea.getId() == id);
    }
}
2. Vista
La interfaz gráfica de la aplicación está implementada en la clase MainView y utiliza JFrame, JTable, JTextField, JTextArea y JButton para permitir la interacción del usuario.
Componentes Principales
•	JFrame: Ventana principal de la aplicación.
•	JTable: Tabla que muestra la lista de tareas.
•	JTextField y JTextArea: Campos para ingresar nombre y descripción de la tarea.
•	JButton: Botones para agregar, completar y eliminar tareas.
•	JScrollPane: Para manejar desplazamiento en la tabla.
import javax.swing.*;
import java.awt.*;
public class MainView extends JFrame {
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTable tablaTareas;
    private JButton btnAgregar, btnCompletar, btnEliminar;

    public MainView() {
        setTitle("Gestor de Tareas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel superior con formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea();
        panelFormulario.add(new JScrollPane(txtDescripcion));
        add(panelFormulario, BorderLayout.NORTH);
        
        // Tabla de tareas
        String[] columnas = {"ID", "Nombre", "Descripción", "Estado"};
        tablaTareas = new JTable(new Object[][]{}, columnas);
        add(new JScrollPane(tablaTareas), BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnCompletar = new JButton("Completar");
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnCompletar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
3. Controlador
La clase TareasController maneja la lógica de interacción entre la vista y el modelo.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TareasController {
    private GestorTareas modelo;
    private MainView vista;
    
    public TareasController(GestorTareas modelo, MainView vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }
    
    private void initController() {
        vista.getBtnAgregar().addActionListener(e -> agregarTarea());
        vista.getBtnCompletar().addActionListener(e -> completarTarea());
        vista.getBtnEliminar().addActionListener(e -> eliminarTarea());
    }
    
    private void agregarTarea() {
        String nombre = vista.getTxtNombre().getText();
        String descripcion = vista.getTxtDescripcion().getText();
        modelo.agregarTarea(nombre, descripcion);
        actualizarVista();
    }
    
    private void completarTarea() {
        // Lógica para marcar tarea como completada
    }
    
    private void eliminarTarea() {
        // Lógica para eliminar tarea
    }
}
Cómo ejecutar la aplicación
1.	Asegúrate de tener Java 8 o superior instalado.
2.	Clona el repositorio y abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, NetBeans).
3.	Compila y ejecuta la aplicación.
Funcionalidades Implementadas
•	Agregar tareas mediante un formulario.
•	Listar tareas en una tabla interactiva.
•	Marcar tareas como completadas con un botón.
•	Eliminar tareas de la lista.
•	Interfaz gráfica intuitiva con diseño adaptado a usuario.
Autor: Sophie Salazar
Repositorio: Sophie-Salazar
