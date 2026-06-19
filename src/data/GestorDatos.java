package data;

import model.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    // ============================================
    // MÉTODO PARA CARGAR TOURS
    // ============================================
    public List<Tour> cargarTours(String archivo) {
        List<Tour> tours = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    String nombre = partes[0].trim();
                    String ubicacion = partes[1].trim();
                    int precio = Integer.parseInt(partes[2].trim());
                    String tipo = partes[3].trim();
                    tours.add(new Tour(nombre, ubicacion, precio, tipo));
                } else {
                    System.err.println("Línea ignorada (formato incorrecto): " + linea);
                }
            }
            System.out.println("✅ " + tours.size() + " tours cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar tours: " + e.getMessage());
        }
        return tours;
    }

    // ============================================
    // MÉTODO PARA CARGAR GUÍAS
    // ============================================
    public List<Guia> cargarGuias(String archivo) {
        List<Guia> guias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    String rut = partes[0].trim();
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String especialidad = partes[5].trim();
                    int anosExperiencia = Integer.parseInt(partes[6].trim());
                    guias.add(new Guia(rut, nombre, apellido, telefono, email, especialidad, anosExperiencia));
                } else {
                    System.err.println("Línea ignorada (formato incorrecto): " + linea);
                }
            }
            System.out.println("✅ " + guias.size() + " guías cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar guías: " + e.getMessage());
        }
        return guias;
    }

    // ============================================
    // MÉTODO PARA CARGAR PROVEEDORES
    // ============================================
    public List<Proveedor> cargarProveedores(String archivo) {
        List<Proveedor> proveedores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    String rut = partes[0].trim();
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String rubro = partes[5].trim();
                    String direccion = partes[6].trim();
                    proveedores.add(new Proveedor(rut, nombre, apellido, telefono, email, rubro, direccion));
                } else {
                    System.err.println("Línea ignorada (formato incorrecto): " + linea);
                }
            }
            System.out.println("✅ " + proveedores.size() + " proveedores cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar proveedores: " + e.getMessage());
        }
        return proveedores;
    }

    // ============================================
    // MÉTODO PARA CARGAR OPERADORES
    // ============================================
    public List<Operador> cargarOperadores(String archivo) {
        List<Operador> operadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    String rut = partes[0].trim();
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String tipoOperacion = partes[5].trim();
                    String zonaTrabajo = partes[6].trim();
                    operadores.add(new Operador(rut, nombre, apellido, telefono, email, tipoOperacion, zonaTrabajo));
                } else {
                    System.err.println("Línea ignorada (formato incorrecto): " + linea);
                }
            }
            System.out.println("✅ " + operadores.size() + " operadores cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar operadores: " + e.getMessage());
        }
        return operadores;
    }
}
