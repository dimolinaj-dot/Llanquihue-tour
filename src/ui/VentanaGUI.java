package ui;

import data.GestorEntidades;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGUI extends JFrame {
    private GestorEntidades gestor;

    // Componentes de la GUI
    private JTextArea areaTexto;
    private JButton btnAgregarGuia;
    private JButton btnAgregarVehiculo;
    private JButton btnMostrarTodos;

    public VentanaGUI() {
        gestor = new GestorEntidades();
        configurarVentana();
        inicializarComponentes();
        setVisible(true);
    }

    private void configurarVentana() {
        setTitle("Llanquihue Tour - Gestión de Entidades");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAgregarGuia = new JButton("Agregar Guía");
        btnAgregarVehiculo = new JButton("Agregar Vehículo");
        btnMostrarTodos = new JButton("Mostrar Resúmenes");

        panelBotones.add(btnAgregarGuia);
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnMostrarTodos);
        add(panelBotones, BorderLayout.NORTH);

        // Área de texto para mostrar resultados
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        // Acción del botón "Agregar Guía"
        btnAgregarGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarGuia();
            }
        });

        // Acción del botón "Agregar Vehículo"
        btnAgregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        // Acción del botón "Mostrar Resúmenes"
        btnMostrarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumenes();
            }
        });

        // Mostrar datos iniciales de prueba
        mostrarResumenes();
    }

    private void agregarGuia() {
        try {
            String rut = JOptionPane.showInputDialog(this, "Ingrese RUT del guía:");
            String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre:");
            String apellido = JOptionPane.showInputDialog(this, "Ingrese apellido:");
            String telefono = JOptionPane.showInputDialog(this, "Ingrese teléfono:");
            String email = JOptionPane.showInputDialog(this, "Ingrese email:");
            String especialidad = JOptionPane.showInputDialog(this, "Ingrese especialidad:");
            int anos = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese años de experiencia:"));

            Guia guia = new Guia(rut, nombre, apellido, telefono, email, especialidad, anos);
            gestor.agregarEntidad(guia);
            mostrarResumenes();
            JOptionPane.showMessageDialog(this, "✅ Guía agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "❌ Error: Ingrese un número válido para años de experiencia.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
        }
    }

    private void agregarVehiculo() {
        try {
            String patente = JOptionPane.showInputDialog(this, "Ingrese patente:");
            String modelo = JOptionPane.showInputDialog(this, "Ingrese modelo:");
            int capacidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese capacidad de pasajeros:"));
            String combustible = JOptionPane.showInputDialog(this, "Ingrese tipo de combustible:");

            Vehiculo vehiculo = new Vehiculo(patente, modelo, capacidad, combustible);
            gestor.agregarEntidad(vehiculo);
            mostrarResumenes();
            JOptionPane.showMessageDialog(this, "✅ Vehículo agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "❌ Error: Ingrese un número válido para capacidad.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
        }
    }

    private void mostrarResumenes() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== ENTIDADES REGISTRADAS =====\n\n");

        for (Registrable r : gestor.getEntidades()) {
            // Usamos instanceof para identificar el tipo y agregar un prefijo visual
            if (r instanceof Guia) {
                sb.append("🧑‍🏫 [GUÍA] ");
            } else if (r instanceof Vehiculo) {
                sb.append("🚗 [VEHÍCULO] ");
            } else if (r instanceof ColaboradorExterno) {
                sb.append("🤝 [COLABORADOR] ");
            } else if (r instanceof Persona) {
                sb.append("👤 [PERSONA] ");
            } else {
                sb.append("📄 [REGISTRABLE] ");
            }

            // Usamos toString() para mostrar los detalles
            sb.append(r.toString()).append("\n");
            sb.append("-----------------------------------------\n");
        }
        sb.append("\nTotal: ").append(gestor.getEntidades().size()).append(" entidades.");

        areaTexto.setText(sb.toString());
    }

    // Para ejecutar la GUI de forma independiente (opcional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaGUI();
            }
        });
    }
}
