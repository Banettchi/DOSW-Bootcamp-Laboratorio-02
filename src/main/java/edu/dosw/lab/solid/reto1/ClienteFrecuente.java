package edu.dosw.lab.solid.reto1;

/**
 * Cliente frecuente con 10% de descuento.
 */
public class ClienteFrecuente extends Cliente {

    @Override
    public String getTipo() {
        return "Frecuente";
    }

    @Override
    public double getDescuento() {
        return 0.10;
    }
}
