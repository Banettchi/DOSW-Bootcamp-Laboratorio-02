package edu.dosw.lab.estructurales.reto5;

/**
 * Topping personalizado - Permite agregar toppings con nombre y precio
 * dinámico.
 */
public class ToppingPersonalizado extends ToppingDecorator {

    private final String nombre;
    private final double precio;

    public ToppingPersonalizado(Cafe cafe, String nombre, double precio) {
        super(cafe);
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + " + nombre;
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + precio;
    }
}
