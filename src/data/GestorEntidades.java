package data;

import model.Registrable;
import model.Vehiculo;
import model.Persona;
import model.Guia;
import model.ColaboradorExterno;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private List<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
        cargarDatosPrueba();
    }

    /**
     * Carga algunos objetos de prueba para demostrar la funcionalidad.
     */
    private void cargarDatosPrueba() {
        // Guías
        entidades.add(new Guia("11.111.111-1", "Carlos", "Pérez", "912345678", "carlos@email.com", "Gastronomía", 8));
        entidades.add(new Guia("22.222.222-2", "Ana", "López", "923456789", "ana@email.com", "Cultural", 5));
        // Vehículos
        entidades.add(new Vehiculo("AB-12-CD", "Toyota Hilux", 5, "Diésel"));
        entidades.add(new Vehiculo("XY-98-ZW", "Mercedes Sprinter", 15, "Gasolina"));
        // Colaboradores Externos
        entidades.add(new ColaboradorExterno("33.333.333-3", "Luis", "Gómez", "934567890", "luis@email.com",
                "Transporte", "Buses del Sur", 10));
        entidades.add(new ColaboradorExterno("44.444.444-4", "María", "Fernández", "945678901", "maria@email.com",
                "Alimentación", "Catering Lago", 4));
    }

    /**
     * Agrega una entidad a la colección.
     */
    public void agregarEntidad(Registrable entidad) {
        if (entidad != null) {
            entidades.add(entidad);
            System.out.println("✅ Entidad agregada correctamente.");
        }
    }

    /**
     * Obtiene la lista completa de entidades.
     */
    public List<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Recorre la colección y muestra los resúmenes.
     * DEMOSTRACIÓN DE POLIMORFISMO E instanceof
     */
    public void mostrarTodosLosResumenes() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE ENTIDADES REGISTRADAS =====");
        System.out.println("(Demostración de POLIMORFISMO e instanceof)\n");

        for (Registrable r : entidades) {
            // Usamos instanceof para identificar el tipo específico
            if (r instanceof Guia) {
                System.out.print("🧑‍🏫 [GUÍA] ");
            } else if (r instanceof Vehiculo) {
                System.out.print("🚗 [VEHÍCULO] ");
            } else if (r instanceof ColaboradorExterno) {
                System.out.print("🤝 [COLABORADOR] ");
            } else if (r instanceof Persona) {
                System.out.print("👤 [PERSONA] ");
            } else {
                System.out.print("📄 [REGISTRABLE] ");
            }

            // Llamada polimórfica al método sobrescrito
            r.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total de entidades: " + entidades.size());
    }
}
