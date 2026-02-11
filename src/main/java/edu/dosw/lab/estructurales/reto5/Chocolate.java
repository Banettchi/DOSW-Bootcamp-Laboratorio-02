package edu.dosw.lab.estructurales.reto5;

/**
 * Topping concreto: Chocolate ($1.500)
 */
public class Chocolate extends ToppingDecorator {

    public Chocolate(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Chocolate";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1500;
    }
}
