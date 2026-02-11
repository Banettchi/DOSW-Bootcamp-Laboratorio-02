package edu.dosw.lab.creacionales.reto3;

/**
 * Enum para las categorías de vehículos.
 */
public enum Categoria {
    ECONOMICO("Económico"),
    LUJO("Lujo"),
    USADO("Usado");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
