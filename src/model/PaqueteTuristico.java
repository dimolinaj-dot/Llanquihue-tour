package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un paquete turístico que combina múltiples servicios.
 * Utiliza composición: un paquete contiene una lista de ServicioTuristico.
 */
public class PaqueteTuristico implements Registrable {
    private String codigoPaquete;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private int duracionDias;
    private List<ServicioTuristico> servicios;
    private Guia guiaAsignado;
    private Vehiculo vehiculoAsignado;

    // ============================================
    // CONSTRUCTORES
    // ============================================

    // Constructor vacío
    public PaqueteTuristico() {
        this.servicios = new ArrayList<>();
    }

    // Constructor con parámetros básicos
    public PaqueteTuristico(String codigoPaquete, String nombre, String descripcion,
                            double precioBase, int duracionDias) {
        this.codigoPaquete = codigoPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.duracionDias = duracionDias;
        this.servicios = new ArrayList<>();
    }

    // Constructor completo (con guía y vehículo)
    public PaqueteTuristico(String codigoPaquete, String nombre, String descripcion,
                            double precioBase, int duracionDias,
                            Guia guiaAsignado, Vehiculo vehiculoAsignado) {
        this.codigoPaquete = codigoPaquete;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.duracionDias = duracionDias;
        this.guiaAsignado = guiaAsignado;
        this.vehiculoAsignado = vehiculoAsignado;
        this.servicios = new ArrayList<>();
    }

    // ============================================
    // GETTERS Y SETTERS
    // ============================================

    public String getCodigoPaquete() { return codigoPaquete; }
    public void setCodigoPaquete(String codigoPaquete) { this.codigoPaquete = codigoPaquete; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public int getDuracionDias() { return duracionDias; }
    public void setDuracionDias(int duracionDias) { this.duracionDias = duracionDias; }

    public List<ServicioTuristico> getServicios() { return servicios; }
    public void setServicios(List<ServicioTuristico> servicios) { this.servicios = servicios; }

    public Guia getGuiaAsignado() { return guiaAsignado; }
    public void setGuiaAsignado(Guia guiaAsignado) { this.guiaAsignado = guiaAsignado; }

    public Vehiculo getVehiculoAsignado() { return vehiculoAsignado; }
    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) { this.vehiculoAsignado = vehiculoAsignado; }

    // ============================================
    // MÉTODOS DE NEGOCIO
    // ============================================

    /**
     * Agrega un servicio al paquete
     */
    public void agregarServicio(ServicioTuristico servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    /**
     * Calcula el precio total del paquete (precio base + costo de servicios)
     */
    public double calcularPrecioTotal() {
        double total = precioBase;
        // Cada servicio suma $10.000 al precio (ejemplo)
        total += servicios.size() * 10000;
        return total;
    }

    /**
     * Muestra los servicios del paquete
     */
    public void mostrarServicios() {
        if (servicios.isEmpty()) {
            System.out.println("   No hay servicios asignados.");
            return;
        }
        System.out.println("   Servicios incluidos (" + servicios.size() + "):");
        for (ServicioTuristico s : servicios) {
            System.out.println("   - " + s.getNombre() + " (" + s.getDuracionHoras() + " horas)");
        }
    }

    // ============================================
    // MÉTODOS IMPLEMENTADOS DE Registrable
    // ============================================

    @Override
    public void mostrarResumen() {
        System.out.println("📦 PAQUETE TURÍSTICO: " + nombre);
        System.out.println("   Código: " + codigoPaquete);
        System.out.println("   Descripción: " + descripcion);
        System.out.println("   Duración: " + duracionDias + " días");
        System.out.println("   Precio Base: $" + String.format("%,.0f", precioBase));
        System.out.println("   Precio Total: $" + String.format("%,.0f", calcularPrecioTotal()));
        if (guiaAsignado != null) {
            System.out.println("   Guía: " + guiaAsignado.getNombreCompleto());
        }
        if (vehiculoAsignado != null) {
            System.out.println("   Vehículo: " + vehiculoAsignado.getModelo() + " (" + vehiculoAsignado.getPatente() + ")");
        }
        mostrarServicios();
    }

    // ============================================
    // MÉTODO toString()
    // ============================================

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "codigoPaquete='" + codigoPaquete + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioBase=" + precioBase +
                ", duracionDias=" + duracionDias +
                ", numServicios=" + servicios.size() +
                '}';
    }
}

