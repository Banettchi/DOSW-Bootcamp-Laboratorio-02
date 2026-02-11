package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo aéreo: Avioneta
 */
public class Avioneta extends VehiculoAereo {

    public Avioneta(Categoria categoria) {
        this.modelo = "Avioneta";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 250;
                this.precio = 150000000;
                this.equipamiento = "Instrumentos básicos de vuelo";
                break;
            case LUJO:
                this.velocidadMaxima = 350;
                this.precio = 400000000;
                this.equipamiento = "Cabina confortable + GPS avanzado";
                break;
            case USADO:
                this.velocidadMaxima = 200;
                this.precio = 80000000;
                this.equipamiento = "Instrumentos estándar";
                break;
        }
    }
}
