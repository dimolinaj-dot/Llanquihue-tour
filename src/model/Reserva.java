package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una reserva de un paquete turístico.
 * Utiliza composición: una reserva tiene un Cliente y un PaqueteTuristico.
 */
public class Reserva implements Registrable {
    private String codigoReserva;
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private String fechaReserva;
    private String fechaViaje;
    private int numeroPersonas;
    private String estado;  // "Confirmada", "Pendiente", "Cancelada"
    private double montoTotal;

    // ============================================
    // CONSTRUCTORES
    // ============================================

    // Constructor vacío
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(String codigoReserva, Cliente cliente, PaqueteTuristico paquete,
                   String fechaViaje, int numeroPersonas, String estado) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.paquete = paquete;
        this.fechaReserva = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.fechaViaje = fechaViaje;
        this.numeroPersonas = numeroPersonas;
        this.estado = estado;
        this.montoTotal = calcularMontoTotal();
    }

    // ============================================
    // GETTERS Y SETTERS
    // ============================================

    public String getCodigoReserva() { return codigoReserva; }
    public void setCodigoReserva(String codigoReserva) { this.codigoReserva = codigoReserva; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public PaqueteTuristico getPaquete() { return paquete; }
    public void setPaquete(PaqueteTuristico paquete) { this.paquete = paquete; }

    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(String fechaViaje) { this.fechaViaje = fechaViaje; }

    public int getNumeroPersonas() { return numeroPersonas; }
    public void setNumeroPersonas(int numeroPersonas) { this.numeroPersonas = numeroPersonas; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    // ============================================
    // MÉTODOS DE NEGOCIO
    // ============================================

    /**
     * Calcula el monto total de la reserva
     */
    public double calcularMontoTotal() {
        if (paquete == null) return 0;
        return paquete.calcularPrecioTotal() * numeroPersonas;
    }

    /**
     * Obtiene un resumen corto de la reserva (para mostrar en listas)
     */
    public String getResumen() {
        return codigoReserva + " - " +
                (cliente != null ? cliente.getNombreCompleto() : "Sin cliente") +
                " - " + (paquete != null ? paquete.getNombre() : "Sin paquete") +
                " - $" + String.format("%,.0f", montoTotal);
    }

    /**
     * Confirma la reserva
     */
    public void confirmar() {
        this.estado = "Confirmada";
    }

    /**
     * Cancela la reserva
     */
    public void cancelar() {
        this.estado = "Cancelada";
    }

    // ============================================
    // MÉTODOS IMPLEMENTADOS DE Registrable
    // ============================================

    @Override
    public void mostrarResumen() {
        System.out.println("📋 RESERVA: " + codigoReserva);
        System.out.println("   Cliente: " + (cliente != null ? cliente.getNombreCompleto() : "No asignado"));
        System.out.println("   Paquete: " + (paquete != null ? paquete.getNombre() : "No asignado"));
        System.out.println("   Fecha Reserva: " + fechaReserva);
        System.out.println("   Fecha Viaje: " + fechaViaje);
        System.out.println("   Personas: " + numeroPersonas);
        System.out.println("   Estado: " + estado);
        System.out.println("   Monto Total: $" + String.format("%,.0f", montoTotal));
    }

    // ============================================
    // MÉTODO toString()
    // ============================================

    @Override
    public String toString() {
        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", cliente=" + (cliente != null ? cliente.getNombreCompleto() : "null") +
                ", paquete=" + (paquete != null ? paquete.getNombre() : "null") +
                ", fechaViaje='" + fechaViaje + '\'' +
                ", estado='" + estado + '\'' +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
