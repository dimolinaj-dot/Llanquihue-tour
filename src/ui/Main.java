package ui;

import data.GestorDatos;
import model.Tour;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LLANQUIHUE TOUR - CATÁLOGO ===\n");
        GestorDatos gestor = new GestorDatos();
        List<Tour> todos = gestor.getTours();

        System.out.println("--- LISTA COMPLETA ---");
        for (Tour t : todos) System.out.println(t);

        System.out.println("\n--- PRECIO MAYOR A 70.000 ---");
        List<Tour> caros = gestor.filtrarPorPrecioMinimo(70000);
        for (Tour t : caros) System.out.println(t.getNombre() + " - $" + t.getPrecio());

        System.out.println("\n--- TOURS GASTRONÓMICOS ---");
        List<Tour> gastro = gestor.filtrarPorTipo("gastronomico");
        for (Tour t : gastro) System.out.println(t.getNombre() + " - " + t.getTipo());
    }
}
