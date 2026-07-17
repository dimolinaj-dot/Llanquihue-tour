package model;

public class Persona implements Registrable {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private RUT rut;
    private Direccion direccion;

    // ============================================
    // CONSTRUCTORES (SIN DUPLICADOS)
    // ============================================

    // 1. Constructor vacío
    public Persona() {}

    // 2. Constructor con RUT como String (sin dirección)
    public Persona(String rutStr, String nombre, String apellido, String telefono, String email)
            throws IllegalArgumentException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rut = new RUT(rutStr);
        this.direccion = null;
    }

    // 3. Constructor con RUT como String y Dirección
    public Persona(String rutStr, String nombre, String apellido, String telefono, String email,
                   Direccion direccion) throws IllegalArgumentException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rut = new RUT(rutStr);
        this.direccion = direccion;
    }

    // 4. Constructor con objetos RUT y Direccion ya creados
    public Persona(String nombre, String apellido, String telefono, String email,
                   RUT rut, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.rut = rut;
        this.direccion = direccion;
    }

    // ============================================
    // GETTERS Y SETTERS
    // ============================================

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public RUT getRut() { return rut; }
    public void setRut(RUT rut) { this.rut = rut; }

    public void setRut(String rutStr) throws IllegalArgumentException {
        this.rut = new RUT(rutStr);
    }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    public String getRutString() {
        return rut != null ? rut.toString() : "Sin RUT";
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // ============================================
    // MÉTODOS DE Registrable
    // ============================================

    @Override
    public void mostrarResumen() {
        System.out.println("👤 PERSONA: " + getNombreCompleto());
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + telefono);
        System.out.println("   Email: " + email);
        if (direccion != null) {
            System.out.println("   Dirección: " + direccion.getDireccionCompleta());
        } else {
            System.out.println("   Dirección: No registrada");
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", rut=" + (rut != null ? rut.toString() : "null") +
                ", direccion=" + (direccion != null ? direccion.toString() : "null") +
                '}';
    }
}