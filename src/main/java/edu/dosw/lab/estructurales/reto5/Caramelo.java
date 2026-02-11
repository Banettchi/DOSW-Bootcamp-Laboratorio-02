package edu.dosw.lab.estructurales.reto5;

/**
 * Topping concreto: Caramelo ($1.200)
 */
public class Caramelo extends ToppingDecorator {

    public Caramelo(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Caramelo";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 1200;
    }
}
