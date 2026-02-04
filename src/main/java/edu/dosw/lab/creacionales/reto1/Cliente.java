package edu.dosw.lab.creacionales.reto1;

public abstract class Cliente {
    protected double porcentajeDescuento;
    protected String tipo;

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularDescuento(double subtotal) {
        return subtotal * porcentajeDescuento;
    }
}
