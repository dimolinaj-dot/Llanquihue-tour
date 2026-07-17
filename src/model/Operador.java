package model;

public class Operador extends Persona {
    private String tipoOperacion;
    private String zonaTrabajo;

    // Constructor vacío
    public Operador() {}

    // Constructor sin dirección (7 parámetros)
    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    String tipoOperacion, String zonaTrabajo) {
        super(rut, nombre, apellido, telefono, email);
        this.tipoOperacion = tipoOperacion;
        this.zonaTrabajo = zonaTrabajo;
    }

    // Constructor con dirección (8 parámetros)
    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    String tipoOperacion, String zonaTrabajo, Direccion direccion) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.tipoOperacion = tipoOperacion;
        this.zonaTrabajo = zonaTrabajo;
    }

    // Constructor con objetos RUT y Direccion
    public Operador(String nombre, String apellido, String telefono, String email,
                    RUT rut, Direccion direccion, String tipoOperacion, String zonaTrabajo) {
        super(nombre, apellido, telefono, email, rut, direccion);
        this.tipoOperacion = tipoOperacion;
        this.zonaTrabajo = zonaTrabajo;
    }

    public String getTipoOperacion() { return tipoOperacion; }
    public void setTipoOperacion(String tipoOperacion) { this.tipoOperacion = tipoOperacion; }

    public String getZonaTrabajo() { return zonaTrabajo; }
    public void setZonaTrabajo(String zonaTrabajo) { this.zonaTrabajo = zonaTrabajo; }

    @Override
    public String toString() {
        return "Operador{" +
                "rut='" + getRutString() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", zonaTrabajo='" + zonaTrabajo + '\'' +
                ", direccion=" + (getDireccion() != null ? getDireccion().toString() : "null") +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🔧 OPERADOR: " + getNombre() + " " + getApellido());
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + getTelefono());
        System.out.println("   Email: " + getEmail());
        System.out.println("   Tipo de Operación: " + tipoOperacion);
        System.out.println("   Zona de Trabajo: " + zonaTrabajo);
        if (getDireccion() != null) {
            System.out.println("   Dirección: " + getDireccion().getDireccionCompleta());
        } else {
            System.out.println("   Dirección: No registrada");
        }
    }
}