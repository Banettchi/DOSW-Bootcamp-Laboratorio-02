package edu.dosw.lab.estructurales.reto5;

/**
 * Componente concreto - Café base sin toppings.
 */
public class CafeBase implements Cafe {

    @Override
    public String getDescripcion() {
        return "Café base";
    }

    @Override
    public double getPrecio() {
        return 0; // El café base no tiene costo adicional, el precio viene de los toppings
    }
}
