package model;

public class ColaboradorExterno extends Persona {
    private String rubro;
    private String nombreEmpresa;
    private int anosExperiencia;

    public ColaboradorExterno() {}

    public ColaboradorExterno(String rut, String nombre, String apellido, String telefono, String email,
                              String rubro, String nombreEmpresa, int anosExperiencia) {
        super(rut, nombre, apellido, telefono, email);
        this.rubro = rubro;
        this.nombreEmpresa = nombreEmpresa;
        this.anosExperiencia = anosExperiencia;
    }

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public int getAnosExperiencia() { return anosExperiencia; }
    public void setAnosExperiencia(int anosExperiencia) { this.anosExperiencia = anosExperiencia; }

    @Override
    public String toString() {
        return "ColaboradorExterno{" +
                "rut='" + getRut() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", rubro='" + rubro + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", anosExperiencia=" + anosExperiencia +
                '}';
    }

    /**
     * Sobrescribimos mostrarResumen para dar información específica
     */
    @Override
    public void mostrarResumen() {
        System.out.println("🤝 Colaborador Externo: " + getNombre() + " " + getApellido());
        System.out.println("   Rubro: " + rubro);
        System.out.println("   Empresa: " + nombreEmpresa);
        System.out.println("   Experiencia: " + anosExperiencia + " años");
    }
}