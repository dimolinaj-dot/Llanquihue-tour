package model;

public class Proveedor extends Persona {
    private String rubro;

    // Constructor vacío
    public Proveedor() {}

    // Constructor sin dirección (7 parámetros)
    public Proveedor(String rut, String nombre, String apellido, String telefono, String email,
                     String rubro) {
        super(rut, nombre, apellido, telefono, email);
        this.rubro = rubro;
    }

    // Constructor con dirección (8 parámetros)
    public Proveedor(String rut, String nombre, String apellido, String telefono, String email,
                     String rubro, Direccion direccion) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.rubro = rubro;
    }

    // Constructor con objetos RUT y Direccion
    public Proveedor(String nombre, String apellido, String telefono, String email,
                     RUT rut, Direccion direccion, String rubro) {
        super(nombre, apellido, telefono, email, rut, direccion);
        this.rubro = rubro;
    }

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "rut='" + getRutString() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rubro='" + rubro + '\'' +
                ", direccion=" + (getDireccion() != null ? getDireccion().toString() : "null") +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("📦 PROVEEDOR: " + getNombre() + " " + getApellido());
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + getTelefono());
        System.out.println("   Email: " + getEmail());
        System.out.println("   Rubro: " + rubro);
        if (getDireccion() != null) {
            System.out.println("   Dirección: " + getDireccion().getDireccionCompleta());
        } else {
            System.out.println("   Dirección: No registrada");
        }
    }
}