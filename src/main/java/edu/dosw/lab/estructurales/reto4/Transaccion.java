package edu.dosw.lab.estructurales.reto4;

/**
 * Representa una transacción de cambio de moneda.
 */
public class Transaccion {
    private final double montoOriginal;
    private final Moneda monedaOrigen;
    private final Moneda monedaDestino;
    private final double montoConvertido;

    public Transaccion(double montoOriginal, Moneda monedaOrigen, Moneda monedaDestino, double montoConvertido) {
        this.montoOriginal = montoOriginal;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoConvertido = montoConvertido;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    @Override
    public String toString() {
        return String.format("%.0f %s → %.2f %s",
                montoOriginal, monedaOrigen.name(),
                montoConvertido, monedaDestino.name());
    }
}
