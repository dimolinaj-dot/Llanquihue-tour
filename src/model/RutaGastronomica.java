package model;

public class RutaGastronomica extends ServicioTuristico {
    // Atributo específico de rutas gastronómicas
    private int numeroDeParadas;

    // Constructor vacío
    public RutaGastronomica() {}

    // Constructor con parámetros (usando super para heredar)
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);  // Llama al constructor de ServicioTuristico
        this.numeroDeParadas = numeroDeParadas;
    }

    // Getter y Setter
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    // Sobrescribir toString para mostrar información completa
    @Override
    public String toString() {
        return "RutaGastronomica{" +
                "nombre='" + getNombre() + '\'' +
                ", duracionHoras=" + getDuracionHoras() +
                ", numeroDeParadas=" + numeroDeParadas +
                '}';
    }
}
