package edu.dosw.lab.estructurales.reto4;

/**
 * Interfaz Target del patrón Adapter.
 * Define el contrato para convertir monedas.
 */
public interface ConversorMoneda {

    /**
     * Convierte un monto de una moneda origen a una moneda destino.
     * 
     * @param monto   Cantidad a convertir
     * @param origen  Moneda de origen
     * @param destino Moneda de destino
     * @return Monto convertido
     */
    double convertir(double monto, Moneda origen, Moneda destino);
}
