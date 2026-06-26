package model;

public class ExcursionCultural extends ServicioTuristico {
    // Atributo específico de excursiones culturales
    private String lugarHistorico;

    // Constructor vacío
    public ExcursionCultural() {}

    // Constructor con parámetros (usando super para heredar)
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);  // Llama al constructor de ServicioTuristico
        this.lugarHistorico = lugarHistorico;
    }

    // Getter y Setter
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    // Sobrescribir toString para mostrar información completa
    @Override
    public String toString() {
        return "ExcursionCultural{" +
                "nombre='" + getNombre() + '\'' +
                ", duracionHoras=" + getDuracionHoras() +
                ", lugarHistorico='" + lugarHistorico + '\'' +
                '}';
    }
}