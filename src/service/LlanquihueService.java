package service;

import model.*;
import util.Validador;
import java.util.ArrayList;
import java.util.List;

public class LlanquihueService {
    // Colecciones para almacenar los datos
    private List<Tour> tours;
    private List<Guia> guias;
    private List<Proveedor> proveedores;
    private List<Operador> operadores;

    // Constructor - inicializa las colecciones
    public LlanquihueService() {
        this.tours = new ArrayList<>();
        this.guias = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.operadores = new ArrayList<>();
    }

    // ============================================
    // MÉTODOS PARA TOURS
    // ============================================

    public void agregarTour(Tour tour) {
        if (tour != null) {
            tours.add(tour);
        } else {
            System.out.println("Error: Tour no puede ser nulo.");
        }
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<Tour> filtrarToursPorPrecio(int precioMinimo) {
        List<Tour> resultado = new ArrayList<>();
        for (Tour t : tours) {
            if (t.getPrecio() >= precioMinimo) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    public List<Tour> filtrarToursPorTipo(String tipo) {
        List<Tour> resultado = new ArrayList<>();
        for (Tour t : tours) {
            if (t.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    public Tour buscarTourPorNombre(String nombre) {
        for (Tour t : tours) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null;
    }

    // ============================================
    // MÉTODOS PARA GUÍAS
    // ============================================

    public void agregarGuia(Guia guia) {
        if (Validador.validarPersona(guia)) {
            guias.add(guia);
        } else {
            System.out.println("Error: Guía no válido. Verifique los datos (RUT, email, teléfono).");
        }
    }

    public List<Guia> getGuias() {
        return guias;
    }

    public List<Guia> buscarGuiasPorEspecialidad(String especialidad) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia g : guias) {
            if (g.getEspecialidad().equalsIgnoreCase(especialidad)) {
                resultado.add(g);
            }
        }
        return resultado;
    }

    public List<Guia> buscarGuiasPorExperiencia(int anosMinimos) {
        List<Guia> resultado = new ArrayList<>();
        for (Guia g : guias) {
            if (g.getAnosExperiencia() >= anosMinimos) {
                resultado.add(g);
            }
        }
        return resultado;
    }

    // ============================================
    // MÉTODOS PARA PROVEEDORES
    // ============================================

    public void agregarProveedor(Proveedor proveedor) {
        if (Validador.validarPersona(proveedor)) {
            proveedores.add(proveedor);
        } else {
            System.out.println("Error: Proveedor no válido. Verifique los datos (RUT, email, teléfono).");
        }
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public List<Proveedor> buscarProveedoresPorRubro(String rubro) {
        List<Proveedor> resultado = new ArrayList<>();
        for (Proveedor p : proveedores) {
            if (p.getRubro().equalsIgnoreCase(rubro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // ============================================
    // MÉTODOS PARA OPERADORES
    // ============================================

    public void agregarOperador(Operador operador) {
        if (Validador.validarPersona(operador)) {
            operadores.add(operador);
        } else {
            System.out.println("Error: Operador no válido. Verifique los datos (RUT, email, teléfono).");
        }
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    public List<Operador> buscarOperadoresPorZona(String zona) {
        List<Operador> resultado = new ArrayList<>();
        for (Operador o : operadores) {
            if (o.getZonaTrabajo().equalsIgnoreCase(zona)) {
                resultado.add(o);
            }
        }
        return resultado;
    }

    // ============================================
    // MÉTODOS DE UTILIDAD (Mostrar todos los datos)
    // ============================================

    public void mostrarTodosLosDatos() {
        System.out.println("\n========== TOURS ==========");
        if (tours.isEmpty()) {
            System.out.println("No hay tours registrados.");
        } else {
            for (Tour t : tours) System.out.println(t);
        }

        System.out.println("\n========== GUÍAS ==========");
        if (guias.isEmpty()) {
            System.out.println("No hay guías registrados.");
        } else {
            for (Guia g : guias) System.out.println(g);
        }

        System.out.println("\n========== PROVEEDORES ==========");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            for (Proveedor p : proveedores) System.out.println(p);
        }

        System.out.println("\n========== OPERADORES ==========");
        if (operadores.isEmpty()) {
            System.out.println("No hay operadores registrados.");
        } else {
            for (Operador o : operadores) System.out.println(o);
        }
    }
}
