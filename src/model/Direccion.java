package model;

/**
 * Clase que representa una dirección física.
 * Se usa por composición dentro de Persona.
 */
public class Direccion {
    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;
    private String region;

    // Constructor vacío
    public Direccion() {}

    // Constructor con parámetros
    public Direccion(String calle, String numero, String comuna, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.region = region;
    }

    // Getters y Setters
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    /**
     * Retorna la dirección en formato legible
     */
    public String getDireccionCompleta() {
        return calle + " " + numero + ", " + comuna + ", " + ciudad + ", " + region;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", comuna='" + comuna + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
