package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String codigoCliente;
    private String tipoCliente;
    private int puntosFidelidad;
    private List<Reserva> historialReservas;

    // Constructor vacío
    public Cliente() {
        super();
        this.historialReservas = new ArrayList<>();
    }

    // ============================================
    // CONSTRUCTOR 1: RUT como STRING (sin dirección)
    // ============================================
    public Cliente(String rutStr, String nombre, String apellido, String telefono, String email,
                   String codigoCliente, String tipoCliente) throws IllegalArgumentException {
        super(rutStr, nombre, apellido, telefono, email);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.puntosFidelidad = 0;
        this.historialReservas = new ArrayList<>();
    }

    // ============================================
    // CONSTRUCTOR 2: RUT como STRING + Dirección
    // ============================================
    public Cliente(String rutStr, String nombre, String apellido, String telefono, String email,
                   Direccion direccion, String codigoCliente, String tipoCliente) throws IllegalArgumentException {
        super(rutStr, nombre, apellido, telefono, email, direccion);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.puntosFidelidad = 0;
        this.historialReservas = new ArrayList<>();
    }

    // ============================================
    // CONSTRUCTOR 3: RUT como OBJETO (sin dirección)
    // ============================================
    public Cliente(String nombre, String apellido, String telefono, String email,
                   RUT rut, String codigoCliente, String tipoCliente) {
        super(nombre, apellido, telefono, email, rut, null);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.puntosFidelidad = 0;
        this.historialReservas = new ArrayList<>();
    }

    // ============================================
    // CONSTRUCTOR 4: RUT como OBJETO + Dirección
    // ============================================
    public Cliente(String nombre, String apellido, String telefono, String email,
                   RUT rut, Direccion direccion, String codigoCliente, String tipoCliente) {
        super(nombre, apellido, telefono, email, rut, direccion);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.puntosFidelidad = 0;
        this.historialReservas = new ArrayList<>();
    }

    // ============================================
    // GETTERS Y SETTERS
    // ============================================

    public String getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(String codigoCliente) { this.codigoCliente = codigoCliente; }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }

    public int getPuntosFidelidad() { return puntosFidelidad; }
    public void setPuntosFidelidad(int puntosFidelidad) { this.puntosFidelidad = puntosFidelidad; }

    public List<Reserva> getHistorialReservas() { return historialReservas; }
    public void setHistorialReservas(List<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }

    // ============================================
    // MÉTODOS DE NEGOCIO
    // ============================================

    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            historialReservas.add(reserva);
            int puntos = (int) (reserva.getMontoTotal() / 10000);
            this.puntosFidelidad += puntos;
        }
    }

    public void mostrarHistorialReservas() {
        if (historialReservas.isEmpty()) {
            System.out.println("   No hay reservas registradas.");
            return;
        }
        System.out.println("   Historial de reservas (" + historialReservas.size() + "):");
        for (Reserva r : historialReservas) {
            System.out.println("   - " + r.getResumen());
        }
    }

    // ============================================
    // MÉTODOS DE Registrable
    // ============================================

    @Override
    public void mostrarResumen() {
        System.out.println("👤 CLIENTE: " + getNombreCompleto());
        System.out.println("   Código: " + codigoCliente);
        System.out.println("   Tipo: " + tipoCliente);
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + getTelefono());
        System.out.println("   Email: " + getEmail());
        System.out.println("   Puntos Fidelidad: " + puntosFidelidad);
        if (getDireccion() != null) {
            System.out.println("   Dirección: " + getDireccion().getDireccionCompleta());
        }
        mostrarHistorialReservas();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoCliente='" + codigoCliente + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", puntosFidelidad=" + puntosFidelidad +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rut=" + getRutString() +
                '}';
    }
}
