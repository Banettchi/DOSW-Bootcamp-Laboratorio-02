package edu.dosw.lab.estructurales.reto5;

/**
 * Topping concreto: Leche ($1.000)
 */
public class Leche extends ToppingDecorator {

    public Leche(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Leche";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1000;
    }
}
