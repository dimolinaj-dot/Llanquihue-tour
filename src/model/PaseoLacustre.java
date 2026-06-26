package model;

public class PaseoLacustre extends ServicioTuristico {
    // Atributo específico de paseos lacustres
    private String tipoEmbarcacion;

    // Constructor vacío
    public PaseoLacustre() {}

    // Constructor con parámetros (usando super para heredar)
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);  // Llama al constructor de ServicioTuristico
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Getter y Setter
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Sobrescribir toString para mostrar información completa
    @Override
    public String toString() {
        return "PaseoLacustre{" +
                "nombre='" + getNombre() + '\'' +
                ", duracionHoras=" + getDuracionHoras() +
                ", tipoEmbarcacion='" + tipoEmbarcacion + '\'' +
                '}';
    }
}
