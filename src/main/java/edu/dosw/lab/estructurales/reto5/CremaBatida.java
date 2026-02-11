package edu.dosw.lab.estructurales.reto5;

/**
 * Topping concreto: Crema Batida ($2.000)
 */
public class CremaBatida extends ToppingDecorator {

    public CremaBatida(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion() + " + Crema Batida";
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio() + 2000;
    }
}
