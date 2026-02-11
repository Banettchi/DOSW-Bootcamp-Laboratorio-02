package edu.dosw.lab.estructurales.reto5;

/**
 * Topping concreto: Menta ($1.300)
 */
public class Menta extends ToppingDecorator {

    public Menta(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Menta";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1300;
    }
}
