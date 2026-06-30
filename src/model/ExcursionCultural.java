package model;

public class ExcursionCultural extends ServicioTuristico {
    // Atributo específico
    private String lugarHistorico;

    // Constructor vacío
    public ExcursionCultural() {}

    // Constructor con parámetros
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    // Getter y Setter
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * SOBRESCRITURA del método mostrarInformacion()
     * Esta versión es específica para ExcursionCultural
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("=== EXCURSIÓN CULTURAL ===");
        System.out.println("🏛️ Nombre: " + getNombre());
        System.out.println("⏱️ Duración: " + getDuracionHoras() + " horas");
        System.out.println("📜 Lugar histórico: " + lugarHistorico);
        System.out.println("¡Sumérgete en la historia y cultura de la zona!");
    }

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                "nombre='" + getNombre() + '\'' +
                ", duracionHoras=" + getDuracionHoras() +
                ", lugarHistorico='" + lugarHistorico + '\'' +
                '}';
    }
}