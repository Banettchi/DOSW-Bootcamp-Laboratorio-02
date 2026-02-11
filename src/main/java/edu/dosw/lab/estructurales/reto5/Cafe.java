package edu.dosw.lab.estructurales.reto5;

/**
 * Interfaz Componente base - Define el contrato para todos los cafés.
 * Esta es la interfaz que el Decorator decorará.
 */
public interface Cafe {

    /**
     * Retorna la descripción del café con todos sus ingredientes.
     */
    String getDescripcion();

    /**
     * Retorna el precio total del café.
     */
    double getPrecio();
}
