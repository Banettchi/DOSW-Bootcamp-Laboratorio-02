package edu.dosw.lab.solid.reto1;

/**
 * Clase abstracta que define el contrato para los tipos de cliente.
 * Cada tipo de cliente tiene su propio descuento.
 */
public abstract class Cliente {
    
    public abstract String getTipo();
    
    public abstract double getDescuento();
}
