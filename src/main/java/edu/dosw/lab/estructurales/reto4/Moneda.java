package edu.dosw.lab.estructurales.reto4;

/**
 * Enum de monedas disponibles con sus tasas de cambio a USD (moneda base).
 */
public enum Moneda {
    USD("Dólar Estadounidense", 1.0),
    EUR("Euro", 1.10), // 1 EUR = 1.10 USD
    JPY("Yen Japonés", 0.006667), // 1 JPY = 0.006667 USD (150 JPY = 1 USD)
    COP("Peso Colombiano", 0.00025), // 1 COP = 0.00025 USD
    CNY("Yuan Chino", 0.14); // 1 CNY = 0.14 USD

    private final String nombre;
    private final double tasaAUsd;

    Moneda(String nombre, double tasaAUsd) {
        this.nombre = nombre;
        this.tasaAUsd = tasaAUsd;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Tasa de conversión a USD (cuántos USD vale 1 unidad de esta moneda).
     */
    public double getTasaAUsd() {
        return tasaAUsd;
    }
}
