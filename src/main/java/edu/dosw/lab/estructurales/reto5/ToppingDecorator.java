package edu.dosw.lab.estructurales.reto5;

/**
 * PATRÓN DECORATOR - Clase abstracta base para los toppings.
 * 
 * Categoría del patrón: ESTRUCTURAL
 * Patrón utilizado: DECORATOR
 * 
 * Justificación:
 * - Permite agregar toppings al café sin modificar la clase base
 * - Cada topping envuelve al café anterior, agregando funcionalidad
 * - Se pueden combinar múltiples toppings de forma flexible
 * - Cumple con el principio Open/Closed (abierto a extensión, cerrado a
 * modificación)
 * 
 * ¿Cómo se aplicó?
 * - Cafe: Interfaz Component
 * - CafeBase: Componente concreto
 * - ToppingDecorator: Decorator abstracto
 * - Cada topping concreto extiende ToppingDecorator y agrega precio/descripción
 */
public abstract class ToppingDecorator implements Cafe {

    protected final Cafe cafeDecorado;

    public ToppingDecorator(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public String getDescripcion() {
        return cafeDecorado.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return cafeDecorado.getPrecio();
    }
}
