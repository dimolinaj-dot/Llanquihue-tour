package ui;

import data.GestorDatos;
import data.GestorServicios;
import model.*;
import service.LlanquihueService;

import javax.swing.SwingUtilities;  // ← NUEVO IMPORT para la GUI
import java.util.List;
import java.util.Scanner;

public class Main {
    private static LlanquihueService service = new LlanquihueService();
    private static GestorDatos gestor = new GestorDatos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   LLANQUIHUE TOUR - SISTEMA DE GESTIÓN   ");
        System.out.println("==========================================\n");

        // Cargar datos desde archivos
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
    // CARGA DE DATOS DESDE ARCHIVOS
    // ============================================
    private static void cargarDatos() {
        System.out.println("📂 Cargando datos desde archivos...\n");

        // Cargar Tours
        List<Tour> tours = gestor.cargarTours("tours.txt");
        for (Tour t : tours) {
            service.agregarTour(t);
        }

        // Cargar Guías
        List<Guia> guias = gestor.cargarGuias("guias.txt");
        for (Guia g : guias) {
            service.agregarGuia(g);
        }

        // Cargar Proveedores
        List<Proveedor> proveedores = gestor.cargarProveedores("proveedores.txt");
        for (Proveedor p : proveedores) {
            service.agregarProveedor(p);
        }

        // Cargar Operadores
        List<Operador> operadores = gestor.cargarOperadores("operadores.txt");
        for (Operador o : operadores) {
            service.agregarOperador(o);
        }

        System.out.println("\n✅ ¡Todos los datos cargados correctamente!\n");
    }

    // ============================================
    // MENÚ PRINCIPAL
    // ============================================
    private static void mostrarMenu() {
        System.out.println("===== MENÚ PRINCIPAL =====");
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
        System.out.println("14. Abrir Interfaz Gráfica (Semana 8)");  // ← NUEVA LÍNEA
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
            case 1:
                service.mostrarTodosLosDatos();
                break;
            case 2:
                buscarToursPorPrecio();
                break;
            case 3:
                buscarToursPorTipo();
                break;
            case 4:
                buscarGuiasPorEspecialidad();
                break;
            case 5:
                buscarGuiasPorExperiencia();
                break;
            case 6:
                buscarProveedoresPorRubro();
                break;
            case 7:
                buscarOperadoresPorZona();
                break;
            case 8:
                mostrarTours();
                break;
            case 9:
                mostrarGuias();
                break;
            case 10:
                mostrarProveedores();
                break;
            case 11:
                mostrarOperadores();
                break;
            case 12:
                mostrarServiciosTuristicos();
                break;
            case 13:
                mostrarServiciosConPolimorfismo();
                break;
            case 14:                                    // ← NUEVO CASO
                abrirInterfazGrafica();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("❌ Opción inválida. Intente nuevamente.");
        }
        System.out.println();
    }

    // ============================================
    // MÉTODOS DE BÚSQUEDA Y FILTRADO
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
                for (Tour t : resultados) {
                    System.out.println(t);
                }
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
            for (Tour t : resultados) {
                System.out.println(t);
            }
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
            for (Guia g : resultados) {
                System.out.println(g);
            }
        }
    }

    private static void buscarGuiasPorExperiencia() {
        try {
            System.out.print("Ingrese años mínimos de experiencia: ");
            int anos = Integer.parseInt(scanner.nextLine());
            List<Guia> resultados = service.buscarGuiasPorExperiencia(anos);
            if (resultados.isEmpty()) {
                System.out.println("No se encontraron guías con " + anos + " o más años de experiencia.");
            } else {
                System.out.println("\n=== GUÍAS CON " + anos + " O MÁS AÑOS DE EXPERIENCIA ===");
                for (Guia g : resultados) {
                    System.out.println(g);
                }
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
            for (Proveedor p : resultados) {
                System.out.println(p);
            }
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
            for (Operador o : resultados) {
                System.out.println(o);
            }
        }
    }

    // ============================================
    // MÉTODOS PARA MOSTRAR LISTAS COMPLETAS
    // ============================================

    private static void mostrarTours() {
        System.out.println("\n=== LISTA DE TOURS ===");
        List<Tour> tours = service.getTours();
        if (tours.isEmpty()) {
            System.out.println("No hay tours registrados.");
        } else {
            for (Tour t : tours) {
                System.out.println(t);
            }
        }
    }

    private static void mostrarGuias() {
        System.out.println("\n=== LISTA DE GUÍAS ===");
        List<Guia> guias = service.getGuias();
        if (guias.isEmpty()) {
            System.out.println("No hay guías registrados.");
        } else {
            for (Guia g : guias) {
                System.out.println(g);
            }
        }
    }

    private static void mostrarProveedores() {
        System.out.println("\n=== LISTA DE PROVEEDORES ===");
        List<Proveedor> proveedores = service.getProveedores();
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor p : proveedores) {
                System.out.println(p);
            }
        }
    }

    private static void mostrarOperadores() {
        System.out.println("\n=== LISTA DE OPERADORES ===");
        List<Operador> operadores = service.getOperadores();
        if (operadores.isEmpty()) {
            System.out.println("No hay operadores registrados.");
        } else {
            for (Operador o : operadores) {
                System.out.println(o);
            }
        }
    }

    // ============================================
    // MÉTODO PARA MOSTRAR SERVICIOS TURÍSTICOS (Semana 6)
    // ============================================
    private static void mostrarServiciosTuristicos() {
        System.out.println("\n=== SERVICIOS TURÍSTICOS ===");
        List<ServicioTuristico> servicios = GestorServicios.crearServiciosDePrueba();
        GestorServicios.mostrarServiciosConToString(servicios);
    }

    // ============================================
    // MÉTODO PARA MOSTRAR SERVICIOS CON POLIMORFISMO (Semana 7)
    // ============================================
    private static void mostrarServiciosConPolimorfismo() {
        System.out.println("\n=== SERVICIOS TURÍSTICOS - DEMOSTRACIÓN DE POLIMORFISMO ===");
        List<ServicioTuristico> servicios = GestorServicios.crearServiciosDePrueba();
        GestorServicios.mostrarServicios(servicios);
    }

    // ============================================
    // MÉTODO PARA ABRIR LA INTERFAZ GRÁFICA (Semana 8)  ← NUEVO
    // ============================================
    private static void abrirInterfazGrafica() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaGUI();  // Abre la ventana gráfica
            }
        });
    }
}