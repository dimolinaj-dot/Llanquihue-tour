package model;

public class Tour {
    private String nombre;
    private String ubicacion;
    private int precio;
    private String tipo;

    public Tour(String nombre, String ubicacion, int precio, String tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Tour{nombre='" + nombre + "', ubicacion='" + ubicacion + "', precio=" + precio + ", tipo='" + tipo + "'}";
    }
}
