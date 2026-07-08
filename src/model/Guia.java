package model;

public class Guia extends Persona {
    // Atributos adicionales
    private String especialidad;
    private int anosExperiencia;

    // Constructor vacío
    public Guia() {}

    // Constructor con parámetros (incluye los de Persona)
    public Guia(String rut, String nombre, String apellido, String telefono, String email,
                String especialidad, int anosExperiencia) {
        // Llamar al constructor de Persona
        super(rut, nombre, apellido, telefono, email);
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
    }

    // Getters y Setters
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(int anosExperiencia) { this.anosExperiencia = anosExperiencia; }

    // Método toString (sobrescrito)
    @Override
    public String toString() {
        return "Guia{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", anosExperiencia=" + anosExperiencia +
                '}';
    }
    @Override
    public void mostrarResumen() {
        System.out.println("🧑‍🏫 Guía: " + getNombre() + " " + getApellido());
        System.out.println("   Especialidad: " + getEspecialidad());
        System.out.println("   Años de experiencia: " + getAnosExperiencia());
    }
}
