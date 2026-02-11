package edu.dosw.lab.creacionales.reto3;

/**
 * Vehículo terrestre: Auto
 */
public class Auto extends VehiculoTierra {

    public Auto(Categoria categoria) {
        this.modelo = "Auto";
        this.categoria = categoria;

        switch (categoria) {
            case ECONOMICO:
                this.velocidadMaxima = 120;
                this.precio = 25000000;
                this.equipamiento = "Aire acondicionado básico";
                break;
            case LUJO:
                this.velocidadMaxima = 180;
                this.precio = 50000000;
                this.equipamiento = "Aire acondicionado + GPS";
                break;
            case USADO:
                this.velocidadMaxima = 100;
                this.precio = 15000000;
                this.equipamiento = "Radio básico";
                break;
        }
    }
}
