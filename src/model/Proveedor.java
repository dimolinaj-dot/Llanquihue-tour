package model;

public class Proveedor extends Persona {
    // Atributos adicionales
    private String rubro;
    private String direccion;

    // Constructor vacío
    public Proveedor() {}

    // Constructor con parámetros
    public Proveedor(String rut, String nombre, String apellido, String telefono, String email,
                     String rubro, String direccion) {
        super(rut, nombre, apellido, telefono, email);
        this.rubro = rubro;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // Método toString
    @Override
    public String toString() {
        return "Proveedor{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", rubro='" + rubro + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
