package ui;

import data.GestorDatos;
import data.GestorServicios;
import model.*;
import service.LlanquihueService;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static LlanquihueService service = new LlanquihueService();
    private static GestorDatos gestor = new GestorDatos();
    private static Scanner scanner = new Scanner(System.in);

    // Listas para datos de la EFT
    private static List<Cliente> clientes;
    private static List<Empleado> empleados;
    private static List<PaqueteTuristico> paquetes;
    private static List<Reserva> reservas;
    private static List<Vehiculo> vehiculos;

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   LLANQUIHUE TOUR - SISTEMA DE GESTIÓN   ");
        System.out.println("==========================================\n");

        cargarDatos();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);

        System.out.println("\n👋 ¡Hasta luego!");
        scanner.close();
    }

    // ============================================
    // CARGA DE DATOS
    // ============================================
    private static void cargarDatos() {
        System.out.println("📂 Cargando datos desde archivos...\n");

        // Datos existentes
        List<Tour> tours = gestor.cargarTours("tours.txt");
        for (Tour t : tours) service.agregarTour(t);

        List<Guia> guias = gestor.cargarGuias("guias.txt");
        for (Guia g : guias) service.agregarGuia(g);

        List<Proveedor> proveedores = gestor.cargarProveedores("proveedores.txt");
        for (Proveedor p : proveedores) service.agregarProveedor(p);

        List<Operador> operadores = gestor.cargarOperadores("operadores.txt");
        for (Operador o : operadores) service.agregarOperador(o);

        // Nuevos datos EFT
        vehiculos = gestor.cargarVehiculos("vehiculos.txt");
        if (vehiculos == null) vehiculos = new java.util.ArrayList<>();

        clientes = gestor.cargarClientes("clientes.txt");
        if (clientes == null) clientes = new java.util.ArrayList<>();

        empleados = gestor.cargarEmpleados("empleados.txt");
        if (empleados == null) empleados = new java.util.ArrayList<>();

        paquetes = gestor.cargarPaquetes("paquetes.txt");
        if (paquetes == null) paquetes = new java.util.ArrayList<>();

        reservas = gestor.cargarReservas("reservas.txt", clientes, paquetes);
        if (reservas == null) reservas = new java.util.ArrayList<>();

        System.out.println("\n✅ ¡Todos los datos cargados correctamente!\n");
        System.out.println("📊 Resumen:");
        System.out.println("   - Tours: " + tours.size());
        System.out.println("   - Guías: " + guias.size());
        System.out.println("   - Proveedores: " + proveedores.size());
        System.out.println("   - Operadores: " + operadores.size());
        System.out.println("   - Vehículos: " + vehiculos.size());
        System.out.println("   - Clientes: " + clientes.size());
        System.out.println("   - Empleados: " + empleados.size());
        System.out.println("   - Paquetes: " + paquetes.size());
        System.out.println("   - Reservas: " + reservas.size());
        System.out.println();
    }

    // ============================================
    // MENÚ
    // ============================================
    private static void mostrarMenu() {
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("--- DATOS EXISTENTES ---");
        System.out.println("1.  Mostrar todos los datos");
        System.out.println("2.  Buscar tours por precio mínimo");
        System.out.println("3.  Buscar tours por tipo");
        System.out.println("4.  Buscar guías por especialidad");
        System.out.println("5.  Buscar guías por años de experiencia");
        System.out.println("6.  Buscar proveedores por rubro");
        System.out.println("7.  Buscar operadores por zona de trabajo");
        System.out.println("8.  Mostrar todos los tours");
        System.out.println("9.  Mostrar todos los guías");
        System.out.println("10. Mostrar todos los proveedores");
        System.out.println("11. Mostrar todos los operadores");
        System.out.println("12. Mostrar servicios turísticos (Semana 6)");
        System.out.println("13. Mostrar servicios con polimorfismo (Semana 7)");
        System.out.println("14. Abrir Interfaz Gráfica (Semana 8)");
        System.out.println("--- NUEVAS OPCIONES EFT ---");
        System.out.println("15. Mostrar todos los clientes");
        System.out.println("16. Mostrar todos los empleados");
        System.out.println("17. Mostrar todos los vehículos");
        System.out.println("18. Mostrar todos los paquetes turísticos");
        System.out.println("19. Mostrar todas las reservas");
        System.out.println("20. Mostrar resumen de cliente específico");
        System.out.println("21. Mostrar resumen de reserva específica");
        System.out.println("22. Mostrar resumen de todos (polimorfismo)");
        System.out.println("0.  Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ============================================
    // PROCESAR OPCIÓN
    // ============================================
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: service.mostrarTodosLosDatos(); break;
            case 2: buscarToursPorPrecio(); break;
            case 3: buscarToursPorTipo(); break;
            case 4: buscarGuiasPorEspecialidad(); break;
            case 5: buscarGuiasPorExperiencia(); break;
            case 6: buscarProveedoresPorRubro(); break;
            case 7: buscarOperadoresPorZona(); break;
            case 8: mostrarTours(); break;
            case 9: mostrarGuias(); break;
            case 10: mostrarProveedores(); break;
            case 11: mostrarOperadores(); break;
            case 12: mostrarServiciosTuristicos(); break;
            case 13: mostrarServiciosConPolimorfismo(); break;
            case 14: abrirInterfazGrafica(); break;
            case 15: mostrarClientes(); break;
            case 16: mostrarEmpleados(); break;
            case 17: mostrarVehiculos(); break;
            case 18: mostrarPaquetes(); break;
            case 19: mostrarReservas(); break;
            case 20: mostrarResumenCliente(); break;
            case 21: mostrarResumenReserva(); break;
            case 22: mostrarResumenTodos(); break;
            case 0: System.out.println("Saliendo..."); break;
            default: System.out.println("❌ Opción inválida."); break;
        }
        System.out.println();
    }

    // ============================================
    // MÉTODOS DE BÚSQUEDA
    // ============================================

    private static void buscarToursPorPrecio() {
        try {
            System.out.print("Ingrese precio mínimo: ");
            int precio = Integer.parseInt(scanner.nextLine());
            List<Tour> resultados = service.filtrarToursPorPrecio(precio);
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron tours con precio >= " + precio);
            } else {
                System.out.println("\n=== TOURS CON PRECIO >= " + precio + " ===");
                for (Tour t : resultados) System.out.println(t);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Ingrese un número válido.");
        }
    }

    private static void buscarToursPorTipo() {
        System.out.print("Ingrese tipo de tour (gastronomico, cultural, lacustre, relax): ");
        String tipo = scanner.nextLine();
        List<Tour> resultados = service.filtrarToursPorTipo(tipo);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tours de tipo '" + tipo + "'");
        } else {
            System.out.println("\n=== TOURS DE TIPO '" + tipo + "' ===");
            for (Tour t : resultados) System.out.println(t);
        }
    }

    private static void buscarGuiasPorEspecialidad() {
        System.out.print("Ingrese especialidad (Gastronomía, Cultural, Lacustre): ");
        String especialidad = scanner.nextLine();
        List<Guia> resultados = service.buscarGuiasPorEspecialidad(especialidad);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron guías con especialidad '" + especialidad + "'");
        } else {
            System.out.println("\n=== GUÍAS DE ESPECIALIDAD '" + especialidad + "' ===");
            for (Guia g : resultados) System.out.println(g);
        }
    }

    private static void buscarGuiasPorExperiencia() {
        try {
            System.out.print("Ingrese años mínimos de experiencia: ");
            int anos = Integer.parseInt(scanner.nextLine());
            List<Guia> resultados = service.buscarGuiasPorExperiencia(anos);
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron guías con " + anos + " o más años.");
            } else {
                System.out.println("\n=== GUÍAS CON " + anos + " O MÁS AÑOS ===");
                for (Guia g : resultados) System.out.println(g);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Ingrese un número válido.");
        }
    }

    private static void buscarProveedoresPorRubro() {
        System.out.print("Ingrese rubro (Transporte, Alimentos, Hospedaje): ");
        String rubro = scanner.nextLine();
        List<Proveedor> resultados = service.buscarProveedoresPorRubro(rubro);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron proveedores con rubro '" + rubro + "'");
        } else {
            System.out.println("\n=== PROVEEDORES DE RUBRO '" + rubro + "' ===");
            for (Proveedor p : resultados) System.out.println(p);
        }
    }

    private static void buscarOperadoresPorZona() {
        System.out.print("Ingrese zona de trabajo (Llanquihue, Puerto Varas, Frutillar): ");
        String zona = scanner.nextLine();
        List<Operador> resultados = service.buscarOperadoresPorZona(zona);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron operadores en la zona '" + zona + "'");
        } else {
            System.out.println("\n=== OPERADORES EN ZONA '" + zona + "' ===");
            for (Operador o : resultados) System.out.println(o);
        }
    }

    // ============================================
    // MÉTODOS PARA MOSTRAR LISTAS
    // ============================================

    private static void mostrarTours() {
        System.out.println("\n=== LISTA DE TOURS ===");
        List<Tour> tours = service.getTours();
        if (tours.isEmpty()) {
            System.out.println("No hay tours registrados.");
        } else {
            for (Tour t : tours) System.out.println(t);
        }
    }

    private static void mostrarGuias() {
        System.out.println("\n=== LISTA DE GUÍAS ===");
        List<Guia> guias = service.getGuias();
        if (guias.isEmpty()) {
            System.out.println("No hay guías registrados.");
        } else {
            for (Guia g : guias) System.out.println(g);
        }
    }

    private static void mostrarProveedores() {
        System.out.println("\n=== LISTA DE PROVEEDORES ===");
        List<Proveedor> proveedores = service.getProveedores();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor p : proveedores) System.out.println(p);
        }
    }

    private static void mostrarOperadores() {
        System.out.println("\n=== LISTA DE OPERADORES ===");
        List<Operador> operadores = service.getOperadores();
        if (operadores.isEmpty()) {
            System.out.println("No hay operadores registrados.");
        } else {
            for (Operador o : operadores) System.out.println(o);
        }
    }

    // ============================================
    // MÉTODOS DE SEMANA 6, 7 Y 8
    // ============================================

    private static void mostrarServiciosTuristicos() {
        System.out.println("\n=== SERVICIOS TURÍSTICOS ===");
        List<ServicioTuristico> servicios = GestorServicios.crearServiciosDePrueba();
        GestorServicios.mostrarServiciosConToString(servicios);
    }

    private static void mostrarServiciosConPolimorfismo() {
        System.out.println("\n=== SERVICIOS TURÍSTICOS - DEMOSTRACIÓN DE POLIMORFISMO ===");
        List<ServicioTuristico> servicios = GestorServicios.crearServiciosDePrueba();
        GestorServicios.mostrarServicios(servicios);
    }

    private static void abrirInterfazGrafica() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaGUI();
            }
        });
    }

    // ============================================
    // NUEVOS MÉTODOS EFT
    // ============================================

    private static void mostrarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            c.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total: " + clientes.size() + " clientes.");
    }

    private static void mostrarEmpleados() {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado e : empleados) {
            e.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total: " + empleados.size() + " empleados.");
    }

    private static void mostrarVehiculos() {
        System.out.println("\n=== LISTA DE VEHÍCULOS ===");
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            v.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total: " + vehiculos.size() + " vehículos.");
    }

    private static void mostrarPaquetes() {
        System.out.println("\n=== LISTA DE PAQUETES TURÍSTICOS ===");
        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes registrados.");
            return;
        }
        for (PaqueteTuristico p : paquetes) {
            p.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total: " + paquetes.size() + " paquetes.");
    }

    private static void mostrarReservas() {
        System.out.println("\n=== LISTA DE RESERVAS ===");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        for (Reserva r : reservas) {
            r.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total: " + reservas.size() + " reservas.");
    }

    private static void mostrarResumenCliente() {
        System.out.print("Ingrese el código del cliente (ej: C001): ");
        String codigo = scanner.nextLine().trim().toUpperCase();
        Cliente encontrado = null;
        for (Cliente c : clientes) {
            if (c.getCodigoCliente().equalsIgnoreCase(codigo)) {
                encontrado = c;
                break;
            }
        }
        if (encontrado != null) {
            System.out.println("\n=== RESUMEN DEL CLIENTE ===");
            encontrado.mostrarResumen();
        } else {
            System.out.println("❌ Cliente no encontrado con código: " + codigo);
        }
    }

    private static void mostrarResumenReserva() {
        System.out.print("Ingrese el código de la reserva (ej: R001): ");
        String codigo = scanner.nextLine().trim().toUpperCase();
        Reserva encontrado = null;
        for (Reserva r : reservas) {
            if (r.getCodigoReserva().equalsIgnoreCase(codigo)) {
                encontrado = r;
                break;
            }
        }
        if (encontrado != null) {
            System.out.println("\n=== RESUMEN DE LA RESERVA ===");
            encontrado.mostrarResumen();
        } else {
            System.out.println("❌ Reserva no encontrada con código: " + codigo);
        }
    }

    private static void mostrarResumenTodos() {
        System.out.println("\n===== RESUMEN DE TODAS LAS ENTIDADES (POLIMORFISMO) =====");
        List<Registrable> todas = new java.util.ArrayList<>();
        todas.addAll(clientes);
        todas.addAll(empleados);
        todas.addAll(vehiculos);
        todas.addAll(paquetes);
        todas.addAll(reservas);
        todas.addAll(service.getGuias());
        todas.addAll(service.getProveedores());
        todas.addAll(service.getOperadores());

        if (todas.isEmpty()) {
            System.out.println("No hay entidades registradas.");
            return;
        }

        System.out.println("Total de entidades: " + todas.size() + "\n");
        for (Registrable r : todas) {
            if (r instanceof Cliente) System.out.print("👤 [CLIENTE] ");
            else if (r instanceof Empleado) System.out.print("👤 [EMPLEADO] ");
            else if (r instanceof Guia) System.out.print("🧑‍🏫 [GUÍA] ");
            else if (r instanceof Proveedor) System.out.print("📦 [PROVEEDOR] ");
            else if (r instanceof Operador) System.out.print("🔧 [OPERADOR] ");
            else if (r instanceof Vehiculo) System.out.print("🚗 [VEHÍCULO] ");
            else if (r instanceof PaqueteTuristico) System.out.print("📦 [PAQUETE] ");
            else if (r instanceof Reserva) System.out.print("📋 [RESERVA] ");
            else System.out.print("📄 [OTRO] ");
            r.mostrarResumen();
            System.out.println("-----------------------------------------");
        }
    }
}