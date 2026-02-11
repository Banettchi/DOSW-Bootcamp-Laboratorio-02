package edu.dosw.lab.creacionales.reto2;

import java.util.ArrayList;
import java.util.List;

public class HamburguesaBuilder {
    private final List<Ingrediente> ingredientes;

    public HamburguesaBuilder() {
        this.ingredientes = new ArrayList<>();
    }

    /**
     * Agrega un ingrediente a la hamburguesa.
     */
    public HamburguesaBuilder agregarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        return this;
    }

    /**
     * Agrega un ingrediente por nombre y precio.
     */
    public HamburguesaBuilder agregarIngrediente(String nombre, double precio) {
        this.ingredientes.add(new Ingrediente(nombre, precio));
        return this;
    }

    /**
     * Construye y retorna la hamburguesa final.
     * Valida que tenga al menos un ingrediente.
     */
    public Hamburguesa build() {
        if (ingredientes.isEmpty()) {
            throw new IllegalStateException("La hamburguesa debe tener al menos un ingrediente");
        }
        return new Hamburguesa(ingredientes);
    }
}
