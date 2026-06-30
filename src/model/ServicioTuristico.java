package model;

public class ServicioTuristico {
    // Atributos comunes
    private String nombre;
    private int duracionHoras;

    // Constructor vacío
    public ServicioTuristico() {}

    // Constructor con parámetros
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * Método que muestra la información del servicio.
     * SERÁ SOBRESCRITO por las subclases.
     */
    public void mostrarInformacion() {
        System.out.println("Servicio Turístico: " + nombre);
        System.out.println("Duración: " + duracionHoras + " horas");
    }

    @Override
    public String toString() {
        return "ServicioTuristico{" +
                "nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras +
                '}';
    }
}
