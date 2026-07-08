package model;

/**
 * Interfaz que establece el contrato para todas las entidades
 * que pueden ser registradas en el sistema.
 */
public interface Registrable {
    /**
     * Método que debe ser implementado por cada clase
     * para mostrar un resumen de la entidad.
     */
    void mostrarResumen();
}
