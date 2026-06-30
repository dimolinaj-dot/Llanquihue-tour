package model;

public class PaseoLacustre extends ServicioTuristico {
    // Atributo específico
    private String tipoEmbarcacion;

    // Constructor vacío
    public PaseoLacustre() {}

    // Constructor con parámetros
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Getter y Setter
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * SOBRESCRITURA del método mostrarInformacion()
     * Esta versión es específica para PaseoLacustre
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("=== PASEO LACUSTRE ===");
        System.out.println("⛵ Nombre: " + getNombre());
        System.out.println("⏱️ Duración: " + getDuracionHoras() + " horas");
        System.out.println("🚤 Tipo de embarcación: " + tipoEmbarcacion);
        System.out.println("¡Disfruta de las aguas del sur de Chile!");
    }

    @Override
    public String toString() {
        return "PaseoLacustre{" +
                "nombre='" + getNombre() + '\'' +
                ", duracionHoras=" + getDuracionHoras() +
                ", tipoEmbarcacion='" + tipoEmbarcacion + '\'' +
                '}';
    }
}