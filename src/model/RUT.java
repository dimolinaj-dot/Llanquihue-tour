package model;

public class RUT {
    private String rut;

    public RUT(String rut) throws IllegalArgumentException {
        if (!validarRUT(rut)) {
            throw new IllegalArgumentException("RUT invalido: " + rut);
        }
        this.rut = rut;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) {
        if (!validarRUT(rut)) {
            throw new IllegalArgumentException("RUT invalido: " + rut);
        }
        this.rut = rut;
    }

    public static boolean validarRUT(String rut) {
        if (rut == null || rut.isEmpty()) return false;
        String rutLimpio = rut.replaceAll("[.\\s-]", "");
        if (rutLimpio.length() < 8 || rutLimpio.length() > 9) return false;
        String cuerpo = rutLimpio.substring(0, rutLimpio.length() - 1);
        String dv = rutLimpio.substring(rutLimpio.length() - 1);
        if (!cuerpo.matches("\\d+")) return false;
        return validarDigitoVerificador(cuerpo, dv);
    }

    private static boolean validarDigitoVerificador(String cuerpo, String dv) {
        int suma = 0;
        int multiplicador = 2;
        for (int i = cuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(cuerpo.charAt(i)) * multiplicador;
            multiplicador++;
            if (multiplicador > 7) multiplicador = 2;
        }
        int resto = suma % 11;
        int dvEsperado = 11 - resto;
        if (dvEsperado == 11) dvEsperado = 0;
        if (dvEsperado == 10) return dv.equalsIgnoreCase("K");
        return Integer.toString(dvEsperado).equals(dv);
    }

    @Override
    public String toString() {
        return rut;
    }
}