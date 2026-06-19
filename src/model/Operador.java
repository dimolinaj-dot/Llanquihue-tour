package model;

public class Operador extends Persona {
    // Atributos adicionales
    private String tipoOperacion;
    private String zonaTrabajo;

    // Constructor vacío
    public Operador() {}

    // Constructor con parámetros
    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    String tipoOperacion, String zonaTrabajo) {
        super(rut, nombre, apellido, telefono, email);
        this.tipoOperacion = tipoOperacion;
        this.zonaTrabajo = zonaTrabajo;
    }

    // Getters y Setters
    public String getTipoOperacion() { return tipoOperacion; }
    public void setTipoOperacion(String tipoOperacion) { this.tipoOperacion = tipoOperacion; }

    public String getZonaTrabajo() { return zonaTrabajo; }
    public void setZonaTrabajo(String zonaTrabajo) { this.zonaTrabajo = zonaTrabajo; }

    // Método toString
    @Override
    public String toString() {
        return "Operador{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", zonaTrabajo='" + zonaTrabajo + '\'' +
                '}';
    }
}