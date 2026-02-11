package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo aéreo: Helicóptero
 */
public class Helicoptero extends VehiculoAereo {

    public Helicoptero(Categoria categoria) {
        this.modelo = "Helicóptero";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 180;
                this.precio = 300000000;
                this.equipamiento = "Instrumentos básicos + radio";
                break;
            case LUJO:
                this.velocidadMaxima = 280;
                this.precio = 800000000;
                this.equipamiento = "Cabina VIP + sistema de navegación avanzado";
                break;
            case USADO:
                this.velocidadMaxima = 150;
                this.precio = 180000000;
                this.equipamiento = "Instrumentos estándar";
                break;
        }
    }
}
