package edu.dosw.lab.creacionales.reto3;

/**
 * Clase abstracta base para vehículos terrestres.
 */
public abstract class VehiculoTierra implements Vehiculo {
    protected String modelo;
    protected Categoria categoria;
    protected int velocidadMaxima;
    protected double precio;
    protected String equipamiento;

    @Override
    public String getTipo() {
        return "Tierra";
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getEquipamiento() {
        return equipamiento;
    }
}
