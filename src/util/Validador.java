package util;

import model.Persona;

public class Validador {

    /**
     * Valida el formato de un RUT chileno (básico)
     * Formato esperado: 12345678-9 o 12345678-k
     */
    public static boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        // Expresión regular: 7 u 8 dígitos, guion, dígito o k/K
        return rut.matches("\\d{7,8}-[\\dkK]");
    }

    /**
     * Valida que el email tenga @ y al menos un punto después
     */
    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    /**
     * Valida un teléfono chileno (9 dígitos)
     */
    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            return false;
        }
        return telefono.matches("\\d{9}");
    }

    /**
     * Valida que una Persona no sea null y que sus campos obligatorios sean válidos
     */
    public static boolean validarPersona(Persona p) {
        if (p == null) {
            return false;
        }
        return validarRut(p.getRut()) &&
                p.getNombre() != null && !p.getNombre().isEmpty() &&
                p.getApellido() != null && !p.getApellido().isEmpty() &&
                validarEmail(p.getEmail()) &&
                validarTelefono(p.getTelefono());
    }

    /**
     * Valida que un número entero sea positivo
     */
    public static boolean validarPositivo(int numero) {
        return numero > 0;
    }
}
