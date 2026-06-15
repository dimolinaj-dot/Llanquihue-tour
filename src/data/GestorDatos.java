package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Tour> tours;

    public GestorDatos() {
        tours = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("tours.txt");
        if (inputStream == null) {
            System.err.println("ERROR: No se encontró tours.txt");
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
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
                }
            }
            System.out.println("Se cargaron " + tours.size() + " tours.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tour> getTours() { return tours; }

    public List<Tour> filtrarPorTipo(String tipoBuscado) {
        List<Tour> resultado = new ArrayList<>();
        for (Tour t : tours) {
            if (t.getTipo().equalsIgnoreCase(tipoBuscado)) resultado.add(t);
        }
        return resultado;
    }

    public List<Tour> filtrarPorPrecioMinimo(int precioMinimo) {
        List<Tour> resultado = new ArrayList<>();
        for (Tour t : tours) {
            if (t.getPrecio() >= precioMinimo) resultado.add(t);
        }
        return resultado;
    }
}
