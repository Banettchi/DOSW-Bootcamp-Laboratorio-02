package edu.dosw.lab.creacionales.reto2;

/**
 * Clase Ingrediente - Representa un ingrediente para la hamburguesa.
 * 
 * Esta clase es inmutable y contiene el nombre y precio del ingrediente.
 */
public class Ingrediente {
    private final String nombre;
    private final double precio;

    public Ingrediente(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%s ($%,.0f)", nombre, precio);
    }
}
