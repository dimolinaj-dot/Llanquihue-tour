package util;

import model.RUT;

public class Validador {

    public static boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        return rut.matches("\\d{7,8}-[\\dkK]");
    }

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }
        return telefono.matches("\\d{9}");
    }

    // ✅ ESTE ES EL MÉTODO QUE ESTABA DANDO ERROR - AHORA USA String
    public static boolean validarPersona(model.Persona p) {
        if (p == null) {
            return false;
        }
        return validarRut(p.getRutString()) &&
                p.getNombre() != null && !p.getNombre().isEmpty() &&
                p.getApellido() != null && !p.getApellido().isEmpty() &&
                validarEmail(p.getEmail()) &&
                validarTelefono(p.getTelefono());
    }

    public static boolean validarPositivo(int numero) {
        return numero > 0;
    }
}