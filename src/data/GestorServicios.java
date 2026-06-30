package data;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    /**
     * MÉTODO 1: Crear una colección polimórfica
     * Crea 6 servicios mezclando los 3 tipos
     */
    public static List<ServicioTuristico> crearServiciosDePrueba() {
        // Crear una lista que puede contener CUALQUIER subtipo de ServicioTuristico
        List<ServicioTuristico> servicios = new ArrayList<>();

        // ===== AGREGAR RUTAS GASTRONÓMICAS =====
        servicios.add(new RutaGastronomica(
                "Ruta del Vino y Cerveza Artesanal",  // nombre
                6,                                     // duracionHoras
                5                                      // numeroDeParadas
        ));

        servicios.add(new RutaGastronomica(
                "Sabores del Lago",
                4,
                3
        ));

        // ===== AGREGAR PASEOS LACUSTRES =====
        servicios.add(new PaseoLacustre(
                "Navegación Lago Todos los Santos",
                3,
                "Catamarán"
        ));

        servicios.add(new PaseoLacustre(
                "Atardecer en el Lago Llanquihue",
                2,
                "Lancha"
        ));

        // ===== AGREGAR EXCURSIONES CULTURALES =====
        servicios.add(new ExcursionCultural(
                "Museo Pablo Fierro y Frutillar",
                4,
                "Museo Pablo Fierro"
        ));

        servicios.add(new ExcursionCultural(
                "Iglesias Patrimoniales de Chiloé",
                5,
                "Iglesia de Castro"
        ));

        System.out.println("✅ Se crearon " + servicios.size() + " servicios de prueba.");
        return servicios;
    }

    /**
     * MÉTODO 2: Mostrar servicios USANDO POLIMORFISMO
     * Recorre la lista y llama al método sobrescrito de cada objeto
     */
    public static void mostrarServicios(List<ServicioTuristico> servicios) {
        if (servicios == null || servicios.isEmpty()) {
            System.out.println("No hay servicios para mostrar.");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("   LISTA DE SERVICIOS TURÍSTICOS");
        System.out.println("   (Demostración de POLIMORFISMO)");
        System.out.println("=".repeat(50) + "\n");

        // RECORRIDO POLIMÓRFICO
        // Aunque la variable 's' es de tipo ServicioTuristico,
        // Java ejecuta el método de la clase REAL del objeto
        for (ServicioTuristico s : servicios) {
            s.mostrarInformacion();  // ← POLIMORFISMO EN ACCIÓN
            System.out.println("-".repeat(40));
        }

        System.out.println("Total de servicios: " + servicios.size());
        System.out.println("=".repeat(50) + "\n");
    }

    /**
     * MÉTODO 3: Mostrar servicios usando toString (para comparar)
     * Este método NO usa polimorfismo, solo muestra el toString()
     */
    public static void mostrarServiciosConToString(List<ServicioTuristico> servicios) {
        if (servicios == null || servicios.isEmpty()) {
            System.out.println("No hay servicios para mostrar.");
            return;
        }

        System.out.println("\n===== SERVICIOS (usando toString) =====");
        for (ServicioTuristico s : servicios) {
            System.out.println(s);
        }
    }
}