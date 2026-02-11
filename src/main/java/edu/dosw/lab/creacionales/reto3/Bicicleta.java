package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo terrestre: Bicicleta
 */
public class Bicicleta extends VehiculoTierra {

    public Bicicleta(Categoria categoria) {
        this.modelo = "Bicicleta";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 25;
                this.precio = 500000;
                this.equipamiento = "Frenos básicos";
                break;
            case LUJO:
                this.velocidadMaxima = 45;
                this.precio = 3000000;
                this.equipamiento = "Fibra de carbono + cambios Shimano";
                break;
            case USADO:
                this.velocidadMaxima = 20;
                this.precio = 200000;
                this.equipamiento = "Sin accesorios";
                break;
        }
    }
}
