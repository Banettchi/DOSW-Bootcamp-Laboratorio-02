package edu.dosw.lab.estructurales.reto4;

/**
 * PATRÓN ADAPTER - Adaptador de conversión de monedas.
 * 
 * Categoría del patrón: ESTRUCTURAL
 * Patrón utilizado: ADAPTER
 * 
 * Justificación:
 * - El sistema legado ("del Gringo") solo trabaja con USD como moneda base
 * - Necesitamos adaptar este sistema para que trabaje con cualquier moneda
 * - El Adapter permite que el sistema legado sea compatible con la nueva
 * interfaz
 * 
 * ¿Cómo se aplicó?
 * - ConversorMoneda: Target (interfaz que el cliente espera usar)
 * - SistemaLegadoUSD: Adaptee (sistema existente que solo conoce USD)
 * - AdaptadorCasaCambio: Adapter (adapta el sistema legado a la nueva interfaz)
 */
public class AdaptadorCasaCambio implements ConversorMoneda {

    private final SistemaLegadoUSD sistemaLegado;

    public AdaptadorCasaCambio() {
        this.sistemaLegado = new SistemaLegadoUSD();
    }

    @Override
    public double convertir(double monto, Moneda origen, Moneda destino) {
        // Primero convertimos a USD usando el sistema legado
        double montoEnUsd = sistemaLegado.convertirAUsd(monto, origen.getTasaAUsd());

        // Luego convertimos de USD a la moneda destino
        return sistemaLegado.convertirDesdeUsd(montoEnUsd, destino.getTasaAUsd());
    }
}
