package edu.dosw.lab.creacionales.reto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Hamburguesa - Producto inmutable construido por el Builder.
 * 
 * Esta clase representa una hamburguesa personalizada con todos sus
 * ingredientes.
 * Es inmutable: una vez creada, no se puede modificar.
 */
public class Hamburguesa {
    private final List<Ingrediente> ingredientes;

    /**
     * Constructor package-private - solo accesible desde el Builder.
     */
    Hamburguesa(List<Ingrediente> ingredientes) {
        this.ingredientes = new ArrayList<>(ingredientes);
    }

    /**
     * Retorna lista inmutable de ingredientes.
     */
    public List<Ingrediente> getIngredientes() {
        return Collections.unmodifiableList(ingredientes);
    }

    /**
     * Calcula el precio total usando Streams.
     */
    public double calcularPrecioTotal() {
        return ingredientes.stream()
                .mapToDouble(Ingrediente::getPrecio)
                .sum();
    }

    /**
     * Obtiene los nombres de los ingredientes como una cadena.
     */
    public String obtenerNombresIngredientes() {
        return ingredientes.stream()
                .map(Ingrediente::getNombre)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- HAMBURGUESA PERSONALIZADA ---\n");
        sb.append("Ingredientes seleccionados: ").append(obtenerNombresIngredientes()).append("\n");
        sb.append(String.format("Precio total: $%,.0f\n", calcularPrecioTotal()));
        sb.append("--------------------------------\n");
        sb.append("¡Disfrute su hamburguesa!");
        return sb.toString();
    }
}
