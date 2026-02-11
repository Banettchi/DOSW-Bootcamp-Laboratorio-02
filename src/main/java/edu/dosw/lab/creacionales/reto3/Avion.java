package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo aéreo: Avión
 */
public class Avion extends VehiculoAereo {

    public Avion(Categoria categoria) {
        this.modelo = "Avión";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 500;
                this.precio = 500000000;
                this.equipamiento = "Instrumentos básicos de vuelo";
                break;
            case LUJO:
                this.velocidadMaxima = 900;
                this.precio = 2000000000;
                this.equipamiento = "Cabina ejecutiva + entretenimiento + WiFi";
                break;
            case USADO:
                this.velocidadMaxima = 400;
                this.precio = 300000000;
                this.equipamiento = "Instrumentos estándar";
                break;
        }
    }
}
