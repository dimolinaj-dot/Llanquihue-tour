package data;

import model.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

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
                    tours.add(new Tour(partes[0].trim(), partes[1].trim(),
                            Integer.parseInt(partes[2].trim()), partes[3].trim()));
                }
            }
            System.out.println("✅ " + tours.size() + " tours cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar tours: " + e.getMessage());
        }
        return tours;
    }

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
                    guias.add(new Guia(partes[0].trim(), partes[1].trim(), partes[2].trim(),
                            partes[3].trim(), partes[4].trim(), partes[5].trim(),
                            Integer.parseInt(partes[6].trim())));
                }
            }
            System.out.println("✅ " + guias.size() + " guías cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar guías: " + e.getMessage());
        }
        return guias;
    }

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
                    proveedores.add(new Proveedor(partes[0].trim(), partes[1].trim(), partes[2].trim(),
                            partes[3].trim(), partes[4].trim(), partes[5].trim()));
                }
            }
            System.out.println("✅ " + proveedores.size() + " proveedores cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar proveedores: " + e.getMessage());
        }
        return proveedores;
    }

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
                    operadores.add(new Operador(partes[0].trim(), partes[1].trim(), partes[2].trim(),
                            partes[3].trim(), partes[4].trim(), partes[5].trim(), partes[6].trim()));
                }
            }
            System.out.println("✅ " + operadores.size() + " operadores cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar operadores: " + e.getMessage());
        }
        return operadores;
    }

    public List<Cliente> cargarClientes(String archivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 13) {
                    String codigo = partes[0].trim();
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String rutStr = partes[5].trim();
                    String calle = partes[6].trim();
                    String numero = partes[7].trim();
                    String comuna = partes[8].trim();
                    String ciudad = partes[9].trim();
                    String region = partes[10].trim();
                    String tipoCliente = partes[11].trim();
                    int puntos = Integer.parseInt(partes[12].trim());

                    Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
                    Cliente cliente = new Cliente(rutStr, nombre, apellido, telefono, email,
                            dir, codigo, tipoCliente);
                    cliente.setPuntosFidelidad(puntos);
                    clientes.add(cliente);
                }
            }
            System.out.println("✅ " + clientes.size() + " clientes cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public List<Empleado> cargarEmpleados(String archivo) {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 14) {
                    String codigo = partes[0].trim();
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String telefono = partes[3].trim();
                    String email = partes[4].trim();
                    String rutStr = partes[5].trim();
                    String calle = partes[6].trim();
                    String numero = partes[7].trim();
                    String comuna = partes[8].trim();
                    String ciudad = partes[9].trim();
                    String region = partes[10].trim();
                    String cargo = partes[11].trim();
                    double sueldo = Double.parseDouble(partes[12].trim());
                    String fecha = partes[13].trim();

                    Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
                    Empleado emp = new Empleado(rutStr, nombre, apellido, telefono, email,
                            dir, codigo, cargo, sueldo, fecha);
                    empleados.add(emp);
                }
            }
            System.out.println("✅ " + empleados.size() + " empleados cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar empleados: " + e.getMessage());
        }
        return empleados;
    }

    public List<PaqueteTuristico> cargarPaquetes(String archivo) {
        List<PaqueteTuristico> paquetes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    paquetes.add(new PaqueteTuristico(partes[0].trim(), partes[1].trim(),
                            partes[2].trim(), Double.parseDouble(partes[3].trim()),
                            Integer.parseInt(partes[4].trim())));
                }
            }
            System.out.println("✅ " + paquetes.size() + " paquetes cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar paquetes: " + e.getMessage());
        }
        return paquetes;
    }

    public List<Reserva> cargarReservas(String archivo, List<Cliente> clientes, List<PaqueteTuristico> paquetes) {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 6) {
                    String codRes = partes[0].trim();
                    String codCli = partes[1].trim();
                    String codPaq = partes[2].trim();
                    String fecha = partes[3].trim();
                    int personas = Integer.parseInt(partes[4].trim());
                    String estado = partes[5].trim();

                    Cliente c = buscarCliente(clientes, codCli);
                    PaqueteTuristico p = buscarPaquete(paquetes, codPaq);

                    if (c != null && p != null) {
                        Reserva r = new Reserva(codRes, c, p, fecha, personas, estado);
                        reservas.add(r);
                        c.agregarReserva(r);
                    }
                }
            }
            System.out.println("✅ " + reservas.size() + " reservas cargadas.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar reservas: " + e.getMessage());
        }
        return reservas;
    }

    public List<Vehiculo> cargarVehiculos(String archivo) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(archivo),
                        StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    vehiculos.add(new Vehiculo(partes[0].trim(), partes[1].trim(),
                            Integer.parseInt(partes[2].trim()), partes[3].trim()));
                }
            }
            System.out.println("✅ " + vehiculos.size() + " vehículos cargados.");
        } catch (Exception e) {
            System.err.println("❌ Error al cargar vehículos: " + e.getMessage());
        }
        return vehiculos;
    }

    private Cliente buscarCliente(List<Cliente> clientes, String codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigoCliente().equals(codigo)) return c;
        }
        return null;
    }

    private PaqueteTuristico buscarPaquete(List<PaqueteTuristico> paquetes, String codigo) {
        for (PaqueteTuristico p : paquetes) {
            if (p.getCodigoPaquete().equals(codigo)) return p;
        }
        return null;
    }
}