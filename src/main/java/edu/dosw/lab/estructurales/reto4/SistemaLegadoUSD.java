package edu.dosw.lab.estructurales.reto4;

/**
 * Sistema legado que solo trabaja con USD.
 * Este es el Adaptee en el patrón Adapter.
 * 
 * El sistema "del Gringo" que solo conoce USD como moneda base.
 */
public class SistemaLegadoUSD {

    /**
     * Convierte cualquier monto a USD usando la tasa proporcionada.
     */
    public double convertirAUsd(double monto, double tasaAUsd) {
        return monto * tasaAUsd;
    }

    /**
     * Convierte USD a cualquier moneda usando la tasa proporcionada.
     */
    public double convertirDesdeUsd(double montoUsd, double tasaDestinoAUsd) {
        return montoUsd / tasaDestinoAUsd;
    }
}
