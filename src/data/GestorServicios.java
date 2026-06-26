package data;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    /**
     * Método que crea instancias de prueba de cada subclase
     * @return Lista con todos los servicios creados
     */
    public static List<ServicioTuristico> crearServiciosDePrueba() {
        List<ServicioTuristico> servicios = new ArrayList<>();

        // Crear 2 Rutas Gastronómicas
        servicios.add(new RutaGastronomica(
                "Ruta del Vino y Cerveza Artesanal",
                6,
                5
        ));

        servicios.add(new RutaGastronomica(
                "Sabores del Lago",
                4,
                3
        ));

        // Crear 2 Paseos Lacustres
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

        // Crear 2 Excursiones Culturales
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
     * Método que muestra todos los servicios por consola
     * @param servicios Lista de servicios a mostrar
     */
    public static void mostrarServicios(List<ServicioTuristico> servicios) {
        if (servicios == null || servicios.isEmpty()) {
            System.out.println("No hay servicios para mostrar.");
            return;
        }

        System.out.println("\n===== LISTA DE SERVICIOS TURÍSTICOS =====");
        for (ServicioTuristico s : servicios) {
            System.out.println(s);  // Llama automáticamente al toString() de cada subclase
        }
        System.out.println("=========================================\n");
    }
}