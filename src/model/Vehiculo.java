package model;

public class Vehiculo implements Registrable {
    private String patente;
    private String modelo;
    private int capacidadPasajeros;
    private String tipoCombustible;

    public Vehiculo() {}

    public Vehiculo(String patente, String modelo, int capacidadPasajeros, String tipoCombustible) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipoCombustible = tipoCombustible;
    }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidadPasajeros=" + capacidadPasajeros +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🚗 Vehículo: " + modelo + " (Patente: " + patente + ")");
        System.out.println("   Capacidad: " + capacidadPasajeros + " pasajeros");
        System.out.println("   Combustible: " + tipoCombustible);
    }
}
