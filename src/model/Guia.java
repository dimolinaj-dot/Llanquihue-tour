package model;

public class Guia extends Persona {
    private String especialidad;
    private int anosExperiencia;

    // Constructor vacío
    public Guia() {}

    // ============================================
    // CONSTRUCTOR CON 7 PARÁMETROS (SIN DIRECCIÓN)
    // ============================================
    public Guia(String rut, String nombre, String apellido, String telefono, String email,
                String especialidad, int anosExperiencia) {
        super(rut, nombre, apellido, telefono, email);
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
    }

    // ============================================
    // CONSTRUCTOR CON 8 PARÁMETROS (CON DIRECCIÓN)
    // ============================================
    public Guia(String rut, String nombre, String apellido, String telefono, String email,
                String especialidad, int anosExperiencia, Direccion direccion) {
        super(rut, nombre, apellido, telefono, email, direccion);
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
    }

    // ============================================
    // CONSTRUCTOR CON OBJETOS RUT Y DIRECCION
    // ============================================
    public Guia(String nombre, String apellido, String telefono, String email,
                RUT rut, Direccion direccion, String especialidad, int anosExperiencia) {
        super(nombre, apellido, telefono, email, rut, direccion);
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
    }

    // Getters y Setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(int anosExperiencia) { this.anosExperiencia = anosExperiencia; }

    @Override
    public String toString() {
        return "Guia{" +
                "rut='" + getRutString() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", anosExperiencia=" + anosExperiencia +
                ", direccion=" + (getDireccion() != null ? getDireccion().toString() : "null") +
                '}';
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🧑‍🏫 GUÍA: " + getNombre() + " " + getApellido());
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + getTelefono());
        System.out.println("   Email: " + getEmail());
        System.out.println("   Especialidad: " + especialidad);
        System.out.println("   Años de experiencia: " + anosExperiencia);
        if (getDireccion() != null) {
            System.out.println("   Dirección: " + getDireccion().getDireccionCompleta());
        } else {
            System.out.println("   Dirección: No registrada");
        }
    }
}