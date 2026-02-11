package edu.dosw.lab.solid.reto1;

/**
 * Cliente nuevo con 5% de descuento.
 */
public class ClienteNuevo extends Cliente {

    @Override
    public String getTipo() {
        return "Nuevo";
    }

    @Override
    public double getDescuento() {
        return 0.05;
    }
}
