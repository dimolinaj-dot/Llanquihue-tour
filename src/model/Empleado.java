package model;

public class Empleado extends Persona {
    private String codigoEmpleado;
    private String cargo;
    private double sueldoBase;
    private String fechaContratacion;

    public Empleado() { super(); }

    // Constructor 1: RUT como STRING (sin dirección)
    public Empleado(String rutStr, String nombre, String apellido, String telefono, String email,
                    String codigoEmpleado, String cargo, double sueldoBase, String fechaContratacion) {
        super(rutStr, nombre, apellido, telefono, email);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
        this.fechaContratacion = fechaContratacion;
    }

    // Constructor 2: RUT como STRING + Dirección
    public Empleado(String rutStr, String nombre, String apellido, String telefono, String email,
                    Direccion direccion, String codigoEmpleado, String cargo,
                    double sueldoBase, String fechaContratacion) {
        super(rutStr, nombre, apellido, telefono, email, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
        this.fechaContratacion = fechaContratacion;
    }

    // Constructor 3: RUT como OBJETO
    public Empleado(String nombre, String apellido, String telefono, String email,
                    RUT rut, Direccion direccion, String codigoEmpleado, String cargo,
                    double sueldoBase, String fechaContratacion) {
        super(nombre, apellido, telefono, email, rut, direccion);
        this.codigoEmpleado = codigoEmpleado;
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
        this.fechaContratacion = fechaContratacion;
    }

    // Getters y Setters
    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public double calcularSueldoConBonificacion() {
        return sueldoBase * 1.10;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("👤 EMPLEADO: " + getNombreCompleto());
        System.out.println("   Código: " + codigoEmpleado);
        System.out.println("   Cargo: " + cargo);
        System.out.println("   RUT: " + getRutString());
        System.out.println("   Teléfono: " + getTelefono());
        System.out.println("   Email: " + getEmail());
        System.out.println("   Sueldo Base: $" + String.format("%,.0f", sueldoBase));
        System.out.println("   Fecha Contratación: " + fechaContratacion);
        if (getDireccion() != null) {
            System.out.println("   Dirección: " + getDireccion().getDireccionCompleta());
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", sueldoBase=" + sueldoBase +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rut=" + getRutString() +
                '}';
    }
}

